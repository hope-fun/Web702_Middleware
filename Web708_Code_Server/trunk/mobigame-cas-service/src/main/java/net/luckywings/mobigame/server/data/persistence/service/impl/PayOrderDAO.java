/*****************************************************************************
 *
 *                      HOPERUN PROPRIETARY INFORMATION
 *
 *          The information contained herein is proprietary to HopeRun
 *           and shall not be reproduced or disclosed in whole or in part
 *                    or used for any design or manufacture
 *              without direct written authorization from HopeRun.
 *
 *            Copyright (c) 2013 by HopeRun.  All rights reserved.
 *
 *****************************************************************************/
package net.luckywings.mobigame.server.data.persistence.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.luckywings.mobigame.server.data.model.PayOrder;
import net.luckywings.mobigame.server.data.persistence.service.IPayOrderDAO;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.persistence.service.impl.AbstractSimpleDAO;
/**
 * @author zhang.kun
 * @date Jun 17, 2014
 */
@Service("payOrderDAO")
public class PayOrderDAO extends AbstractSimpleDAO<PayOrder>
		implements IPayOrderDAO {
	Logger logger = Logger.getLogger(PayOrderDAO.class);

	
	@Override
	public List<PayOrder> getPayOrderByStatus(String roleId,EnumFieldH5 statues) {
		String jpql = "from PayOrder where roleId=:roleId and statues=:statues";
		TypedQuery<PayOrder> query = this.getEntityManager().createQuery(
				jpql, PayOrder.class);
		query.setParameter("roleId", roleId);
		query.setParameter("statues", statues);
		List<PayOrder> bank = null;
		try {
			bank = query.getResultList();
		} catch (Exception e) {
			logger.info("No entity found for query");
		}
		return bank;
	}
	
	@Override
	public PayOrder getPayOrderByOpenOrderId(String openOrderId) {
		logger.info("2222"+openOrderId);
		String jpql = "from PayOrder where openOrderId=:openOrderId";
		TypedQuery<PayOrder> query = this.getEntityManager().createQuery(
				jpql, PayOrder.class);
		query.setParameter("openOrderId", openOrderId);
		PayOrder bank = null;
		try {
			bank = query.getSingleResult();
		} catch (Exception e) {
			logger.info("No entity found for query");
		}
		return bank;
	}
	
	@Override
	public PayOrder getPayOrderByOpenId(String openId) {
		String jpql = "from PayOrder where openId=:openId";
		TypedQuery<PayOrder> query = this.getEntityManager().createQuery(
				jpql, PayOrder.class);
		query.setParameter("openId", openId);
		PayOrder bank = null;
		try {
			bank = query.getSingleResult();
		} catch (Exception e) {
			logger.info("No entity found for query");
		}
		return bank;
	}
	
}
