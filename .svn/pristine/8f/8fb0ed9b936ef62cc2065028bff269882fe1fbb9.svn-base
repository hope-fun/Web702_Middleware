/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.service.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;
import net.luckywings.mobigame.server.service.BaseVO;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayOrderVO extends BaseVO {

    private static final long serialVersionUID = 3087939847792686360L;

    private String roleId;			// 角色ID
    private String openOrderId;     // 三方订单
    private String openId;			// 三方渠道帐号
    private String openPayId;		// 三方支付账号
    private long channelId;   		// 游戏渠道ID
    private long payChannelId;		// 支付渠道ID
    private String itemId;			// 商品ID
    private String itemName;		// 商品名
    private double price;			// 单价
    private int count;				// 物品数量
    private double amount;			// 订单总额
    private EnumFieldH5 currency;	// 货币单位
    private long gameId;			// 游戏ID
    private long serverId;	        // 游戏服务器ID
    private String sign;            // 校验签名
    private String resultCode;      // 交易结果码
    private EnumFieldH5 statues;    // 订单状态
    private Date updateTime;

    public PayOrderVO() {

    }

    public PayOrderVO(String orderId) {
        super();
        super.setId(orderId);
    }
    
    public PayOrderVO(String roleId,String openOrderId){
    	this.roleId=roleId;
    	this.openOrderId=openOrderId;
    }
    
    public PayOrderVO(String roleId,EnumFieldH5 statues) {
        super();
        this.roleId=roleId;
        this.statues=statues;
    }

}
