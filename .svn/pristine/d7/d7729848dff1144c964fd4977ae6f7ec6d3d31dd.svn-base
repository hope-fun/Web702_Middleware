/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.model.AbstractModel;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;

@Entity
@Table(name = "mw_pay_order")
@Data
@EqualsAndHashCode(callSuper = false)
public class PayOrder extends AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 角色ID */
	@Column(length = 64, nullable = false)
	private String roleId;

	/** 三方订单 */
	@Column(length = 64, unique = true, nullable = false)
	private String openOrderId;

	/** 三方帐号 */
	@Column(length = 64)
	private String openId;

	/** 三方支付账号 */
	@Column(length = 64)
	private String openPayId;

	/** 游戏渠道ID */
	private long channelId;

	/** 支付渠道ID */
	private long payChannelId;

	/** 商品ID */
	@Column(length = 64)
	private String itemId;

	/** 商品名 */
	@Column(length = 255)
	private String itemName;

	/** 单价 */
	private double price;

	/** 商品数量 */
	private int count;

	/** 订单总额 */
	private double amount;

	/** 货币单位 */
	@Enumerated(EnumType.STRING)
	private EnumFieldH5 currency;

	/** 游戏ID */
	private long gameId;

	/** 游戏服务器ID */
	private long serverId;

	/** 校验签名 */
	@Column(length = 255)
	private String sign;

	/** 交易结果码 */
	private String resultCode;

	/** 订单状态 */
	@Enumerated(EnumType.STRING)
	private EnumFieldH5 statues;

	public void setCount(int count) {
		this.count = count;
		this.updateAmount();
	}

	public void setPrice(double price) {
		this.price = price;
		this.updateAmount();
	}

	public void updateAmount() {
		this.amount = this.count * this.price;
	}
	
}
