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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * 
 * @ClassName: XMemcachedHandler
 * @author nikm
 * @date 2013-8-1
 *
 */
public class XSessionMemcachedHandler implements ISessionCacheHandler {
	
	private MemcachedClient memcachedClient;
	
	private int defauleTtl = 3600;
	private String keyPrefix;
	
	public XSessionMemcachedHandler(String hosts, int ttl, String keyPrefix) {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(hosts));
		builder.setSessionLocator(new KetamaMemcachedSessionLocator());
		
		try {
			memcachedClient = builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.defauleTtl = ttl;
		this.keyPrefix = keyPrefix;
	}

	@Override
	public boolean connect() {
		return true;
	}

	@Override
	public void close() {
		try {
			// close memcached client
			memcachedClient.shutdown();
		} catch (IOException e) {
			System.err.println("Shutdown MemcachedClient fail");
			e.printStackTrace();
		}
	}

	@Override
	public Object get(String key) {
		Object value = null;
		try {
			value = memcachedClient.get(getKey(key), 1000);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public boolean set(String key, Object data) {
		return this.set(key, data, defauleTtl);
	}

	@Override
	public boolean set(String key, Object data, int ttl) {
		return this.set(key, data, ttl, 0);
	}

	@Override
	public boolean set(String key, Object data, int ttl, int compress) {
		boolean result = false;
		try {
			result = memcachedClient.set(getKey(key), ttl, data);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean touch(String key, int ttl) {
		if (get(key) != null) {
			return set(key, get(key), ttl);
		} else {
			return false;
		}
	}

	@Override
	public boolean touch(String key) {
		return touch(key, defauleTtl);
	}

	@Override
	public boolean delete(String key) {
		boolean result = false;
		try {
			result = memcachedClient.delete(getKey(key));
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void flushAll() {
		try {
			memcachedClient.flushAll();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get cache key with prefix
	 * @param key
	 * @return
	 */
	private String getKey(String key){
		return this.keyPrefix + key;
	}

    @Override
    public List<String> getStats(String stats) {
        Map<InetSocketAddress, Map<String, String>> map = null;
            try {
                map = memcachedClient.getStatsByItem(stats);
            } catch (MemcachedException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            
          if(map == null) {
              return null;
          }  
          Set<String> slabSet = new HashSet<String> ();
          for (Map.Entry<InetSocketAddress, Map<String, String>>  item : map.entrySet()) {
                Map<String,String> valueMap = item.getValue();
                Iterator<String> its = valueMap.keySet().iterator();
                while(its.hasNext()){
                    String key = its.next();
                    if(key.indexOf("number") != -1) {
                        System.out.println(key + "--->  " + valueMap.get(key));
                        slabSet.add(key.split(":")[1]);
                    }
                }
          }
        System.out.println("=====================Split Line================================");
        List<String> list = new ArrayList<String>();  
        for(String v : slabSet) {  
            String command = "cachedump ".concat(v).concat(" 0");  
            Iterator<Map<String, String>> iterItems;
            try {
                iterItems = memcachedClient.getStatsByItem(command).values().iterator();
                while(iterItems.hasNext()) {  
                    Map<String, String> items = iterItems.next();
                    Iterator<String> keIt = items.keySet().iterator();
                    while(keIt.hasNext()) {
                        System.out.println(keIt.next());
                    }
                    list.addAll(items.keySet());  
                }  
            } catch (MemcachedException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }  
        }  
        
        return list;
    }
}
