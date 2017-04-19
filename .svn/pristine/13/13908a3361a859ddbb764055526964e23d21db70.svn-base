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
import net.luckywings.mobigame.server.model.enumtype.EnumFieldH5;

/**
 * 游戏
 */
@Entity
@Table(name = "mw_game")
@Data
@EqualsAndHashCode(callSuper = false)
public class Game extends AbstractStaticModel {

	private static final long serialVersionUID = 4977718046960322220L;

	/** 游戏名 */
	@Column(length = 64, nullable = false)
	private String name;

	/** 游戏号 */
	@Column(length = 64, nullable = false)
	private String code;

	/** 游戏地址 */
	@Column(length = 255)
	private String gameUrl;

	/** 游戏类型 */
	@Enumerated(EnumType.STRING)
	private EnumFieldH5 type;

	/** 描述 */
	@Column(length = 255)
	private String description;

	/** 备注 */
	@Column(length = 255)
	private String mark;

}
