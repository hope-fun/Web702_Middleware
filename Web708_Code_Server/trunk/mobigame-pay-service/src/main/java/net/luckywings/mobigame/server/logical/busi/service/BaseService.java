/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.busi.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import net.luckywings.mobigame.server.service.impl.AbstractDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;


/**
 * ClassName: BaseService
 * 
 * @description
 * @author nikm
 * @Date 2013-3-13
 * 
 */
public abstract class BaseService extends AbstractDataService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ApplicationContext context;

    /**
     * Get message from messages_zh.properties
     * 
     * @param key
     * @return
     */
    protected String getMessage(String key) {
        return getMessage(key, new String[] {});
    }

    /**
     * Get message from messages_zh.properties
     * 
     * @param key
     * @return
     */
    protected String getMessage(String key, Object[] args) {
        Locale _currentLocale = RequestContextUtils.getLocale(request);
        String msg = context.getMessage(key, args, _currentLocale);
        return msg;
    }
}
