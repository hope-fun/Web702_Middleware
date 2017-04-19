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
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiLoginAuthRequest extends ApiBaseRequest {

    private String identifier;          // 识别码
    private String credential;          // 凭据
    private EnumFieldH5 identityType;   // 认证类型

    @Override
    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "Identifier: " + this.identifier + ", Credential:" + this.credential + ", IdentityType:" + this.identityType;
    }
}
