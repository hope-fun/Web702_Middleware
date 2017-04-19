/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.service.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.luckywings.mobigame.server.cas.service.handler.interfaces.IDataHandler;
import net.luckywings.mobigame.server.cas.service.vo.ChannelVO;
import net.luckywings.mobigame.server.cas.service.vo.GameVO;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.ServerVO;
import net.luckywings.mobigame.server.data.model.Channel;
import net.luckywings.mobigame.server.data.model.Game;
import net.luckywings.mobigame.server.data.model.PayAuth;
import net.luckywings.mobigame.server.data.model.Server;
import net.luckywings.mobigame.server.data.persistence.service.IChannelDAO;
import net.luckywings.mobigame.server.data.persistence.service.IGameDAO;
import net.luckywings.mobigame.server.data.persistence.service.IPayAuthDAO;
import net.luckywings.mobigame.server.data.persistence.service.IServerDAO;
import net.luckywings.mobigame.server.service.impl.AbstractHandler;
import net.luckywings.mobigame.server.utils.MobiBeanUtils;

@Component
public class DataHandler extends AbstractHandler implements IDataHandler {

	private static final Logger logger = LoggerFactory.getLogger(DataHandler.class);

	@Autowired
	private IPayAuthDAO payAuthDAO;

	@Autowired
	private IGameDAO gameDAO;

	@Autowired
	private IServerDAO serverDAO;

	@Autowired
	private IChannelDAO channelDAO;

	@Override
	public PayAuthVO findPayAuth(PayAuthVO req) {
		PayAuthVO vo = new PayAuthVO();
		PayAuth entity = payAuthDAO.findPayAuth(req.getGameId(), req.getChannelId());
		if (entity != null) {
			MobiBeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

	@Override
	public PayAuthVO findByfactoryServiceId(PayAuthVO req) {
		PayAuthVO vo = new PayAuthVO();
		PayAuth entity = payAuthDAO.findByfactoryServiceId(req.getFactoryServiceId());
		if (entity != null) {
			MobiBeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

	@Override
	public GameVO findGame(GameVO req) {
		GameVO vo = new GameVO();
		Game entity = gameDAO.findOne(req.getId());
		if (entity != null) {
			MobiBeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

	@Override
	public ServerVO findServer(ServerVO req) {
		ServerVO vo = new ServerVO();
		Server entity = serverDAO.findOne(req.getId());
		if (entity != null) {
			MobiBeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

	@Override
	public ChannelVO findChannel(ChannelVO req) {
		ChannelVO vo = new ChannelVO();
		Channel entity = channelDAO.findOne(req.getId());
		if (entity != null) {
			MobiBeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}

}
