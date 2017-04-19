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

/**
 * 购买物品
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApiItemRequest extends ApiBaseRequest {

    private String id;
    private String name;
    private double price;
    private int count;
    private EnumFieldH5 currency;

    @Override
    public boolean isValid() {
        return true;
    }
}
