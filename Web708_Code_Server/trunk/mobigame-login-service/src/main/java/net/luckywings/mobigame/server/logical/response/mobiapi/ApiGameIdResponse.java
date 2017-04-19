package net.luckywings.mobigame.server.logical.response.mobiapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiGameIdResponse extends ApiBaseResponse {
	private String factoryServiceId;
	
	private String key;

	public ApiGameIdResponse(String factoryServiceId) {
		super();
		this.factoryServiceId = factoryServiceId;
	}
	
	public ApiGameIdResponse() {
	}
}
