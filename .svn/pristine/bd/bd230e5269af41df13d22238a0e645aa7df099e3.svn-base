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
public class AccountVO extends BaseVO {
	
    private static final long serialVersionUID = 3087939847792686360L;

    private String roleId;          // 游戏角色ID
    
    // The register ip can be get from account record
//    private String registerIp;      // 注册账号IP
    
    private AccountAuthVO auth;		// 账户认证
    private AccountRecordVO record;	// 账户记录
}
