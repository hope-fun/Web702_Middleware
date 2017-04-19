/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi.modules;

import java.util.List;

import net.luckywings.mobigame.server.cas.service.vo.ServerVO;
import net.luckywings.mobigame.server.logical.busi.service.ServerService;
import net.luckywings.mobigame.server.logical.request.mobiapi.ApiInfoRequest;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiServerListResponse;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;
import net.luckywings.mobigame.server.logical.service.mobiapi.BaseModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerModule extends BaseModule {

    @Autowired
    private ServerService service;

    /**
     * 获取服务器列表
     */
    public ApiServerListResponse list(ApiInfoRequest request) throws ApiException {

        List<ServerVO> list = service.list();
        return new ApiServerListResponse(list);
    }
}
