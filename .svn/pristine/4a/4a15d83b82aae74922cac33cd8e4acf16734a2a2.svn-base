/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.luckywings.mobigame.server.session.ApiSession;
import net.luckywings.mobigame.server.session.SessionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: ApiBase
 * @author nikm
 * @date 2013-7-20
 *
 */
public abstract class BaseModule {
	private static final Logger log = LoggerFactory.getLogger(BaseModule.class);
	
	private String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	protected ApiSession getSession() {
		return (ApiSession) SessionManager.getInstance().get(sessionId);
	}
	
	protected void updateSession(ApiSession session) {
		if (session != null) {
			this.sessionId = session.getSessionId();
			SessionManager.getInstance().set(sessionId, session);
		}
	}
	
	protected void refreshSession() {
		SessionManager.getInstance().refresh(sessionId);
	}
	
	protected void deleteSession() {
		SessionManager.getInstance().delete(sessionId);
		this.sessionId = null;
	}
	
    public Object execute(String action, Object request) throws ApiException {
        return this.execute(getActionMethod(action), request);
    }

    public Object execute(Method actionMethod, Object request) throws ApiException {
    	try {
            actionMethod.setAccessible(true);
            Object obj = actionMethod.invoke(this, request);
//            this.refreshSession(); // Update session expired time
            return obj;
        } catch (InvocationTargetException e) {
        	//log.error("Invoke target action error, ", e.getTargetException());
        	if (e.getTargetException() instanceof ApiException) {
        		throw new ApiException(((ApiException) e.getTargetException()).getStatus(), e.getTargetException().getMessage());
        	} else {
        		throw new ApiException(e.getTargetException());
        	}
        } catch (Exception e) {
            //log.error("Invoke handler action error, ", e);
            throw new ApiException(ApiResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public Method getActionMethod(String action) throws ApiException {
        Method rel = null;
        try {

            Method[] methods = this.getClass().getMethods();
            for (Method method : methods) {
                if (action.equals(method.getName()) && method.getParameterTypes() != null && method.getParameterTypes().length == 1) {
                    rel = method;
                    break;
                }
            }
            if (rel == null) {
                throw new Exception(String.format("Could not find method %s", action));
            }
        } catch (NoSuchMethodException e) {
            //log.error("NoSuchMethodException, ", e);
            throw new ApiException(ApiResponseStatus.NO_ACTION);
        } catch (SecurityException e) {
            //log.error("SecurityException, ", e);
            throw new ApiException(ApiResponseStatus.FORBIDDEN);
        } catch (Exception e) {
            //log.error(String.format("Invoke action method error:"));
            throw new ApiException(ApiResponseStatus.INTERNAL_SERVER_ERROR);
        }
        return rel;
    }
}