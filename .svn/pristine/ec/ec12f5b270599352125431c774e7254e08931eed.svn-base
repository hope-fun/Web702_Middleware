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


/**
 * 游戏支付平台
 */
@Entity
@Table(name = "mw_channel")
@Data
@EqualsAndHashCode(callSuper = false)
public class Channel extends AbstractStaticModel {

    private static final long serialVersionUID = 4717905209336568691L;

    /** 渠道名 */
    @Column(length = 64, nullable = false)
    private String name;
    
    /** 渠道号 */
    @Column(length = 64, nullable = false)
    private String code;
    
    /** 描述 */
    @Column(length = 255)
    private String description;
    
    /** 备注 */
    @Column(length = 255)
    private String mark;
    
}
