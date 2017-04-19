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
import net.luckywings.mobigame.server.model.enumtype.EnumFieldPjz;
import net.luckywings.mobigame.server.service.BaseStaticVO;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServerVO extends BaseStaticVO {

	private static final long serialVersionUID = 3087939847792686360L;

	private String name;		// 名称
	private String description;	// 描述
	private String url;			// 地址
	private String port;		// 端口
	private String longUrl;		// 长连地址
	private String longPort;	// 长连端口
	private EnumFieldPjz status;// 服务器状态
	private EnumFieldPjz type;	// 服务器类型
	private int orderNum;		// 序号
	private int userMaxNum;		// 最大在线人数
	private int userCurrentNum;	// 当前在线人数

}
