/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.response.mobiapi;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import net.luckywings.mobigame.server.utils.JsonUtils;

/**
 * 
 * @ClassName: ApiBaseResponse
 * @author nikm
 * @date 2013-7-20
 *
 */
public abstract class ApiBaseResponse {

	public ResponseBuilder getResponseBuilder() {
		ResponseBuilder builder = null;

		builder = Response.ok(toJson());

		return builder;
	}
	
	public Response toResponse() {
		ResponseBuilder builder = null;

		builder = Response.ok(toJson());

		return builder.build();
	}

	protected String toJson() {
		return JsonUtils.toJson(this);
	}
}
