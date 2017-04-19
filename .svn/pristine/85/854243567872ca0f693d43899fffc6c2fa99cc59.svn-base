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

import java.util.List;

import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;

public interface IPayHandler {

	PayAuthVO findPayAuth(PayAuthVO req);

	PayOrderVO createOrder(PayOrderVO req);
	
	List<PayOrderVO> getPayOrderByStatus(PayOrderVO request);
	
	PayOrderVO getPayOrderById(PayOrderVO request);
	
	PayOrderVO getPayOrderByOpenOrderId(PayOrderVO request);
	
	PayOrderVO updatePayOrder(PayOrderVO vo);
	
	PayOrderVO getPayOrderByOpenId(PayOrderVO request);

}
