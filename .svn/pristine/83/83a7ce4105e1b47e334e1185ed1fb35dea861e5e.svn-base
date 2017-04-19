/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.service.impl;

import java.lang.reflect.Method;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import net.luckywings.mobigame.server.service.IHandler;
import net.luckywings.mobigame.server.utils.JsonUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * ClassName: AbstractIndexService
 *
 * @description
 * @author nikm
 * @Date 2013-2-28
 *
 */
@Component
@Path("/data")
public abstract class AbstractIndexService {

	private static Logger log = Logger.getLogger(AbstractIndexService.class);

	@Autowired
	private HandlerMananger handlerMananger;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{module}/{action}")
    public Response post(String requestString, @PathParam("module") String module, @PathParam("action") String action) {
        log.debug(String.format("-----Request: url=%s/%s, request=%s", module, action, requestString));
        
        ResponseBuilder builder = null;

        // For stress testing
		long ts = System.currentTimeMillis();
        
        try {
            // IServiceHandler handler = getHandler(module);
        	IHandler handler = handlerMananger.getHandler(module);
            Method method = handler.getActionMethod(action);
            Object request = handlerMananger.getRequestData(method, requestString);
            Object response = handlerMananger.execute(handler, method, request);
            String responseString = JsonUtils.toJson(response);
            builder = Response.ok(responseString);
            
            log.debug(String.format("Response: url=%s/%s, response=%s", module, action, responseString));
    		
        } catch (Exception e) {
            log.error(String.format("Handler data service error, module = %s, action = %s", module, action), e);
            builder = Response.serverError();
        }
        
        // For stress testing
        long te = System.currentTimeMillis();
		log.debug(String.format("Handler data service url=%s/%s, execute time=%sms", module, action, (te-ts)));

        return builder.build();
    }
}
