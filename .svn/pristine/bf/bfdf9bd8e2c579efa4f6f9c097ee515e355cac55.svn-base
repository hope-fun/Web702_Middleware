/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.service.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.service.BaseVO;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayAuthVO extends BaseVO {

    private static final long serialVersionUID = 3087939847792686360L;

    private String factoryId;			// 公司代码
    private String factoryServiceId;	// APP代码
    private String key;					// AppKEY
    private long gameId;				// 游戏ID
    private long channelId;				// 渠道ID
    private String notifyURL;			// 回调地址 
    private String directURL;			// 跳转地址

    public PayAuthVO() {

    }

    public PayAuthVO(long gameId, long channelId) {
        super();
        this.gameId = gameId;
        this.channelId = channelId;
    }
}
