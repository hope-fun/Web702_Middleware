/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.data.persistence.service;

import java.util.List;

import net.luckywings.mobigame.server.data.model.PayOrder;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.persistence.service.ISimpleDAO;

public interface IPayOrderDAO extends ISimpleDAO<PayOrder> {
	
    List<PayOrder> getPayOrderByStatus(String roleId,EnumFieldH5 statues);
	
    PayOrder getPayOrderByOpenOrderId(String openOrderId);
    
    PayOrder getPayOrderByOpenId(String openId);
}
