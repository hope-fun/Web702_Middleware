/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cache;

import net.luckywings.mobigame.server.utils.SysProperties;

/**
 * Cache manager
 * 
 * @ClassName: CahceManager
 * @author nikm
 * @date 2013-4-9
 *
 */
public class CacheManager {
	private static ICacheHandler _handler;
	
	private static final int type = SysProperties.getInstance().getIntProperty("server.cache.type", 2);
	private static final String hosts = SysProperties.getInstance().getProperty("server.cache.hosts", "localhost:11211");
	private static final int ttl = SysProperties.getInstance().getIntProperty("server.cache.timeout", 3600);
	private static final String keyPrefix = SysProperties.getInstance().getProperty("server.cache.prefix", "mobigame_");

	
	public static ICacheHandler getInstance() {
		if (_handler == null) {
			synchronized (CacheManager.class) {
				if (_handler == null) new CacheManager();
			}
		}
		
		return _handler;
	}
	
	private CacheManager() {
		switch (type) {
			case 1:
				_handler = new MemcacheHandler(hosts, ttl, keyPrefix);
				break;
			case 2:
				_handler = new XMemcachedHandler(hosts, ttl, keyPrefix);
				break;
			default:
				_handler = new XMemcachedHandler(hosts, ttl, keyPrefix);
				break;
		}
		_handler.connect();
	}
}