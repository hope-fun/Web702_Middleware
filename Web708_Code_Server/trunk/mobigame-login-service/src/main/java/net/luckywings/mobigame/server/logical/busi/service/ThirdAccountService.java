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

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.luckywings.mobigame.server.cas.service.vo.ChannelVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.helper.HttpClientHelper;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiHuoWuGetInfoRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiHuoWuGetTokenRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginAuthRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginForGameRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginHuoWuRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginQunHeiRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginTaoMiRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginY5Request;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiLoginForgameResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiLoginHuoWuResponse;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.utils.JsonUtils;

@Service
public class ThirdAccountService extends BaseService {

	private static final Logger logger = LoggerFactory.getLogger(ThirdAccountService.class);

	public boolean login(ApiLoginRequest<?> req, Class<?> objClass) throws Exception {
		boolean obj = false;
		if (req.getChannel() == 1) {
		} else if (req.getChannel() == 2) {
		} else if (req.getChannel() == 3) {
		} else if (req.getChannel() == 6) {
			obj = this.playerForgameLoginCallBack(req, objClass);
		} else if (req.getChannel() == 8) {
			logger.info("123456");
			obj = this.playerTaoMiLoginCallBack(req, objClass);
		} else if (req.getChannel() == 10) {
			obj = this.playerY5LoginCallBack(req, objClass);
		} else if (req.getChannel() == 11) {
			obj = this.playerQunHeiLoginCallBack(req, objClass);
		} else if (req.getChannel() == 12) {
			obj = this.playerHuoWuLoginCallBack(req, objClass);
		}
		return obj;
	}

	// ??PayAuth
	public PayAuthVO getPayAuth(long gameId, long channelId) {
		PayAuthVO payAuth = sendRequest("data/findPayAuth", new PayAuthVO(gameId, channelId), EnumDataServiceType.CAS,
				PayAuthVO.class);
		return payAuth;
	}

	// ??Channel
	public ChannelVO getChannel(long channelId) {
		ChannelVO channel = sendRequest("data/findChannel", new ChannelVO(channelId), EnumDataServiceType.CAS,
				ChannelVO.class);
		return channel;
	}

	public boolean playerForgameLoginCallBack(ApiLoginRequest<?> request, Class<?> objClass) {

		PayAuthVO auth = this.getPayAuth(request.getGame(), request.getChannel());
		ApiLoginForGameRequest forgame = JsonUtils.fromJson(JsonUtils.toJson(request.getExtra()),
				ApiLoginForGameRequest.class);
		String baseURL = "http://h5.91wan.com/api/dataapi.php";
		String protocol = "100108";
		String server_auth = "1";
		String uid = forgame.getUid();

		String game_id = auth.getFactoryServiceId();// SysProperties.getInstance().getProperty("third.player.forgame.game.id",
													// "1106");
		String server_id = "0";
		String user_name = forgame.getUserName();
		String sid = forgame.getSid();
		String secret = auth.getKey();// "b40ecfa45e52c9113661415ac018788a";
		String sign = DigestUtils.md5Hex("game_id=" + game_id + "&protocol=" + protocol + "&server_auth=" + server_auth
				+ "&server_id=" + server_id + "&sid=" + sid + "&uid=" + uid + "&user_name=" + user_name + secret);
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("protocol", protocol));
		params.add(new BasicNameValuePair("server_auth", server_auth));
		params.add(new BasicNameValuePair("uid", uid));
		params.add(new BasicNameValuePair("game_id", game_id));
		params.add(new BasicNameValuePair("server_id", server_id));
		params.add(new BasicNameValuePair("user_name", user_name));
		params.add(new BasicNameValuePair("sid", sid));
		params.add(new BasicNameValuePair("sign", sign));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		String result = this.send(baseURL + "?" + paramString);
		ApiLoginForgameResponse res = JsonUtils.fromJson(result, ApiLoginForgameResponse.class);
		return res.getUid() != null;
	}

	public boolean playerTaoMiLoginCallBack(ApiLoginRequest<?> request, Class<?> objClass) throws Exception {
		logger.info("taomi:" + request.getGame() + "," + request.getChannel());
		PayAuthVO payAuth = this.getPayAuth(request.getGame(), request.getChannel());
		ApiLoginTaoMiRequest taomi = JsonUtils.fromJson(JsonUtils.toJson(request.getExtra()),
				ApiLoginTaoMiRequest.class);
		String baseURL = payAuth.getDirectURL() + "users/profile";
		String access_token = taomi.getToken();
		String client_id = payAuth.getFactoryServiceId();
		String client_secret = payAuth.getKey();
		logger.info("-----------:" + client_id + "," + client_secret + "," + baseURL);
		String client_proof = DigestUtils.shaHex(access_token + client_id + client_secret);
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("client_id", client_id));
		params.add(new BasicNameValuePair("client_proof", client_proof));
		params.add(new BasicNameValuePair("access_token", access_token));
		String paramString = URLEncodedUtils.format(params, "utf-8");
		String result = this.send(baseURL + "?" + paramString);
		logger.info("2345" + result);
		JSONObject jsonObject = new JSONObject(result);
		String profile = jsonObject.getString("profile");
		JSONObject profile_obj = new JSONObject(profile);
		String account = profile_obj.getString("account");
		String nickname = profile_obj.getString("nickname");
		String picture = profile_obj.getString("picture");
		return account != null;
	}

	/**
	 * Y5
	 * 
	 * @param request
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	public boolean playerY5LoginCallBack(ApiLoginRequest<?> request, Class<?> objClass) throws Exception {

		ApiLoginY5Request y5 = JsonUtils.fromJson(JsonUtils.toJson(request.getExtra()), ApiLoginY5Request.class);
		logger.info(JsonUtils.toJson(y5));
		String app_secret = y5.getKey();
		String login_key = y5.getLogin_key();
		String app_id = y5.getApp_id();
		String user_id = y5.getUser_id();
		String sign = y5.getSign();
		String sign1 = DigestUtils.md5Hex(
				"app_secret=" + app_secret + "&login_key=" + login_key + "&app_id=" + app_id + "&user_id=" + user_id);
		if (sign1.equals(sign)) {
			logger.info("sign succes");
			return true;
		}
		logger.info("sign error");
		return false;
	}

	/**
	 * 群黑
	 * 
	 * @param request
	 * @param objClass
	 * @return
	 */
	public boolean playerQunHeiLoginCallBack(ApiLoginRequest<?> request, Class<?> objClass) {
		ApiLoginQunHeiRequest qunhei = JsonUtils.fromJson(JsonUtils.toJson(request.getExtra()),
				ApiLoginQunHeiRequest.class);
		logger.info(JsonUtils.toJson(qunhei));
		// 获取 KEY
		PayAuthVO payAuth = this.getPayAuth(request.getGame(), request.getChannel());
		String sign = DigestUtils.md5Hex(qunhei.getUsername() + "+" + qunhei.getServerid() + "+" + qunhei.getIsadult()
				+ "+" + qunhei.getTime() + "+" + payAuth.getKey());
		if (sign.equals(qunhei.getFlag())) {
			logger.info("sign succes");
			return true;
		}
		logger.info("sign error");
		return false;
	}

	/**
	 * 火舞
	 * 
	 * @param request
	 * @param objClass
	 * @return
	 */
	public boolean playerHuoWuLoginCallBack(ApiLoginRequest<?> request, Class<?> objClass) throws Exception {
		ApiLoginHuoWuRequest huowu = JsonUtils.fromJson(JsonUtils.toJson(request.getExtra()),
				ApiLoginHuoWuRequest.class);
		// 获取AppId、key
		PayAuthVO payAuth = this.getPayAuth(request.getGame(), request.getChannel());
		String appid = payAuth.getFactoryServiceId();
		String secret = payAuth.getKey();
		String code = huowu.getCode();
		String sign1 = DigestUtils.md5Hex("appid=" + appid + "&code=" + code + "&secret" + secret);
		String getTokenUrl = payAuth.getDirectURL() + "token";
		String result1 = this.send(getTokenUrl, new ApiHuoWuGetTokenRequest(appid, sign1, code));
		JSONObject jsonObject1 = new JSONObject(result1);
		// 授权token
		String access_token = jsonObject1.getString("access_token");

		String sign2 = DigestUtils.md5Hex("appid=" + appid + "&token=" + access_token + "&secret" + secret);
		String getInfoUrl = payAuth.getDirectURL() + "info";
		String result2 = this.send(getInfoUrl, new ApiHuoWuGetInfoRequest(appid, sign2, access_token));
		ApiLoginHuoWuResponse res = JsonUtils.fromJson(result2, ApiLoginHuoWuResponse.class);
		request.getAuth().setIdentifier(res.getOpenid());
		return res != null;

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

	public static void main(String[] args) {
		ApiLoginRequest req = new ApiLoginRequest();
		req.setChannel(888);
		req.setGame(8);

		ApiLoginAuthRequest auth = new ApiLoginAuthRequest();
		auth.setIdentityType(EnumFieldH5.QUESTION_TYPE_ART);
		auth.setIdentifier("123");

		req.setAuth(auth);
		System.out.println(JsonUtils.toJson(req));
		req.getAuth().setIdentifier("456");
		System.out.println(JsonUtils.toJson(req));
	}
}
