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

/**
 * Cahce interface
 * 
 * @ClassName: ICacheHandler
 * @author nikm
 * @date 2013-4-9
 *
 */
public interface ISessionCacheHandler {
	
	/**
	 * 
	 * Connect to cache server
	 */
	public boolean connect();
	
	/**
	 * 
	 * Disconnect to cache server
	 */
	public void close();
	
	/**
	 * 
	 * Get value
	 * @param $key string: Cache key.
	 * @return mixed: Cache value, or null on failure.
	 */
	public Object get(String key);
	
	/**
	 * Set value
	 * @param key string: Cache key.
	 * @param data mixed: Cache value.
	 * @return boolean
	 */
	public boolean set(String key, Object data);

	/**
	 * Set value
	 * @param key string: Cache key.
	 * @param data mixed: Cache value.
	 * @param ttl int: Cache time, in seconds.
	 * @return boolean
	 */
	public boolean set(String key, Object data, int ttl);
	
	/**
	 * Set value
	 * @param key string: Cache key.
	 * @param data mixed: Cache value.
	 * @param ttl int: Cache time, in seconds.
	 * @param compress int: 0 is not compressed.
	 * @return boolean
	 */
	public boolean set(String key, Object data, int ttl, int compress);
	
	/**
	 * Refresh cache time
	 * @param key string: Cache key.
	 * @param ttl int: Cache time, in seconds.
	 * @return boolean
	 */
	public boolean touch(String key, int ttl);
	
	/**
	 * Refresh cache time
	 * @param key string: Cache key.
	 * @param ttl int: Cache time, in seconds.
	 * @return boolean
	 */
	public boolean touch(String key);
	
	/**
	 * 
	 * Delete value
	 * @param key string: Cache key.
	 * @return boolean
	 */
	public boolean delete(String key);
	
	/**
	 * 
	 * Clear all cache
	 */
	public void flushAll();
	
	public List<String> getStats(String stats);
	
}
