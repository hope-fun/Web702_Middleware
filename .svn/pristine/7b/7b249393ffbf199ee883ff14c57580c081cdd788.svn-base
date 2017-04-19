/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import net.luckywings.mobigame.server.logical.request.mobiapi.ApiBaseRequest;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiBaseResponse;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiErrorResponse;
import net.luckywings.mobigame.server.utils.JsonUtils;
import net.luckywings.mobigame.server.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.JsonSyntaxException;

@Component
@Path(value = "/")
public class ApiIndex {

    private static final Logger log = LoggerFactory.getLogger(ApiIndex.class);

    // API版本号
    private static final int version = 1;

    // 不需要登录的模块列表
    private static final String accessList = "";

    @Autowired
    private ApplicationContext context;

    @Autowired
    private HttpServletRequest request;

    @POST
    @Path("/{v}/{m}/{a}")
    public Response dispatch(@PathParam("v") int v, @PathParam("m") String m,
            @PathParam("a") String a, @RequestBody String requestString) {

        log.info(String.format("API request: url=%s/%s, request=%s", m, a, requestString));

        // For stress testing
        long ts = System.currentTimeMillis();

        String appKey = request.getHeader("App-Key");
        String appToken = request.getHeader("App-Token");
        String sid = request.getHeader("User-Token");

        log.debug(String.format("AppKey=%s, AppToken=%s, UTK=%s", appKey, appToken, sid));

        ResponseBuilder builder = null;
        if (!isAppTokenValid(appKey, appToken)) {
            builder = errorResponseBuilder(Response.Status.FORBIDDEN);
            return builder.build();
        }

        BaseModule module = null;

        try {
            // 获取请求模块
            String beanName = StringUtils.toLowerFirstChar(m) + "Module";
            module = (BaseModule) context.getBean(beanName);

            // 获取请求方法和请求参数
            a = StringUtils.toLowerFirstChar(a);
            Method method = module.getActionMethod(a);
            ApiBaseRequest requestObj = (ApiBaseRequest) getRequestData(method, requestString);

            if (v != version) { // 请求的版本号不匹配
                log.error("Version not match.");
                ApiErrorResponse apiResponse = new ApiErrorResponse(ApiResponseStatus.NOT_MATCH);
                builder = apiResponse.getResponseBuilder();
            } else if (requestObj == null || !requestObj.isValid()) { // 请求参数非法
                log.error("Request not valid.");
                builder = errorResponseBuilder(Response.Status.BAD_REQUEST);
            } else {
//                if (module.getSession() == null && accessList.indexOf(m + "/" + a) < 0) { // 未验证登录或已过期
//                    log.error("Session expired.");
//                    builder = errorResponseBuilder(Response.Status.UNAUTHORIZED);
//                } else { // 正常处理请求
                    ApiBaseResponse apiResponse =
                            (ApiBaseResponse) module.execute(method, requestObj);
                    builder = apiResponse.getResponseBuilder();
//                }
            }
        } catch (ApiException e) {
            String reason = e.getMessage();
            int code = 0;
            log.error("**********************************************************************************************");
            if (e.getStatus() != null) {
                reason = e.getStatus().getReasonPhrase();
                code = e.getStatus().getStatusCode();
            }
            log.error("********************* error reason: " + reason);
            if (code != 0) {
                log.error("********************* error code  : " + code);
            }
            log.error("**********************************************************************************************");
            builder = new ApiErrorResponse(e.getStatus(), e.getMessage()).getResponseBuilder();
        } catch (NoSuchBeanDefinitionException e) {
            log.error("Module not found.");
            builder = errorResponseBuilder(Response.Status.NOT_FOUND);
        } catch (BeansException e) {
            log.error("Can not init module.");
            builder = errorResponseBuilder(Response.Status.SERVICE_UNAVAILABLE);
        } catch (JsonSyntaxException e) {
            log.error("Json error.", e);
            builder = errorResponseBuilder(Response.Status.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Execute action error.", e);
            builder = errorResponseBuilder(Response.Status.INTERNAL_SERVER_ERROR);
        }

        builder.header("App-Key", appKey);
        builder.header("App-Token", appToken);
        builder.header("User-Token", sid);

        // For stress testing
        long te = System.currentTimeMillis();
        log.debug(String.format("API request: url=%s/%s, execute time=%sms ", m, a, (te - ts)));
        return builder.build();
    }

    private Object getRequestData(Method method, String requestString) {
        Class<?> paramsClass = method.getParameterTypes()[0];

        if ("".equals(requestString)) { // For list search
            requestString = "{\"pageSize\":10,\"pageIndex\":0}";
        }
        Object request = JsonUtils.fromJson(requestString, paramsClass);
        return request;
    }

    private ResponseBuilder errorResponseBuilder(Response.Status status) {
        ResponseBuilder builder = Response.status(status);
        return builder;
    }

    private boolean isAppTokenValid(String key, String token) {
        return true;
    }
}
