/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * ClassName: ApplicationContextHolder
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
@Service("applicationContextProvider")
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext appContext;

    /**
     * 
     */
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("*** ApplicationContextHolder::setApplicationContext()...");
        ApplicationContextHolder.appContext = ctx;
    }

    /**
     * 
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    public static Object getBean(String name) {
    	return appContext.getBean(name);
    }
    
}
