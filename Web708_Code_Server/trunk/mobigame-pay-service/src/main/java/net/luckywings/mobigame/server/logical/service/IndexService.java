/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * ClassName: IndexService
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
@Component
@Path("/index")
public class IndexService {

	private static Logger log = Logger.getLogger(IndexService.class);

	public IndexService() {

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{path}")
	public Response post(String requestString, @PathParam("path") String path) {
		log.debug(path);
		log.debug(requestString);
		ResponseBuilder builder = null;

		try {

			builder = Response.ok(null);
		} catch (Exception e) {
			log.error(String.format("Execute service (%s) error.", path), e);
			builder = Response.ok(null);
		}

		return builder.build();
	}

}
