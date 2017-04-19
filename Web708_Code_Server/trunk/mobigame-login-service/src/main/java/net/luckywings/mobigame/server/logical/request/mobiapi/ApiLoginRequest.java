/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.request.mobiapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiLoginRequest<T> extends ApiBaseRequest {

    // common params
    
    private long game;	     // 游戏ID
    private long channel;    // 渠道ID

    private ApiLoginAuthRequest auth;
    
    private Object extra;

    @Override
    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "Game: " + this.game + ", Channel:" + this.channel;
    }
}
