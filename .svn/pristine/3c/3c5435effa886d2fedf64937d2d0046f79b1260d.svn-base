package net.luckywings.mobigame.server.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.luckywings.mobigame.server.helper.HttpClientHelper;

public class SendUtils {
	private static final Logger logger = LoggerFactory.getLogger(SendUtils.class);

	public static String send(String url) {
		try {
			// For stress testing
			long ts = System.currentTimeMillis();
			logger.info(String.format("Request: url=%s", url));
			String response = HttpClientHelper.get(url);
			// HttpClientHelper.
			logger.info(String.format("Response: url=%s, response=%s", url, response));
			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te - ts)));
			return response;
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
			return null;
		}
	}

	public static String send(String url, Object request) {
		try {
			// For stress testing
			long ts = System.currentTimeMillis();

			String requestString = JsonUtils.toJson(request);
			logger.debug(String.format("Request: url=%s, request=%s", url, requestString));

			String response = HttpClientHelper.post(url, requestString);
			// log.debug(String.format("Response: url=%s, response=%s", url,
			// response));

			// For stress testing
			long te = System.currentTimeMillis();
			logger.debug(String.format("Request data service url=%s, execute time=%sms ", url, (te - ts)));

			return response;
		} catch (Exception e) {
			logger.error("Request data service error: ", e);
			return null;
		}
	}
}
