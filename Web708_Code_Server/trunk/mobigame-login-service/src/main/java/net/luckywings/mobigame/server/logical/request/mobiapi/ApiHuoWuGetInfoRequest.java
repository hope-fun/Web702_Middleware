/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.request.mobiapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiHuoWuGetInfoRequest {
	private String appid;

	private String sign;

	private String token;

	public ApiHuoWuGetInfoRequest(String appid, String sign, String token) {
		super();
		this.appid = appid;
		this.sign = sign;
		this.token = token;
	}

	public ApiHuoWuGetInfoRequest() {
		super();
	}
}
