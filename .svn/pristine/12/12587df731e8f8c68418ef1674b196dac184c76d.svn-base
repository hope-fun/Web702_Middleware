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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.model.AbstractStaticModel;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldPjz;

/**
 * 服务器列表
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "mw_server")
public class Server extends AbstractStaticModel {
	
    private static final long serialVersionUID = 2536983658570497721L;

    /** 名称 */
    @Column(length = 64)
    private String name;

    /** 描述 */
    @Column(length = 255)
    private String description;

    /** 地址 */
    @Column(length = 255)
    private String url;

    /** 端口 */
    @Column(length = 32)
    private String port;
    
    /** 长连地址 */
    @Column(length = 255)
    private String longUrl;

    /** 长连端口 */
    @Column(length = 32)
    private String longPort;

    /** 服务器状态 */
    @Enumerated(EnumType.STRING)
    private EnumFieldPjz status;

    /** 服务器类型 */
    @Enumerated(EnumType.STRING)
    private EnumFieldPjz type;

    /** 序号 */
    private int orderNum;

    /** 最大在线人数 */
    private int userMaxNum;

    /** 当前在线人数 */
    private int userCurrentNum;

}
