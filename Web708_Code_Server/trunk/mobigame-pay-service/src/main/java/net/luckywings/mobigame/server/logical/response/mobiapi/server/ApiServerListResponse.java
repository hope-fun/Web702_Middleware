/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.response.mobiapi.server;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.cas.service.vo.ServerVO;
import net.luckywings.mobigame.server.logical.response.mobiapi.ApiBaseResponse;

/**
 * @ClassName: ApiServerListResponse
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApiServerListResponse extends ApiBaseResponse {

    private int size;
    private List<ServerVO> list;

    public ApiServerListResponse() {

    }

    public ApiServerListResponse(List<ServerVO> list) {
        if (list != null && list.size() > 0) {
            this.size = list.size();
            this.list = list;
        }
    }
}
