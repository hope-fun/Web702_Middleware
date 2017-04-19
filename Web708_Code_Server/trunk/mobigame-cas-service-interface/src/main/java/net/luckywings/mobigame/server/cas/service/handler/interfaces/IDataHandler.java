/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.service.handler.interfaces;

import net.luckywings.mobigame.server.cas.service.vo.ChannelVO;
import net.luckywings.mobigame.server.cas.service.vo.GameVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.ServerVO;

public interface IDataHandler {

	PayAuthVO findPayAuth(PayAuthVO req);

	PayAuthVO findByfactoryServiceId(PayAuthVO req);

	GameVO findGame(GameVO req);

	ServerVO findServer(ServerVO req);

	ChannelVO findChannel(ChannelVO req);

}
