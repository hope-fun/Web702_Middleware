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
import java.util.ArrayList;
import java.util.List;

import net.luckywings.mobigame.server.service.IHandler;
import net.luckywings.mobigame.server.service.ServiceHandlerException;
import net.luckywings.mobigame.server.utils.MobiBeanUtils;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: AbstractHandler
 * 
 * @description
 * @author nikm
 * @Date Feb 25, 2013
 * 
 */
public abstract class AbstractHandler implements IHandler {

	@Override
	public Object execute(String action, Object request) throws ServiceHandlerException {
		return this.execute(getActionMethod(action), request);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Object execute(Method actionMethod) throws ServiceHandlerException {
		try {
			actionMethod.setAccessible(true);
			return actionMethod.invoke(this);
		} catch (Exception e) {
			// log.error(String.format("Invoke handler action error:"));
			throw new ServiceHandlerException(e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Object execute(Method actionMethod, Object request) throws ServiceHandlerException {
		try {
			actionMethod.setAccessible(true);
			return actionMethod.invoke(this, request);
		} catch (Exception e) {
			// log.error(String.format("Invoke handler action error:"));
			throw new ServiceHandlerException(e);
		}
	}

	@Override
	public Method getActionMethod(String action) throws ServiceHandlerException {
		Method rel = null;
		try {

			Method[] methods = this.getClass().getMethods();
			for (Method method : methods) {
				// if (action.equals(method.getName()) &&
				// method.getParameterTypes() != null &&
				// method.getParameterTypes().length == 1) {
				// rel = method;
				// break;
				// }
				if (action.equals(method.getName())) {
					rel = method;
					break;
				}
			}
			if (rel == null) {
				throw new Exception(String.format("Could not find method %s", action));
			}
		} catch (NoSuchMethodException e) {
			// log.error(e, e);
			throw new ServiceHandlerException(String.format("Could not find action: %s", action));
		} catch (SecurityException e) {
			// log.error(e, e);
			throw new ServiceHandlerException(String.format("Could not find action: %s", action));
		} catch (Exception e) {
			// log.error(String.format("Invoke handler action error:"));
			throw new ServiceHandlerException(e);
		}
		return rel;
	}

	public <S, D> List<D> toList(List<S> listS, Class<D> objClass) {
		List<D> returnList = null;
		D object = null;
		if (null != listS) {
			returnList = new ArrayList<D>();
			for (S s : listS) {
				try {
					object = objClass.newInstance();
					MobiBeanUtils.copyProperties(s, object);
					returnList.add(object);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return returnList;
	}

	public <S, D> D toOne(S s, Class<D> objClass) {
		D object = null;
		if (null != s) {
			try {
				object = objClass.newInstance();
				MobiBeanUtils.copyProperties(s, object);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return object;
	}

}
