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

import java.util.Calendar;
import java.util.List;

/**
 * Memcache handler
 * 
 * @ClassName: MemcacheHandler
 * @author nikm
 * @date 2013-4-9
 *
 */
public class MemcacheHandler implements ICacheHandler {	
//	private SockIOPool pool = SockIOPool.getInstance();
	
	/** Init MemcachedClient */
//	private MemCachedClient memCachedClient;
	
	private int defauleTtl = 3600;
	private String keyPrefix;
	
	public MemcacheHandler(String hosts, int ttl, String keyPrefix) {
//		String[] servers = hosts.split(" ");
		
//		if (servers.length > 0) {
//			pool.setServers(servers);
//			pool.setFailover(true);
//			pool.setInitConn(10);
//			pool.setMinConn(5);
//	
//			pool.setMaxConn(250);
//			pool.setMaintSleep(30);
//			pool.setNagle(false);
//			pool.setSocketTO(1000);
//			pool.setAliveCheck(true);
//			pool.initialize();
//		}
//		
//		memCachedClient = new MemCachedClient();
		
		this.defauleTtl = ttl;
		this.keyPrefix = keyPrefix;
	}

	@Override
	public boolean connect() {
		return true;
	}

	@Override
	public void close() {
//		pool.shutDown();
	}

	@Override
	public Object get(String key) {
		return key;
//		return memCachedClient.get(getKey(key));
	}

	@Override
	public boolean set(String key, Object data) {
		return set(key, data, this.defauleTtl, 0);
	}

	@Override
	public boolean set(String key, Object data, int ttl) {
		return set(key, data, ttl, 0);
	}
	
	@Override
	public boolean set(String key, Object data, int ttl, int compress) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, ttl);
//		return memCachedClient.set(getKey(key), data, c.getTime(), compress);
		return false;
	}
	
	@Override
	public boolean touch(String key, int ttl) {
		return set(key, get(key), ttl);
	}

	@Override
	public boolean touch(String key) {
		return touch(key, defauleTtl);
	}

	@Override
	public boolean delete(String key) {
		return false;
//		return memCachedClient.delete(getKey(key));
	}

	@Override
	public void flushAll() {
//		memCachedClient.flushAll();
	}
	
	/**
	 * Get cache key with prefix
	 * @param key
	 * @return
	 */
//	private String getKey(String key){
//		return this.keyPrefix + key;
//	}

    @Override
    public List<String> getStats(String stats) {
        return null;
    }
}
