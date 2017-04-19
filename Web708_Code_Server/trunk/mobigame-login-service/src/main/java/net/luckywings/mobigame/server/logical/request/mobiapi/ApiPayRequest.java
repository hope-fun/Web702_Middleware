package net.luckywings.mobigame.server.logical.request.mobiapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiPayRequest extends ApiBaseRequest {
	/**
	 * 玩家UID
	 */
	private String uid;
	/**
	 * CP订单号
	 */
	private String orderNo;
	/**
	 * 支付金额
	 */
	private int money;
	/**
	 * 购买道具
	 */
	private ApiItemRequest ietm;

	@Override
	public boolean isValid() {
		return true;
	}

}
