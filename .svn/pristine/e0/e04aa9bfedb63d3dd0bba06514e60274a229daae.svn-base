/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.session;


/**
 * @ClassName: SessionManager
 * @author nikm
 * @date 2013-7-23
 *
 */
public class SessionManager {
	private static ISessionHandler _handler;
	
	public static ISessionHandler getInstance() {
		if (_handler == null) {
			synchronized (SessionManager.class) {
				if (_handler == null) _handler = new MemcacheSessionHandler();
			}
		}
		
		return _handler;
	}
}
