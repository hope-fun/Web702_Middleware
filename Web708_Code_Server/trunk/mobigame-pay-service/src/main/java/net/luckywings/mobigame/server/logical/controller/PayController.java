/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.luckywings.mobigame.server.cas.service.vo.ChannelVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;
import net.luckywings.mobigame.server.helper.HttpClientHelper;
import net.luckywings.mobigame.server.logical.busi.service.OrderService;
import net.luckywings.mobigame.server.logical.busi.service.ThirdService;
import net.luckywings.mobigame.server.logical.busi.viewdata.HJYThirdPay;
import net.luckywings.mobigame.server.logical.response.LoginCallBackResponse;
import net.luckywings.mobigame.server.logical.response.LoginTaomiCallBackResponse;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;
import net.luckywings.mobigame.server.logical.service.mobiapi.BaseModule;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.utils.JsonUtils;

@Controller
@RequestMapping(value = "/pay/callback")
public class PayController extends BaseModule {

	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@Autowired
	private ThirdService thirdService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{channel}")
	@ResponseBody
	public Object callback(HttpServletRequest request, @PathVariable(value = "channel") long channelId) {

		Object obj = null;
		ChannelVO channel = thirdService.getChannel(channelId);
		try {
			Method method = this.getClass().getMethod("callback" + channel.getCode(), HttpServletRequest.class);
			System.out.println("callback" + channel.getCode());
			obj = method.invoke(this, request);
		} catch (Exception e) {

		}
		return obj;
	}

	public String callback9G(HttpServletRequest request) {
		logger.info("invoke success");
		// 商户订单号
		String orderid = request.getParameter("orderid");
		logger.info(String.format(orderid));
		// 支付状态，支付成功返回1，支付失败返回-1
		String status = request.getParameter("status");
		logger.info(String.format(status));
		// 签名
		String sign = request.getParameter("sign");
		logger.info(String.format(sign));
		PayOrderVO order = orderService.getOrderByOpenOrderId(orderid);
		if (order == null) {
			logger.info(String.format("Order not longer exist!"));
		}

		PayAuthVO auth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		String spkey = auth.getKey();
		String verify = DigestUtils.md5Hex(orderid + "" + status + "" + spkey);
		if (!sign.equals(verify)) {
			logger.info(String.format("Check failure"));
		} else if (sign.equals(verify) && (order.getStatues() == EnumFieldH5.ORDER_STATUS_NONPAY)) {
			order.setResultCode(status); // 1代表成功
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
		}
		return "OK";
	}

	public String callbackPlay68(HttpServletRequest request) {// 68

		String openId = request.getParameter("openid"); // 用户唯一识别ID
		String orderId = request.getParameter("orderid"); // 订单ID
		String itemId = request.getParameter("itemid"); // 商品ID
		String realItemId = itemId.split("_")[0];
		String realOrderId = itemId.split("_")[1];// 商品ID
		String itemName = null; // 商品名
		try {
			itemName = new String(request.getParameter("itemname").getBytes("ISO8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String pric = request.getParameter("price"); // 商品单价
		String c = request.getParameter("count"); // 商品数量
		String m = request.getParameter("money"); // 订单金额（玩家付款金额）
		String currency = request.getParameter("currency"); // 支付类型 暂时都是RMB
		String serid = request.getParameter("serverid"); // 游戏区服ID
		String ts = request.getParameter("ts"); // 回调时间
		String sign = request.getParameter("sign");

		logger.info(String.format(
				"PayController callbackPlay68 param. openid=%s,orderid=%s,itemid=%s,itemname=%s,pric=%s,c=%s,m=%s,currency=%s,serid=%s,ts=%s,sign=%s",
				openId, orderId, itemId, itemName, pric, c, m, currency, serid, ts, sign));

		PayOrderVO order = orderService.getOrderById(realOrderId);
		if (order == null) {
			logger.info(String.format("Order not longer exist!"));
			// return JsonUtils.toJson(new ApiRechargerResponse(1,
			// "Order not longer exist!"));
		}
		PayAuthVO auth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		String key = auth.getKey();// b92ababa363be1e416db0ace8f16fe33
		String verify = DigestUtils
				.md5Hex(c + currency + itemId + itemName + m + openId + orderId + pric + serid + ts + key);
		if (!sign.equals(verify)) {
			logger.info(String.format("Check failure"));
		} else {
			// order.setResultCode(status);// 1代表成功
			order.setOpenOrderId(orderId);
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
		}
		return JsonUtils.toJson(new LoginCallBackResponse(0, ""));
	}

	public String callbackJY(HttpServletRequest request) {
		System.out.println("----------lw");
		String roleId = request.getParameter("roleId"); // 用户唯一识别ID
		String orderId = request.getParameter("orderId"); // 平台的订单 ID
		String itemId = request.getParameter("itemId"); // 商品ID（是游戏的商品ID 和
														// 订单ID的组合）
		String realItemId = itemId.split("_")[0]; // 商品ID
		String realOrderId = itemId.split("_")[1]; // 游戏自己的订单ID
		String itemName = null; // 商品名
		try {
			itemName = new String(request.getParameter("itemName").getBytes("ISO8859-1"), "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String price = request.getParameter("price"); // 商品单价
		String count = request.getParameter("count"); // 商品数量
		String currency = request.getParameter("currency"); // 支付类型 暂时都是RMB
		String ts = request.getParameter("ts"); // 时间戳
		String sign = request.getParameter("sign");

		logger.info(String.format(
				"PayController callbackLW param. roleId=%s,orderId=%s,itemId=%s,itemName=%s,price=%s,count=%s,currency=%s,ts=%s,sign=%s",
				roleId, orderId, itemId, itemName, price, count, currency, ts, sign));

		PayOrderVO order = orderService.getOrderById(realOrderId);
		if (order == null) {
			logger.info(String.format("Order not longer exist!"));
			// return JsonUtils.toJson(new ApiRechargerResponse(1,
			// "Order not longer exist!"));
		}
		PayAuthVO auth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		String key = auth.getKey();// 150699ef40394c08851b2125
		System.out.println(key + "-----------key");
		String verify = DigestUtils.md5Hex(
				"count=" + count + "&currency=" + currency + "&itemId=" + itemId + "&itemName=" + itemName + "&orderId="
						+ orderId + "&price=" + price + "&roleId=" + roleId + "&ts=" + ts + "&key=" + key);
		System.out.println(verify + "-------------------");
		if (!sign.equals(verify)) {
			logger.info(String.format("Check failure"));
		} else {
			System.out.println(orderId);
			// order.setResultCode(status);// 1代表成功
			order.setOpenOrderId(orderId);
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
		}
		System.out.println("4444444");
		return "ok";// JY

	}

	public String callbackForgame(HttpServletRequest request) {
		logger.info("Forgame invoke success");
		String out_trade_no = request.getParameter("out_trade_no"); // H52015062417461816802
																	// 订单号
		String trade_no = request.getParameter("trade_no"); // 12345678 cp内部的订单号
		String total_fee = request.getParameter("total_fee"); // 支付价格
		String notify_time = request.getParameter("notify_time"); // 1435830761
																	// 异步通知时间
		String sign = request.getParameter("sign"); // a34b0e4975d58607fd1ec1f6a111f7ec
													// 签名，签名方法见
		logger.info(String.format(sign));
		PayOrderVO order = orderService.getOrderByOpenOrderId(out_trade_no);
		if (order == null) {
			logger.info(String.format("Order not longer exist!"));
			// return JsonUtils.toJson(new ApiRechargerResponse(1,
			// "Order not longer exist!"));
		}
		PayAuthVO auth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		String secret = auth.getKey();
		String verify = DigestUtils.md5Hex(
				"notify_time=" + notify_time + "&out_trade_no=" + out_trade_no + "&total_fee=" + total_fee + secret);
		logger.info(String.format(verify));
		if (!sign.equals(verify)) {
			logger.info(String.format("Check failure"));
			return JsonUtils.toJson("fail");
		} else {
			// order.setResultCode(status);// 1代表成功
			logger.info(String.format("you are ok"));
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
		}
		logger.info(String.format("OK"));
		return "success";
	}

	/*
	 * 钱宝(二月兰)异步回调
	 */
	public String callbackErYueLan(HttpServletRequest request) {
		String qbTransCode = request.getParameter("qbTransCode");
		String outTradeCode = request.getParameter("outTradeCode");
		String transTime = request.getParameter("transTime");
		String isSuccess = request.getParameter("isSuccess");
		String code = request.getParameter("code");
		logger.info(String.format("callBack!"));
		PayOrderVO order = null;
		if ("true".equals(isSuccess)) {
			order = orderService.getOrderByOpenOrderId(outTradeCode);
			if (order == null) {
				logger.info(String.format("Order not longer exist!"));
				// return JsonUtils.toJson(new ApiRechargerResponse(1,
				// "Order not longer exist!"));
			}
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
			logger.info(String.format("OK"));
		}
		return "success";
	}

	/*
	 * 淘米
	 */
	public String callbackTaomi(HttpServletRequest request) throws ApiException, Exception {
		logger.info("taomi invoke success");
		// 商户订单号
		String receipt_data = request.getParameter("receipt_data");
		String client_id = request.getParameter("client_id");
		logger.info(String.format("client_id=%s ", client_id));
		logger.info(String.format("receipt_data=%s ", receipt_data));
		String result = null;
		PayAuthVO payAuth = thirdService.findByfactoryServiceId(client_id);
		logger.debug(String.format("payAuth=%s ", payAuth));
		String baseURL = payAuth.getDirectURL() + "payment/verify-receipt";
		String client_secret = payAuth.getKey();
		logger.debug(String.format("Request Data , client_id=%s , client_secret=%s , baseURL=%s", client_id,
				client_secret, baseURL));
		String client_proof = DigestUtils.shaHex(client_id + receipt_data + client_secret);
		HttpPost httpRequest = new HttpPost(baseURL);
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("client_id", client_id));
		params.add(new BasicNameValuePair("client_proof", client_proof));
		params.add(new BasicNameValuePair("receipt_data", receipt_data));
		httpRequest.setEntity(new UrlEncodedFormEntity(params));
		/* 发送请求并等待响应 */
		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);

		/* 若状态码为200 ok */
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			/* 读返回数据 */
			result = EntityUtils.toString(httpResponse.getEntity());
			logger.info(result);
		} else {
			logger.info("Error Response: " + httpResponse.getStatusLine().toString());
		}
		// ApiCreateOrderTaomDataiResponse res = JsonUtils.fromJson(result,
		// ApiCreateOrderTaomDataiResponse.class);
		JSONObject jsonObject = new JSONObject(result);
		String receipt = jsonObject.getString("receipt");
		JSONObject receipt_obj = new JSONObject(receipt);
		String account = receipt_obj.getString("account");
		String payload = receipt_obj.getString("payload");
		String amount = receipt_obj.getString("amount");
		String product_id = receipt_obj.getString("product_id");
		PayOrderVO order = orderService.getOrderByOpenOrderId(payload.substring(0, 30));
		String payamount = "" + (int) order.getAmount();
		double price = Double.parseDouble(amount);
		if (product_id.equals(order.getItemId())) {
			logger.info("no change");
		} else {
			logger.info("change");
			order.setAmount(0);
			order.setItemId(product_id);
			order.setItemName("");
			order.setPrice(price);
		}

		order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
		orderService.updatePayOrder(order);
		this.thirdCallBack(order, client_secret, account);
		logger.info(String.format("OK"));
		if (receipt_data != null) {
			return JsonUtils.toJson(new LoginTaomiCallBackResponse(true));
		} else {
			return JsonUtils.toJson(new LoginTaomiCallBackResponse(false));
		}
	}

	/**
	 * Y5
	 * 
	 * @param request
	 * @return
	 */
	public String callbackY5(HttpServletRequest request) {
		logger.info("Y5 invoke success");

		// String receipt_data = request.getParameter("receipt_data");
		// String client_id = request.getParameter("client_id");
		// 三方订单
		String order_id = request.getParameter("order_id");
		logger.info(order_id);
		// 订单时间
		String order_date = URLEncoder.encode(request.getParameter("order_date"));
		logger.info(order_date);
		// appid
		String app_id = request.getParameter("app_id");
		logger.info(app_id);
		// 用户ID
		String user_id = request.getParameter("user_id");
		logger.info(user_id);
		// 道具ID
		String item_id = request.getParameter("item_id");
		logger.info(item_id);
		String server_id = request.getParameter("server_id");
		logger.info(server_id);
		String character_id = request.getParameter("character_id");
		logger.info(character_id);
		// 支付类型
		String pay_type = request.getParameter("pay_type");
		logger.info(pay_type);
		// 储值金额
		String pay_cash = request.getParameter("pay_cash");
		logger.info(pay_cash);
		// 储值点数
		String pay_point = request.getParameter("pay_point");
		logger.info(pay_point);
		String params = request.getParameter("params");
		logger.info(params);
		String sign = request.getParameter("sign");
		logger.info(sign);
		logger.info(String.format(
				"Request: order_id=%s, order_date=%s, app_id=%s,user_id=%s,item_id=%s,server_id=%s,character_id=%s,"
						+ "pay_type=%s,pay_cash=%s,pay_point=%s,params=%s,sign=%s",
				order_id, order_date, app_id, user_id, item_id, server_id, character_id, pay_type, pay_cash, pay_point,
				params, sign));
		PayOrderVO order = orderService.getOrderById(params);
		if (order == null) {
			logger.info("pay --- order --- error");
			return "error";
		}

		PayAuthVO payAuth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		// Y5平台 提供的 App secret
		String app_secret = payAuth.getKey();
		logger.info(String.format("Request: app_secret=%s", app_secret));

		String sign1 = DigestUtils.md5Hex("app_secret=" + app_secret + "&order_id=" + order_id + "&order_date="
				+ order_date + "&app_id=" + app_id + "&user_id=" + user_id + "&item_id=" + item_id + "&server_id="
				+ server_id + "&character_id=" + character_id + "&pay_type=" + pay_type + "&pay_cash=" + pay_cash
				+ "&pay_point=" + pay_point + "&params=" + params);
		logger.info(String.format("Request: sign1=%s", sign1));
		if (sign.equals(sign1)) {
			// 三方订单
			order.setOpenOrderId(order_id);
			order.setOpenId(user_id);
			order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
			orderService.updatePayOrder(order);
			logger.info("pay --- success");
			return null;
		}
		logger.info("pay --- sign --- error");
		return "error";
	}

	/**
	 * 快创
	 * 
	 * @param order
	 * @param client_secret
	 * @param account
	 */
	private void thirdCallBack(PayOrderVO order, String client_secret, String account) {
		String gameId = "" + order.getGameId();
		logger.info("it is" + account);
		if (gameId.equals("9")) {
			String url = "http://10.1.8.213:35000/luckywings/luckywingsnotify";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = sdf.format(new Date());
			logger.info(time);
			String proof = DigestUtils.shaHex(
					time + order.getGameId() + order.getId() + order.getPrice() + "CUR_TWD" + account + client_secret);
			logger.info("proof is " + time + order.getGameId() + order.getId() + order.getPrice() + "CUR_TWD" + account
					+ client_secret);
			HJYThirdPay thirdPay = new HJYThirdPay(order.getId(), time, account, String.valueOf(order.getPrice()),
					"CUR_TWD", String.valueOf(order.getGameId()), proof);
			String req = this.send(url, thirdPay);
			logger.info(req);
			if (req.equals("success")) {
				order.setStatues(EnumFieldH5.ORDER_STATUS_SHIPPED);
				orderService.updatePayOrder(order);
			}
		}
	}

	/**
	 * 群黑
	 * 
	 * @param request
	 * @return
	 */
	public String callbackQunHei(HttpServletRequest request) {
		String serverid = request.getParameter("serverid");
		logger.info(serverid);
		String orderno = request.getParameter("orderno");
		logger.info(orderno);
		String username = request.getParameter("username");
		logger.info(username);
		String addgold = request.getParameter("addgold");
		logger.info(addgold);
		String rmb = request.getParameter("rmb");
		logger.info(rmb);
		String paytime = request.getParameter("paytime");
		logger.info(paytime);
		String ext = request.getParameter("ext");
		logger.info(ext);
		String sign = request.getParameter("sign");
		logger.info(sign);

		if (username == null) {
			return "-2";
		}

		PayOrderVO order = orderService.getOrderByOpenOrderId(orderno);
		if (order != null) {
			return "-5";
		}
		order = orderService.getOrderById(ext);
		PayAuthVO payAuth = thirdService.getPayAuth(order.getGameId(), order.getChannelId());
		String sign1 = DigestUtils.md5Hex(orderno + username + "+" + serverid + addgold + "+" + rmb + "+" + paytime
				+ "+" + ext + "+" + payAuth.getKey());

		if (!sign1.equals(sign)) {
			return "-4";
		}
		
		// 三方订单
		order.setOpenOrderId(orderno);
		order.setOpenId(username);
		order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
		orderService.updatePayOrder(order);
		return "1";
	}

	private String send(String url, Object request) {
		try {
			// For stress testing
			long ts = System.currentTimeMillis();

			String requestString = JsonUtils.toJson(request);
			logger.debug(String.format("Request: url=%s, request=%s", url, requestString));

			String response = HttpClientHelper.post(url, requestString);
			logger.debug(String.format("Response: url=%s, response=%s", url, response));

			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te - ts)));

			return response;
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
			return null;
		}
	}

	// public static void main(String[] args) {
	// String url = "http://10.1.8.213:35000/luckywings/luckywingsnotify";
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	// String time = sdf.format(new Date());
	// System.out.println(time);
	// HJYThirdPay thirdPay = new HJYThirdPay();
	// thirdPay.setOrderId("258");
	// thirdPay.setCreateTime(time);
	// thirdPay.setPrice("6");
	// thirdPay.setUserId("123");
	// thirdPay.setType("CUR_CNY");
	// thirdPay.setGameId("9");
	// System.out.println(time +
	// "912346CUR_CNY12333acbd453ad391a9c489cbd3f7abcac8");
	// String proof = DigestUtils.shaHex(time +
	// "92586CUR_CNY12333acbd453ad391a9c489cbd3f7abcac8");
	// thirdPay.setProof(proof);
	//
	// String requestString = JsonUtils.toJson(thirdPay);
	// System.out.println(requestString);
	// String response = null;
	// try {
	// response = HttpClientHelper.post(url, requestString);
	// } catch (ClientProtocolException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println(response);
	// // System.exit(0);
	// }

	public static void main(String[] agrs) {

		String c = "2016-07-18T13:14:48+08:00";
		c = URLEncoder.encode(c);

		String app_secret = "fe1b8c3ba771b5b34b73c379d7f123a4";
		String order_id = "100A0077359F0700578C65C845";
		String order_date = "2016-07-18T13:14:48+08:00";
		String app_id = "yahoo-luckywings_lyftd";
		logger.info(app_id);
		String user_id = "2000002823";
		logger.info(user_id);
		String item_id = "net.wakool.luckywings.lyftd.item_1";
		String server_id = "1";
		logger.info(server_id);
		String character_id = null;
		logger.info(character_id);
		String pay_type = "platform-sandbox";
		String pay_cash = "50";
		String pay_point = "0";
		String params = "71134d37-5485-4670-ae4e-62a8cce623da";
		String sign = "cd854ead808b4b2b0a11af54b7cda690";
		String aaa = "app_secret=" + app_secret + "&order_id=" + order_id + "&order_date=" + order_date + "&app_id="
				+ app_id + "&user_id=" + user_id + "&item_id=" + item_id + "&server_id=" + server_id + "&character_id="
				+ character_id + "&pay_type=" + pay_type + "&pay_cash=" + pay_cash + "&pay_point=" + pay_point
				+ "&params=" + params;

		String sign1 = DigestUtils.md5Hex(aaa);
		System.out.println(sign1);

		String a = "app_secret=fe1b8c3ba771b5b34b73c379d7f123a4&" + "order_id=100A0077359F0700578C65C845&order_date="
				+ c + "&" + "app_id=yahoo-luckywings_lyftd&" + "user_id=2000002823&"
				+ "item_id=net.wakool.luckywings.lyftd.item_1&" + "server_id=1&" + "character_id=&"
				+ "pay_type=platform-sandbox&" + "pay_cash=50&" + "pay_point=0&"
				+ "params=71134d37-5485-4670-ae4e-62a8cce623da";
		String b = DigestUtils.md5Hex((a));

		System.out.println(b);

		System.out.println(aaa);
		System.out.println(a);
	}
}
