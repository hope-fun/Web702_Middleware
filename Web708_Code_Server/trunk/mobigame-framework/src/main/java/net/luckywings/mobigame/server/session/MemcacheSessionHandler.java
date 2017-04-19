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

import java.util.List;

import net.luckywings.mobigame.server.utils.SysProperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @ClassName: MemcacheSessionHandler
 * @author nikm
 * @date 2013-7-23
 *
 */
public class MemcacheSessionHandler implements ISessionHandler {
	private static final Logger log = LoggerFactory.getLogger(MemcacheSessionHandler.class);
	private static final String hosts = SysProperties.getInstance().getProperty("server.session.hosts", "localhost:11211");
	private static final int ttl = SysProperties.getInstance().getIntProperty("server.session.timeout", 900);
	private static final String keyPrefix = SysProperties.getInstance().getProperty("server.session.prefix", "mobigame_");
	
	private static ISessionCacheHandler _handler;
	
	public MemcacheSessionHandler() {
		log.warn(hosts);
		_handler = new XSessionMemcachedHandler(hosts, ttl, keyPrefix);
		_handler.connect();
	}
	
	@Override
	public Object get(String sid) {
		return (sid != null) ? _handler.get(sid) : null;
	}

	@Override
	public void set(String sid, Object session) {
		try {
			if (sid != null){
			    _handler.set(sid, session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refresh(String sid) {
		try {
			if (sid != null) _handler.touch(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(String sid) {
		try {
			if (sid != null) _handler.delete(sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Override
    public List<String> getStats(String status) {
        try {
            if (status != null) _handler.getStats(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}