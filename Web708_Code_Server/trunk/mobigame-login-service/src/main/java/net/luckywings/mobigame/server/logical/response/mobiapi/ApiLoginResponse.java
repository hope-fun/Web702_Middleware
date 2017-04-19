/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.response.mobiapi;

import java.util.List;

import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.cas.service.vo.ServerVO;

@EqualsAndHashCode(callSuper = false)
public class ApiLoginResponse extends ApiBaseResponse {

    private ApiServerListResponse servers;

    public ApiLoginResponse() {

    }

    public ApiLoginResponse(List<ServerVO> list) {
        this.servers = new ApiServerListResponse(list);
    }
}
