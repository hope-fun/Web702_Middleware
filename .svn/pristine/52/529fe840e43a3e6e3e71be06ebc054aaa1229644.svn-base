/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.model.AbstractStaticModel;

@Entity
@Table(name = "mw_pay_auth")
@Data
@EqualsAndHashCode(callSuper = false)
public class PayAuth extends AbstractStaticModel {

    private static final long serialVersionUID = 4717905209336568691L;

    /** 公司代码 */
    @Column(length = 64)
    private String factoryId;

    /** APP代码 */
    @Column(length = 64)
    private String factoryServiceId;

    /** AppKEY */
    @Column(name = "app_key", length = 64)
    private String key;

    /** 游戏ID */
    private long gameId;

    /** 渠道ID */
    private long channelId;
    
    /** 回调地址 */
    @Column(length = 255)
    private String notifyURL;
    
    /** 跳转地址 */
    @Column(length = 255)
    private String directURL;

}
