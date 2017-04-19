package net.luckywings.mobigame.server.logical.busi.viewdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class HJYThirdPay {
	// 订单ID
	private String orderId;
	// 时间
	private String createTime;
	// 用户id
	private String userId;
	// 金额
	private String price;
	// 货币类型
	private String type;
	// 游戏ID
	private String gameId;
	// // 交易状态
	// private String trade_status;
	private String proof;

	public HJYThirdPay() {
		super();
	}

	public HJYThirdPay(String orderId, String createTime, String userId, String price, String type, String gameId,String proof) {
		super();
		this.orderId = orderId;
		this.createTime = createTime;
		this.userId = userId;
		this.price = price;
		this.type = type;
		this.gameId = gameId;
		this.proof=proof;
	}
}
