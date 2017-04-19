/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.response.mobiapi.pay;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiCreateOrderTaomDataiResponse extends ApiPayCreateOrderResponse {

    private String client_id;
    private String account;
    private String transasction_id;
    private String server_id;
    private String product_id;
    private int quantity;
  
    private float amount;
    private String currency;
    private int purchase_time_sec;
    private String purchase_time;
    private String payload;
    
    
}
