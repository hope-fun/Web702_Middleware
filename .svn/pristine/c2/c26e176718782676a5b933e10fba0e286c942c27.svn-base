/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.busi.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.luckywings.mobigame.server.cas.service.vo.AccountAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.AccountVO;
import net.luckywings.mobigame.server.cas.service.vo.ChannelVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;
import net.luckywings.mobigame.server.helper.HttpClientHelper;
import net.luckywings.mobigame.server.logical.busi.viewdata.EYLPayVO;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrder9GResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderEYLResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderForgameResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderIOSResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderJYResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderLWResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderPlay68Response;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderRunQuResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderTaoMiResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiCreateOrderY5Response;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiPayCreateOrderResponse;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.service.vo.BaseSearchVO;
import net.luckywings.mobigame.server.utils.JsonUtils;

@Service
public class ThirdService extends BaseService {

	private static final Logger logger = LoggerFactory.getLogger(ThirdService.class);

	@Autowired
	private OrderService orderService;

	// 获取PayAuth
	public PayAuthVO getPayAuth(long gameId, long channelId) {
		PayAuthVO payAuth = sendRequest("data/findPayAuth", new PayAuthVO(gameId, channelId), EnumDataServiceType.CAS,
				PayAuthVO.class);
		return payAuth;
	}

	// 获取PayAuth
	public PayAuthVO findByfactoryServiceId(String factoryServiceId) {
		PayAuthVO req = new PayAuthVO();
		req.setFactoryServiceId(factoryServiceId);
		PayAuthVO payAuth = sendRequest("data/findByfactoryServiceId", req, EnumDataServiceType.CAS, PayAuthVO.class);
		return payAuth;
	}

	// 获取Channel
	public ChannelVO getChannel(long channelId) {
		ChannelVO channel = sendRequest("data/findChannel", new ChannelVO(channelId), EnumDataServiceType.CAS,
				ChannelVO.class);
		return channel;
	}

	public ApiPayCreateOrderResponse callPayChannelCreateOrder(PayOrderVO order) {

		PayAuthVO auth = this.getPayAuth(order.getGameId(), order.getChannelId());
		ChannelVO channel = this.getChannel(order.getChannelId());
		ApiPayCreateOrderResponse resp = new ApiPayCreateOrderResponse();
		try {
			Method method = this.getClass().getMethod("callPayChannelCreateOrder" + channel.getCode(), PayOrderVO.class,
					PayAuthVO.class);
			resp = (ApiPayCreateOrderResponse) method.invoke(this, order, auth);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	/**
	 * nicegame渠道
	 * 
	 * @param order
	 * @param auth
	 * @return
	 */
	public String callPayChannelCreateOrderNG(PayOrderVO order, PayAuthVO auth) {
		String baseURL = "http://www.nicegame.com.tw/ngapi/NGpay/";
		String partner = "XFORCE";
		String user = order.getOpenId();
		String time = String.valueOf(new Date().getTime());
		String game = "tsH5";
		String server_id = "";
		String order_id = order.getId();
		int money = (int) (order.getPrice() * order.getCount());
		// String sign =
		// DigestUtils.md5Hex(order_id+money+game+server_id+time+user+partner+key);

		// String result = this.send(baseURL + "?" + paramString);
		// return new ApiCreateOrder9GResponse(orderid, sign, spid);
		return " ";
	}

	public static void main(String[] args) {
		String baseURL = "http://www.nicegame.com.tw/ngapi/NGpay";
		String partner = "XFORCE";
		String user = "123456";
		String time = String.valueOf(new Date().getTime());
		String game = "tsH5";
		String server_id = "1";
		String order_id = "111111111";
		int money = 1;
		String sign = DigestUtils.md5Hex(order_id + money + game + server_id + time + user + partner);
		baseURL += "?game=" + game + "&server_id=" + server_id + "&time=" + time + "&user=" + user + "&partner="
				+ partner + "&order_id=" + order_id + "&money=" + money + "&sign=" + sign;
		try {
			// For stress testing
			long ts = System.currentTimeMillis();
			logger.info(String.format("Request: url=%s", baseURL));
			String response = HttpClientHelper.get(baseURL);
			System.out.println(response);
			// HttpClientHelper.
			logger.info(String.format("Response: url=%s, response=%s", baseURL, response));
			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", baseURL, (te - ts)));
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
		}
	}

	// 9G
	public ApiCreateOrder9GResponse callPayChannelCreateOrder9G(PayOrderVO order, PayAuthVO auth) {
		String orderid = order.getOpenOrderId(); // 9G订单号不能超过32位, 所以使用短ID
		Double money = order.getAmount();
		String spid = auth.getFactoryServiceId();
		String spkey = auth.getKey();
		String sign = DigestUtils.md5Hex(orderid + "" + new Double(money * 100).intValue() + "" + spid + "" + spkey);
		return new ApiCreateOrder9GResponse(orderid, sign, spid);
	}

	// Play68
	public ApiCreateOrderPlay68Response callPayChannelCreateOrderPlay68(PayOrderVO order, PayAuthVO auth) {
		String orderid = order.getId();
		String baseURL = "http://www.play68.com/api/paycheck";
		String appid = auth.getFactoryServiceId();
		String openid = order.getOpenId();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String ts = sdf.format(date);
		String itemid = order.getItemId() + "_" + orderid;
		String itemname = order.getItemName();
		String num = String.valueOf(order.getPrice());
		String price = num.substring(0, num.lastIndexOf("."));
		String count = String.valueOf(order.getCount());
		String secureKey = auth.getKey();
		String sign = DigestUtils.md5Hex(appid + count + itemid + itemname + openid + price + ts + secureKey);
		logger.info(
				String.format("Play68 param. openid=%s,itemid=%s,itemname=%s,pric=%s,count=%s,appid=%s,ts=%s,sign=%s",
						openid, itemid, itemname, price, count, appid, ts, sign));
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("appid", appid));
		params.add(new BasicNameValuePair("openid", openid));
		params.add(new BasicNameValuePair("ts", ts));
		params.add(new BasicNameValuePair("itemid", itemid));
		params.add(new BasicNameValuePair("itemname", itemname));
		params.add(new BasicNameValuePair("price", price));
		params.add(new BasicNameValuePair("count", count));
		params.add(new BasicNameValuePair("sign", sign));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		String result = this.send(baseURL + "?" + paramString);
		logger.info(result);
		String skey = null;
		try {
			JSONObject jsonObject = new JSONObject(result);
			skey = jsonObject.getString("skey");
			logger.info(skey);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ApiCreateOrderPlay68Response(orderid, skey);
	}

	// jy
	public ApiCreateOrderJYResponse callPayChannelCreateOrderJY(PayOrderVO order, PayAuthVO auth) {
		String orderid = order.getId();
		return new ApiCreateOrderJYResponse(orderid);
	}

	// 淘米
	public ApiCreateOrderTaoMiResponse callPayChannelCreateOrderTaomi(PayOrderVO order, PayAuthVO auth) {
		String orderid = order.getId();
		ApiCreateOrderTaoMiResponse taomi = new ApiCreateOrderTaoMiResponse(orderid);
		return taomi;
	}

	// Forgame
	public ApiCreateOrderForgameResponse callPayChannelCreateOrderForgame(PayOrderVO order, PayAuthVO auth) {
		String baseURL = "http://h5.91wan.com/api/dataapi.php";
		String protocol = "100601";
		String subject = order.getItemName();
		String totalFee = order.getAmount() + "";
		String uid = order.getOpenId();
		String gameId = auth.getFactoryServiceId();
		String serverId = "0";
		String notifyUrl = auth.getNotifyURL();
		String callbackUrl = auth.getDirectURL();
		String secret = auth.getKey();
		String sign = DigestUtils.md5Hex("callback_url=" + callbackUrl + "&game_id=" + gameId + "&notify_url="
				+ notifyUrl + "&protocol=" + protocol + "&server_id=" + serverId + "&subject=" + subject + "&total_fee="
				+ totalFee + "&uid=" + uid + secret);

		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("protocol", protocol));
		params.add(new BasicNameValuePair("subject", subject));
		params.add(new BasicNameValuePair("total_fee", totalFee));
		params.add(new BasicNameValuePair("uid", uid));
		params.add(new BasicNameValuePair("game_id", gameId));
		params.add(new BasicNameValuePair("server_id", serverId));
		params.add(new BasicNameValuePair("notify_url", notifyUrl));
		params.add(new BasicNameValuePair("callback_url", callbackUrl));
		params.add(new BasicNameValuePair("sign", sign));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		String result = this.send(baseURL + "?" + paramString);
		ApiCreateOrderForgameResponse forgame = this.getJson(result, ApiCreateOrderForgameResponse.class);
		String Forsign = DigestUtils.md5Hex("token=" + forgame.getToken() + secret);
		order.setOpenOrderId(forgame.getOutTradeNo());// 更改openOrderId为返回的outTradeNo
		orderService.updatePayOrder(order);

		forgame.setSign(Forsign);
		forgame.setAppid(gameId);

		return forgame;
	}

	// 二月兰
	public ApiCreateOrderEYLResponse callPayChannelCreateOrderErYueLan(PayOrderVO order, PayAuthVO auth) {
		PayAuthVO payAuth = this.getPayAuth(auth.getGameId(), auth.getChannelId());
		String appId = payAuth.getFactoryServiceId();
		String appKey = payAuth.getKey();
		String outTradeCode = this.getTransTime() + new Random().nextInt(1000);// 订单ID
		String paySuccessUrl = payAuth.getNotifyURL();// 成功后页面返回地址
		int transAmount = (int) (order.getAmount() * 100);// 金额 分
		String transIntro = "商品名称：" + order.getItemName();// 交易简介
		String transTime = getTransTime();// 申请时间
		String remark = "备注";
		String sign = null;
		logger.info("----------: " + appId + "," + appKey + "," + paySuccessUrl);
		sign = DigestUtils.md5Hex("appId=" + appId + "&appKey=" + appKey + "&outTradeCode=" + outTradeCode
				+ "&paySuccessUrl=" + paySuccessUrl + "&transAmount=" + transAmount + "&transIntro=" + transIntro
				+ "&transTime=" + transTime);
		String url = "http://h5game.qbao.com/i5you/pay/payrequest.php";// 支付链接
		// 发送https请求，返回json
		String result = this.send(url, new EYLPayVO(outTradeCode, appId, transTime, transIntro,
				String.valueOf(transAmount), paySuccessUrl, remark, sign));
		ApiCreateOrderEYLResponse EYLResponse = this.getJson(result, ApiCreateOrderEYLResponse.class);
		order.setOpenOrderId(EYLResponse.getOutTradeCode());// 更改openOrderId为返回的OutTradeCode
		orderService.updatePayOrder(order);
		return EYLResponse;
	}

	// IOS
	public ApiCreateOrderIOSResponse callPayChannelCreateOrderIOS(PayOrderVO order, PayAuthVO auth) {
		return new ApiCreateOrderIOSResponse(order.getId());
	}

	// Luckywings
	public ApiCreateOrderLWResponse callPayChannelCreateOrderLW(PayOrderVO order, PayAuthVO auth) {
		order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
		orderService.updatePayOrder(order);
		return new ApiCreateOrderLWResponse(order.getId());
	}

	// Y5
	public ApiCreateOrderY5Response callPayChannelCreateOrderY5(PayOrderVO order, PayAuthVO auth) {
		String orderid = order.getId();
		ApiCreateOrderY5Response y5 = new ApiCreateOrderY5Response(orderid);
		return y5;
	}

	// 黑群
	public ApiCreateOrderRunQuResponse callPayChannelCreateOrderQunHei(PayOrderVO order, PayAuthVO auth) {

		// String baseURL = "http://m.qunhei.com/pay/gopay/gid/xxx.html";
		// String baseURL = auth.getNotifyURL();
		String money = order.getAmount() + "";
		String goodsName = order.getItemName();
		String userId = this.account(order.getRoleId());
		String ext = order.getId();

		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("money", money));
		params.add(new BasicNameValuePair("goodsName", goodsName));
		params.add(new BasicNameValuePair("userId", userId));
		params.add(new BasicNameValuePair("ext", ext));
		String sign = DigestUtils.md5Hex(money + "+" + userId + "+" + ext + "+" + auth.getKey());

		params.add(new BasicNameValuePair("sign", sign));
		// String paramString = URLEncodedUtils.format(params, "utf-8");
		// String result = this.send(baseURL + "?" + paramString);
		ApiCreateOrderRunQuResponse heirun = new ApiCreateOrderRunQuResponse();
		heirun.setOrderId(ext);
		return heirun;
	}

	public String account(String playerId) {
		AccountVO accountvo = this.sendRequest("account/getAccountByRoleId", new BaseSearchVO(null, playerId),
				EnumDataServiceType.CAS, AccountVO.class);
		AccountAuthVO aavo = this.sendRequest("account/getAccountAuthById", new BaseSearchVO(null, accountvo.getId()),
				EnumDataServiceType.CAS, AccountAuthVO.class);
		String account = aavo.getIdentifier();
		return account;
	}

	private String send(String url) {
		try {
			// For stress testing
			long ts = System.currentTimeMillis();
			logger.info(String.format("Request: url=%s", url));
			String response = HttpClientHelper.get(url);
			// HttpClientHelper.
			logger.info(String.format("Response: url=%s, response=%s", url, response));
			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te - ts)));
			return response;
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
			return null;
		}
	}

	private String send(String url, Object request) {
		try {
			// For stress testing
			long ts = System.currentTimeMillis();

			String requestString = JsonUtils.toJson(request);
			logger.debug(String.format("Request: url=%s, request=%s", url, requestString));

			String response = HttpClientHelper.post(url, requestString);
			// log.debug(String.format("Response: url=%s, response=%s", url,
			// response));

			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te - ts)));

			return response;
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
			return null;
		}
	}

	// 该方法获取当前时间，并且以yyyyMMddHHmmss字符串形式返回
	private String getTransTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sdf.format(date);
		return time;
	}

	/**
	 * Get json object from json string
	 * 
	 * @param jsonStr
	 * @param objClass
	 * @return
	 */
	public <T> T getJson(String jsonStr, Class<T> objClass) {
		if (jsonStr == null)
			return null;

		T obj = null;
		try {
			obj = JsonUtils.fromJson(jsonStr, objClass);
		} catch (Exception e) {
			logger.error("--- Get json error: ", e);
			return null;
		}

		return obj;
	}

}
