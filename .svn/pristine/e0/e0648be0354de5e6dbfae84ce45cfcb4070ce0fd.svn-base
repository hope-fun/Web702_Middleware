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

import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;
import net.luckywings.mobigame.server.service.vo.BaseSearchVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public PayOrderVO createOrder(PayOrderVO vo) {
        return sendRequest("pay/createOrder", vo, EnumDataServiceType.CAS, PayOrderVO.class);
    }
    
    public PayOrderVO getOrderById(String orderId) {
        return sendRequest("pay/getPayOrderById", new PayOrderVO(orderId), EnumDataServiceType.CAS, PayOrderVO.class);
    }

    public PayOrderVO getOrderByOpenOrderId(String openOrderId) {
    	logger.info("11111111"+openOrderId);
        return sendRequest("pay/getPayOrderByOpenOrderId", new PayOrderVO(null,openOrderId), EnumDataServiceType.CAS, PayOrderVO.class);
    }

    public PayOrderVO getOrderByOpenId(String openId) {
        return sendRequest("pay/getPayOrderByOpenId", new PayOrderVO(openId), EnumDataServiceType.CAS, PayOrderVO.class);
    }
    
    public PayOrderVO updatePayOrder(PayOrderVO vo) {

        PayOrderVO order = sendRequest("pay/updatePayOrder", vo, EnumDataServiceType.CAS, PayOrderVO.class);
        return order;
    }

}
