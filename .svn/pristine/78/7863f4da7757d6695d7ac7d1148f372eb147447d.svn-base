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

import net.luckywings.mobigame.server.service.IHandler;
import net.luckywings.mobigame.server.service.ServiceHandlerException;
import net.luckywings.mobigame.server.spring.ApplicationContextHolder;
import net.luckywings.mobigame.server.utils.JsonUtils;
import net.luckywings.mobigame.server.utils.StringUtils;

import org.springframework.stereotype.Service;


/**
 * ClassName: HandlerMananger
 * 
 * @description
 * @author nikm
 * @Date Feb 27, 2013
 * 
 */
@Service
public class HandlerMananger {

    public HandlerMananger() {
    }

    /**
     * 
     * @param module
     * @param action
     * @param request
     * @return
     * @throws ServiceHandlerException
     */
//    public IResponse execute(String module, String action, IRequest request) throws ServiceHandlerException {
//        IHandler handler = getHandler(module);
//        return handler.execute(action, request);
//    }

    /**
     * 
     * @param module
     * @param action
     * @param requestString
     * @return
     * @throws ServiceHandlerException
     */
    public Object execute(String module, String action, String requestString) throws ServiceHandlerException {
        IHandler handler = getHandler(module);
        Method method = handler.getActionMethod(action);
        Object request = getRequestData(method, requestString);
        return this.execute(handler, method, request);
    }

    /**
     * 
     * @param handler
     * @param request
     * @return
     * @throws ServiceHandlerException
     */
    public Object execute(IHandler handler, Method method, Object request) throws ServiceHandlerException {
        //log.debug(String.format("Do handler execute method with %s", request));
    	
    	Object result = null;
    	
    	if (request != null) {
    		result = handler.execute(method, request);
    	} else {
    		result = handler.execute(method);
    	}
    	
        return result;
    }

    /**
     * 
     * @param path
     * @return
     */
    public IHandler getHandler(String path) {
        //log.debug(String.format("Loading bean instance from spring context with %sHandler", path));
        String beanName = StringUtils.toLowerFirstChar(path)  + "Handler";
//        return (IHandler) ApplicationContextHolder.getApplicationContext().getBean(beanName);
        return (IHandler)ApplicationContextHolder.getBean(beanName);
    }

    /**
     * 
     * @param method
     * @param requestString
     * @return
     */
    public Object getRequestData(Method method, String requestString) {
    	Object request = null;
    	
    	if (method.getParameterTypes() != null && method.getParameterTypes().length > 0) {
    		Class<?> paramsClass = method.getParameterTypes()[0];
            request = JsonUtils.fromJson(requestString, paramsClass);
    	}
    	
        return request;
    }
}
