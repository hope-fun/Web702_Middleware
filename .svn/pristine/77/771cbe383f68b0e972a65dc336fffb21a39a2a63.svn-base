package net.luckywings.mobigame.server.logical.request.mobiapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiItemRequest extends ApiBaseRequest {
	/**
	 * 道具名称
	 */
	private String name;
	/**
	 * 单价
	 */
	private int price;
	/**
	 * 数量
	 */
	private int count;

	@Override
	public boolean isValid() {
		return true;
	}

}
