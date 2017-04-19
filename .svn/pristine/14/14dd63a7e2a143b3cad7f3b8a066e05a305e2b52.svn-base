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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;
import net.luckywings.mobigame.server.logical.busi.service.OrderService;
import net.luckywings.mobigame.server.logical.busi.service.ThirdService;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiEmptyRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiPayCreateOrderRequest;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiPayUpdateOrderRequest;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiBaseResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiSuccessResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.pay.ApiPayCreateOrderResponse;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;
import net.luckywings.mobigame.server.logical.service.mobiapi.BaseModule;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;

@Component
public class PayModule extends BaseModule {

	private static final Logger logger = LoggerFactory.getLogger(PayModule.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private ThirdService thirdService;

	/**
	 * 创建订单
	 */
	public ApiPayCreateOrderResponse create(ApiPayCreateOrderRequest req) {

		PayOrderVO order = new PayOrderVO();
		if (req.getItem() != null) {// 道具不为空
			order.setCount(req.getItem().getCount());
			order.setCurrency(req.getItem().getCurrency());
			order.setItemId(req.getItem().getId());
			order.setItemName(req.getItem().getName());
			order.setPrice(req.getItem().getPrice());// 订单单价
		}
		order.setChannelId(req.getChannel());// 游戏渠道ID
		order.setGameId(req.getGame());// 游戏ganmeID
		order.setOpenId(req.getOpenId());// 三方渠道账号
		order.setPayChannelId(req.getPayChannel());// 支付游戏渠道ID
		order.setStatues(EnumFieldH5.ORDER_STATUS_NONPAY);// 订单未支付
		// order.setRoleId(this.getSession().getRoleId());
		order = orderService.createOrder(order);// 创建订单
		logger.info("------------");
		ApiPayCreateOrderResponse resp = thirdService.callPayChannelCreateOrder(order);
		return resp;
	}

	/**
	 * 更新订单
	 */
	public ApiBaseResponse update(ApiPayUpdateOrderRequest req) throws ApiException {

		PayOrderVO order = orderService.getOrderById(req.getOrderId());
		order.setOpenOrderId(req.getOpenOrderId());
		order.setStatues(EnumFieldH5.ORDER_STATUS_PAID);
		orderService.updatePayOrder(order);
		return new ApiSuccessResponse();
	}

	/**
	 * 校验订单
	 */
	public ApiBaseResponse validate(ApiEmptyRequest req) throws ApiException {

		return new ApiSuccessResponse();
	}

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(j);
				map.put(i, j + "test");
			}
		}
		System.out.println(map.toString());
	}

}
