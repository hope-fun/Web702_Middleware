/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.service;

import java.lang.reflect.Method;

/**
 * ClassName: IHandler
 * 
 * @description
 * @author nikm
 * @Date Feb 25, 2013
 * 
 */
public interface IHandler {

    /**
     * 
     * @param action
     * @param request
     * @return
     * @throws ServiceHandlerException
     */
    Object execute(String action, Object request) throws ServiceHandlerException;

    /**
     * 
     * @param actionMethod
     * @return
     * @throws ServiceHandlerException
     */
    Object execute(Method actionMethod) throws ServiceHandlerException;
    
    /**
     * 
     * @param actionMethod
     * @param request
     * @return
     * @throws ServiceHandlerException
     */
    Object execute(Method actionMethod, Object request) throws ServiceHandlerException;
    
    /**
     * 
     * @param action
     * @return
     * @throws ServiceHandlerException
     */
    Method getActionMethod(String action) throws ServiceHandlerException;
}
