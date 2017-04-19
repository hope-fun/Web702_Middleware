/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.data.persistence.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.luckywings.mobigame.server.data.model.PayAuth;
import net.luckywings.mobigame.server.data.persistence.service.IPayAuthDAO;
import net.luckywings.mobigame.server.persistence.service.impl.AbstractSimpleStaticDAO;

@Service("payAuthDAO")
public class PayAuthDAO extends AbstractSimpleStaticDAO<PayAuth> implements IPayAuthDAO {

	private final Logger logger = LoggerFactory.getLogger(PayAuthDAO.class);

	@Override
	public PayAuth findPayAuth(long gameId, long channelId) {

		String jpql = "FROM PayAuth pa WHERE pa.gameId = :gameId AND pa.channelId = :channelId";
		TypedQuery<PayAuth> query = this.getEntityManager().createQuery(jpql, PayAuth.class);
		query.setParameter("gameId", gameId);
		query.setParameter("channelId", channelId);
		PayAuth auth = null;
		List<PayAuth> results = query.getResultList();
		if (!results.isEmpty()) {
			auth = results.get(0);
		}
		return auth;
	}

	@Override
	public PayAuth findByfactoryServiceId(String factoryServiceId) {
		String jpql = "FROM PayAuth pa WHERE pa.factoryServiceId =:factoryServiceId";
		TypedQuery<PayAuth> query = this.getEntityManager().createQuery(jpql, PayAuth.class);
		query.setParameter("factoryServiceId", factoryServiceId);
		PayAuth auth = null;
		List<PayAuth> results = query.getResultList();
		if (!results.isEmpty()) {
			auth = results.get(0);
		}
		return auth;
	}

}
