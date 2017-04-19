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

import static org.junit.Assert.*;

import net.luckywings.mobigame.server.cache.CacheManager;

import org.junit.Test;

/**
 * TODO
 * 
 * @ClassName: TestCache
 * @author nikm
 * @date 2013-8-1
 *
 */
public class TestCache {

	/**
	 * Test method for {@link net.luckywings.mobigame.server.cache.CacheManager#getInstance()}.
	 */
	@Test
	public void testCache() {
		System.out.println("Test cache manager");
		
		String key = "cfy-test-01";
		String data = "Test data for memcached";
		
		CacheManager.getInstance().set(key, data);
		
		String result = (String) CacheManager.getInstance().get(key);
		System.out.println("Get from cache server: " + result);
		
		assertEquals(data, result);
	}
	public static void main(String[]args) {
		System.out.println("test.......");
	}

}
