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

import net.luckywings.mobigame.server.cas.service.vo.AccountVO;
import net.luckywings.mobigame.server.logical.service.mobiapi.ApiException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);


    /**
     * 用户登录
     */
    public AccountVO login(AccountVO vo) throws ApiException {
        return sendRequest("account/login", vo, EnumDataServiceType.CAS, AccountVO.class);
    }

}
