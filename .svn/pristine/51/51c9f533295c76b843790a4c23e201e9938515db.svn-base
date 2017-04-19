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

import net.luckywings.mobigame.server.utils.StringUtils;
 
/**
 * @ClassName: ApiRegisterRequest
 * @author nikm
 * @date 2013-7-22
 */
public class ApiRegisterRequest extends ApiBaseRequest {

	private String imei;
	private String username;
	private String password;
	private String phone;
	
	
	@Override
	public boolean isValid() {
		return (StringUtils.isNotEmpty(this.username) && StringUtils.isNotEmpty(this.password) && StringUtils.isNotEmpty(this.imei));
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
