/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi.modules;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.luckywings.mobigame.server.cas.service.vo.AccountAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.AccountRecordVO;
import net.luckywings.mobigame.server.cas.service.vo.AccountVO;
import net.luckywings.mobigame.server.cas.service.vo.GameVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.ServerVO;
import net.luckywings.mobigame.server.logical.busi.service.AccountService;
import net.luckywings.mobigame.server.logical.busi.service.GameService;
import net.luckywings.mobigame.server.logical.busi.service.ServerService;
import net.luckywings.mobigame.server.logical.busi.service.ThirdAccountService;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiEmptyRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiLoginRequest;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiBaseResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiErrorResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiGameIdResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiGameResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiLoginResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiSuccessResponse;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiResponseStatus;
import net.luckywings.mobigame.server.logical.service.mobiapi.BaseModule;
import net.luckywings.mobigame.server.session.ApiSession;

@Component
public class AccountModule extends BaseModule {

	private static final Logger logger = LoggerFactory.getLogger(AccountModule.class);

	@Autowired
	private ThirdAccountService thirdaccountService;

	@Autowired
	private ServerService serverService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private GameService gameService;

	/**
	 * 获取Game
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public ApiBaseResponse getGmaeUrl(ApiLoginRequest req) throws Exception {
		GameVO vo = new GameVO();
		vo.setId(req.getGame());
		GameVO game = gameService.findGame(vo);
		ApiGameResponse response = new ApiGameResponse();
		response.setGame(game);
		return response;
	}

	/**
	 * 登陆
	 */
	public ApiBaseResponse login(ApiLoginRequest req) throws Exception {

		logger.debug("Account Module Login Parames: " + req.toString());
		boolean validate = thirdaccountService.login(req, ApiBaseResponse.class);

		if (!validate) {
			new ApiErrorResponse(ApiResponseStatus.LOGIN_ERROR);
		}

		ApiBaseResponse res = new ApiSuccessResponse();
		boolean flag = false;
		// TODO 考虑加上一层合法性验证 -- T.J 2016.02.19
		// Create New Account
		AccountVO account = new AccountVO();

		// Add Account Auth
		AccountAuthVO auth = new AccountAuthVO();
		auth.setIdentifier(req.getAuth().getIdentifier());
		auth.setCredential(req.getAuth().getCredential());
		auth.setIdentityType(req.getAuth().getIdentityType());

		// Add Account Record
		AccountRecordVO record = new AccountRecordVO();
		record.setLoginGame(req.getGame());
		record.setLoginIp(req.getIp());
		record.setLoginTime(new Date());

		account.setAuth(auth);
		account.setRecord(record);

		// Call Login Service
		account = accountService.login(account);

		if (account != null && account.getRoleId() != null) {
			ApiSession session = new ApiSession();
			session.setRoleId(account.getRoleId());
			updateSession(session);
		} else {
			res = new ApiErrorResponse(ApiResponseStatus.LOGIN_ERROR);
		}
		// 请求加载服务器数据
		if (flag) {
			List<ServerVO> servers = serverService.list();
			res = new ApiLoginResponse(servers);
		}
		return res;
	}

	/**
	 * 帐号绑定
	 */
	public ApiBaseResponse bind(ApiEmptyRequest req) {
		return new ApiSuccessResponse();
	}

	/**
	 * 帐号解绑
	 */
	public ApiBaseResponse unbind(ApiEmptyRequest req) {
		return new ApiSuccessResponse();
	}

	/**
	 * 登陆之前获取factirt_servuce_id
	 * 
	 */
	public ApiGameIdResponse info(ApiLoginRequest req) throws ApiException {
		long channelId = req.getChannel();
		long gameId = req.getGame();
		System.out.println(gameId + channelId);
		ApiGameIdResponse response = new ApiGameIdResponse();
		PayAuthVO payAuth = thirdaccountService.getPayAuth(gameId, channelId);
		logger.info(payAuth.toString());
		response.setFactoryServiceId(payAuth.getFactoryServiceId());
		response.setKey(payAuth.getKey());
		return response;
	}

	/**
	 * 修改密码
	 */
	public ApiBaseResponse password(ApiEmptyRequest req) {
		return new ApiSuccessResponse();
	}

}
