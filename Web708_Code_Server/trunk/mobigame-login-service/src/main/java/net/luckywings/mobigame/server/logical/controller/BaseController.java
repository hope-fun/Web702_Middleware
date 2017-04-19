/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 
 * ClassName: BaseController
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
public abstract class BaseController {	
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private ApplicationContext context;
    
    /**
     * 
     * @return
     */
    protected boolean isAjaxRequest() {
        // Client should set 'requestType' into request header when it is ajax. 
        return "ajax".equalsIgnoreCase(request.getHeader("requestType"));
    }
    
    /**
     * Get message from messages_zh.properties
     * @param key
     * @return
     */
    protected String getMessage(String key) {
        return getMessage(key, new String[] {});
	}
    
    /**
     * Get message from messages_zh.properties
     * @param key
     * @return
     */
    protected String getMessage(String key, Object[] args) {
    	Locale _currentLocale = RequestContextUtils.getLocale(request);
        String msg = context.getMessage(key, args, _currentLocale);
        
        return msg;
	}
    
    /**
     * Decode request params with utf-8
     * 
     * @param str
     * @return
     */
	protected String decodeWithUtf8(String str) {
		if (str != null) {
			try {
				str = new String(str.getBytes("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return str;
	}
}
