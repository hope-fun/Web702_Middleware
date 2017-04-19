/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.service.mobiapi;


/**
 * TODO
 * 
 * @ClassName: ApiException
 * @author nikm
 * @date 2013-7-22
 *
 */
public class ApiException extends Exception {
	private static final long serialVersionUID = -8676009213343194677L;

	private ApiResponseStatus status;

	/**
	 * @return the status
	 */
	public ApiResponseStatus getStatus() {
		return status;
	}
	
	/**
	 * 
	 */
	public ApiException() {
	}

	/**
	 * @param message
	 */
	public ApiException(ApiResponseStatus status) {
		super("");
		this.status = status;
	}
	
	/**
	 * @param message
	 */
	public ApiException(ApiResponseStatus status, String message) {
		super(message);
		this.status = status;
	}
	
	/**
	 * @param message
	 */
	public ApiException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApiException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}
}
