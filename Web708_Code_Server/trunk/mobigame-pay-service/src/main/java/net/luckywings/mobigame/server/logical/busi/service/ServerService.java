/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.busi.service;

import java.util.List;

import net.luckywings.mobigame.server.cas.service.vo.ServerVO;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;
import net.luckywings.mobigame.server.service.vo.BaseSearchVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author nikm
 * @Date 2013-3-8
 */
@Service
public class ServerService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(ServerService.class);

    /**
     * 服务器列表
     */
    public List<ServerVO> list() throws ApiException {
        List<ServerVO> list =
                sendRequestList("server/list", new BaseSearchVO(), EnumDataServiceType.CAS,
                        ServerVO.class);
        return list;
    }

}
