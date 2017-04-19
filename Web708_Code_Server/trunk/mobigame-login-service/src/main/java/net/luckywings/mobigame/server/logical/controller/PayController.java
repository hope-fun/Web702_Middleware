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

import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.luckywings.mobigame.server.logical.request.mobiapi.ApiPayRequest;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiH5PayResponse;
import net.luckywings.mobigame.server.utils.JsonUtils;
import net.luckywings.mobigame.server.utils.SendUtils;

@Controller
@RequestMapping(value = "/pay")
public class PayController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@RequestMapping(value = { "/{channel}" })
	public @ResponseBody Object pay(@PathVariable(value = "channel") String channel, ApiPayRequest request) {
		String baseUrl = "http://www.nicegame.com.tw/ngapi/NGpay/";
		Object obj = null;
		try {
			Method method = this.getClass().getMethod("pay" + channel.getCode(), ApiPayRequest.class);
			obj = method.invoke(this, request);
		} catch (Exception e) {

		}
		return obj;
	}

	public String H5(ApiPayRequest pay) {
		String baseUrl = "http://www.nicegame.com.tw/ngapi/NGpay/";
		String partner = "XFORCE";
		String user = pay.getUid();
		String time = new Date().getTime() + "";
		String game = "tsH5";
		String server_id = "test";
		String order_id = UUID.randomUUID().toString();
		String money = "1";
		String sign = DigestUtils.md5Hex(order_id + money + game + server_id + time + user + partner + "key") + "非字串";
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("game", game));
		params.add(new BasicNameValuePair("server_id", server_id));
		params.add(new BasicNameValuePair("time", time));
		params.add(new BasicNameValuePair("user", user));
		params.add(new BasicNameValuePair("partner", partner));
		params.add(new BasicNameValuePair("order_id", order_id));
		params.add(new BasicNameValuePair("money", money));
		params.add(new BasicNameValuePair("sign", sign));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		String result = SendUtils.send(baseUrl + "?" + paramString);
		ApiH5PayResponse H5Pay = JsonUtils.fromJson(result, ApiH5PayResponse.class);
		if (H5Pay.getError() != null) {
			return H5Pay.getError();
		}
		return "SUCCESS";
	}

}
