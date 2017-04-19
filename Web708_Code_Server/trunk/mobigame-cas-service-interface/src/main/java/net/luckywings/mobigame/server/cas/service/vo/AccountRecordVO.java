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

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.luckywings.mobigame.server.service.BaseVO;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountRecordVO extends BaseVO {
	
	private static final long serialVersionUID = 3087939847792686360L;

	private String accountId;	// 账户ID
	private Date loginTime;     // 登陆游戏时间
	private String loginIp;     // 登陆IP
	private long loginGame;   	// 登陆游戏ID
}
