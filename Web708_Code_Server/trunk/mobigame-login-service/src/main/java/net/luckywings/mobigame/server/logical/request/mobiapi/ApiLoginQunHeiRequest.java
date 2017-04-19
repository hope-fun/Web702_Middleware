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

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiLoginQunHeiRequest extends ApiBaseRequest {

	private String username;
	private String serverid;
	private String isadult;
	private String time;
	private String uimg;
	private String nname;
	private String unid;
	private String flag;

	@Override
	public boolean isValid() {
		return true;
	}

}
