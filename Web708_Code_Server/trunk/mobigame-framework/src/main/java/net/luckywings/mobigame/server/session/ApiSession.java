/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.session;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.utils.CommonUtils;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiSession implements Serializable {

    private static final long serialVersionUID = 8828842179865427327L;

    private String roleId; // 内部的playerId 玩家唯一id
    private String sessionId;

    public ApiSession() {
        this.sessionId = CommonUtils.uuid();
    }

    public ApiSession(String suffix) {
        this.sessionId = CommonUtils.uuid() + suffix;
    }
}
