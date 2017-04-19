/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * 
 * ClassName: HttpClientHelper
 * 
 * @description
 * @author nikm
 * @Date 2013-3-4
 * 
 */
public class HttpClientHelper {
    private static Logger log = Logger.getLogger(HttpClientHelper.class);

	private static int timeout = 10 * 1000;
	private static String HTTP_HEAD_CONTENT_TYPE = "Content-Type";
	private static String HTTP_HEAD_CONTENT_TYPE_VALUE = "application/json; charset=utf-8";
    
    /**
     * 
     * @param type
     * @param module
     * @param action
     * @return
     */
    public static String createDBServiceUrl(String baseDomainUrl, String module, String action) {
        return baseDomainUrl + "/" + module + "/" + action;
    }

    /**
     * 
     * @param url
     * @param requestString
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String post(String url, String requestString) throws ClientProtocolException, IOException {

        StringEntity input = new StringEntity(requestString,ContentType.APPLICATION_JSON);
        input.setContentType("application/json");

        return send(url, requestString);
    }
    
    public static String get(String url) throws ClientProtocolException, IOException {

        return send(url);
    }
    
	public static String send(String url, String request)  {
		HttpClient client = getHttpClient();
		//log.debug(String.format("Request: url=%s, request=%s",  url, request));
		
		HttpPost post = getHttpPost(url, request);
		String response = null;
		try {
			HttpResponse res = client.execute(post);
			//log.debug(res);
			int statusCode = res.getStatusLine().getStatusCode();
			//log.debug(String.format("Http statusCode = %s", statusCode));
			if (statusCode == 200) {
				response = EntityUtils.toString(res.getEntity(), "UTF-8");
				//log.debug(String.format("Response: url=%s, response=%s", url, response));
			} else {
				//throw new Exception("NetworkException");
				log.error("NetworkException, statusCode="+statusCode);
			}
		} catch (Exception e) {
			log.error("Http send execption.", e);
		}
		return response;
	}
	
	public static String send(String url)  {
		HttpClient client = getHttpClient();
		//log.debug(String.format("Request: url=%s, request=%s",  url, request));
		
		HttpGet get = getHttpGet(url);
		String response = null;
		try {
			HttpResponse res = client.execute(get);
			//log.debug(res);
			int statusCode = res.getStatusLine().getStatusCode();
			//log.debug(String.format("Http statusCode = %s", statusCode));
			if (statusCode == 200) {
				response = EntityUtils.toString(res.getEntity(), "UTF-8");
				//log.debug(String.format("Response: url=%s, response=%s", url, response));
			} else {
				//throw new Exception("NetworkException");
				log.error("NetworkException, statusCode="+statusCode);
			}
		} catch (Exception e) {
			log.error("Http send execption.", e);
		}
		return response;
	}

	public static HttpClient getHttpClient() {

		HttpClient client = new DefaultHttpClient();
		HttpParams httpParams = client.getParams();
		httpParams.setBooleanParameter("http.protocol.expect-continue", false);
		HttpConnectionParams.setConnectionTimeout(httpParams, timeout);
		HttpConnectionParams.setSoTimeout(httpParams, timeout);
		
		return client;
	}

	public static HttpPost getHttpPost(String url, String contextString) {
		HttpPost post = new HttpPost(url);
		post.setHeader(HTTP_HEAD_CONTENT_TYPE, HTTP_HEAD_CONTENT_TYPE_VALUE);
		post.setHeader("Connection", "close");
		HttpEntity entity=null;
		try {
			entity = new ByteArrayEntity(contextString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		post.setEntity(entity);

		return post;
	}
	
	public static HttpGet getHttpGet(String url) {
		HttpGet get = new HttpGet(url);
		get.setHeader(HTTP_HEAD_CONTENT_TYPE, HTTP_HEAD_CONTENT_TYPE_VALUE);
		return get;
	}
}
