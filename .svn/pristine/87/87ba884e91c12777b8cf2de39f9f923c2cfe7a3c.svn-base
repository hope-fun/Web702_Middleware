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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
//import net.luckywings.mobigame.server.rulers.PlayerIdRuler;
import net.luckywings.mobigame.server.cache.CacheManager;
import net.luckywings.mobigame.server.helper.HttpClientHelper;
import net.luckywings.mobigame.server.service.IPagedList;
import net.luckywings.mobigame.server.utils.JsonUtils;
import net.luckywings.mobigame.server.utils.SysProperties;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @ClassName: AbstractDataService
 * @author nikm
 * @date 2013-7-20
 *
 */
public abstract class AbstractDataService {
    private static Logger log = Logger.getLogger(AbstractDataService.class);
    
    private static String SERVICE_CAS_ADDR = SysProperties.getInstance().getProperty("server.host.dataservice.cas", "");
    private static String SERVICE_STATIC_ADDR = SysProperties.getInstance().getProperty("server.host.dataservice.static", "");
    private static String SERVICE_DYNAMIC_ADDR = SysProperties.getInstance().getProperty("server.host.dataservice.dynamic", "");
    private static String SERVICE_NEWS_ADDR = SysProperties.getInstance().getProperty("server.host.dataservice.news", "");
    private static String SERVICE_CODE_ADDR = SysProperties.getInstance().getProperty("server.host.dataservice.code", "");

    public enum EnumDataServiceType {
        CAS, STATIC, DYNAMIC, NEWS,CODE;
    }
    
	private String getServiceUrl(EnumDataServiceType type) {
		String url;
		switch (type) {
			case CAS:
				url = SERVICE_CAS_ADDR;
				break;
			case STATIC:
				url = SERVICE_STATIC_ADDR;
				break;
			case DYNAMIC:
				url = SERVICE_DYNAMIC_ADDR;
				break;
			case NEWS:
				url = SERVICE_NEWS_ADDR;
				break;
			case CODE:
				url = SERVICE_CODE_ADDR;
				break;
			default:
				url = SERVICE_STATIC_ADDR;
				break;
		}

		return url;
	}
	
//	protected String[] getAllPlayerIdTypes() {
//		return PlayerIdRuler.getAllIdTypes();
//	}
    
    /**
     * Send request, get as java object
     * 
     * @param action
     * @param request
     * @param type
     * @param objClass
     * @return
     */
    protected <T> T sendRequest(String action, Object request, EnumDataServiceType type, Class<T> objClass){
    	String jsonStr = this.sendRequest(action, request, type);
    	return this.getJson(jsonStr, objClass);
    }
    
    /**
     * Send request, get as java object list
     * 
     * @param action
     * @param request
     * @param type
     * @param objClass
     * @return
     */
    protected <T> List<T> sendRequestList(String action, Object request, EnumDataServiceType type, Class<T> objClass){
    	List<T> result = new ArrayList<T>();
    	
    	String jsonStr = this.sendRequest(action, request, type);
    	JsonElement jsonE = this.getJson(jsonStr, JsonElement.class);
    	
    	if (jsonE != null && jsonE.isJsonArray()) {
	    	JsonArray arr = jsonE.getAsJsonArray();
	        Iterator<JsonElement> iterators = arr.iterator();
	        while (iterators.hasNext()) {
	            JsonElement ele = iterators.next();
	            result.add(JsonUtils.fromJson(ele.toString(), objClass));
	        }
    	}
    	return result;
    }
    
    /**
     * Send request, get as java object paged list
     * 
     * @param action
     * @param request
     * @param type
     * @param objClass
     * @return
     */
    protected <T> IPagedList<T> sendRequestPagedList(String action, Object request, EnumDataServiceType type, Class<T> objClass){
    	PagedList<T> result = new PagedList<T>();
    	
    	String jsonStr = this.sendRequest(action, request, type);
    	
    	result = this.getJson(jsonStr, PagedList.class);
    	
    	JsonElement jsonE = this.getJson(jsonStr, JsonElement.class);
    	
    	if (jsonE.isJsonObject()) {
	    	JsonObject obj = jsonE.getAsJsonObject();
	    	
	    	if (obj.has("list")) {
	    		JsonElement listE = obj.get("list");
	    		if (listE.isJsonArray()) {
	    			result.clear();
	    			
		    		JsonArray arr = listE.getAsJsonArray();
		    		Iterator<JsonElement> iterators = arr.iterator();
			        while (iterators.hasNext()) {
			            JsonElement ele = iterators.next();
			            result.add(JsonUtils.fromJson(ele.toString(), objClass));
			        }
	    		}
	    	}
    	}
    	return result;
    }
	
    private String sendRequest(String action, Object request, EnumDataServiceType type){
        String url = this.getServiceUrl(type) + "/" + action;
        return this.send(url, request);
    }

    /**
     * Send request to data service
     * 
     * @param url
     * @param request
     * @return
     */
    private String send(String url, Object request){
        try {
        	// For stress testing
    		long ts = System.currentTimeMillis();
            
            String requestString = JsonUtils.toJson(request);
            log.debug(String.format("Request: url=%s, request=%s",  url, requestString));
            
            String response = HttpClientHelper.post(url, requestString);
            //log.debug(String.format("Response: url=%s, response=%s", url, response));
            
            // For stress testing
            long te = System.currentTimeMillis();
    		log.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te-ts)));

            return response;
        } catch (Exception e) {
        	log.error("Request data service error: ", e);
        	return null;
        }
    }
    
    /**
     * Get json object from json string
     * 
     * @param jsonStr
     * @param objClass
     * @return
     */
    public <T> T getJson(String jsonStr, Class<T> objClass) {
    	if (jsonStr == null) return null;
    	
		T obj = null;
		try {
			obj = JsonUtils.fromJson(jsonStr, objClass);
		} catch (Exception e) {
			log.error("--- Get json error: ", e);
        	return null;
		}
		
		return obj;
	}
    
	/**
	 * Get data from cache server
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T getMemCache(String key, Class<T> classOfT) {
		return (T) CacheManager.getInstance().get(key);
	}

	/**
	 * Set data to cache server
	 * 
	 * @param key
	 * @return
	 */
	protected void setMemCache(String key, Object obj) {
		CacheManager.getInstance().set(key, obj);
	}
	
	/**
	 * Set data to cache server
	 * 
	 * @param key
	 * @param ttl int: Cache time, in seconds.
	 * @return
	 */
	protected void setMemCache(String key, Object obj, int ttl) {
		CacheManager.getInstance().set(key, obj, ttl);
	}
	
	/**
	 * delete item from mem cache by key
	 * @param key key 
	 */
	protected void deleteMemCache(String key) {
		CacheManager.getInstance().delete(key);
	}
}
