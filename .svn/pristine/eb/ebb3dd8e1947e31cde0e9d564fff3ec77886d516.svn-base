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

import org.springframework.stereotype.Service;

import net.luckywings.mobigame.server.cas.service.vo.GameVO;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;

@Service
public class GameService extends BaseService {

	/**
	 * 获取Game
	 */
	public GameVO findGame(GameVO vo) throws ApiException {
		return sendRequest("data/findGame", vo, EnumDataServiceType.CAS, GameVO.class);
	}

}
