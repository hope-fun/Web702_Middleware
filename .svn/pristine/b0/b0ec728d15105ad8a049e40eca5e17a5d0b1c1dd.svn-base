/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.logical.response.mobiapi;

import net.luckywings.mobigame.server.logical.service.mobiapi.ApiResponseStatus;

/**
 * @ClassName: ApiErrorResponse
 * @author nikm
 * @date 2013-7-20
 */
public class ApiErrorResponse extends ApiBaseResponse {

	private int errorCode;
	private String errorStatus;
	private String errorMessage;

	public ApiErrorResponse(ApiResponseStatus status) {
		if (status != null) {
			this.errorCode = status.getStatusCode();
			this.errorStatus = status.getReasonPhrase();
		} else {
			this.errorCode = ApiResponseStatus.UNKNOWN.getStatusCode();
			this.errorStatus = ApiResponseStatus.UNKNOWN.getReasonPhrase();
		}
	}
	
	public ApiErrorResponse(ApiResponseStatus status, String message) {
		if (status != null) {
			this.errorCode = status.getStatusCode();
			this.errorStatus = status.getReasonPhrase();
			this.errorMessage = message;
		} else {
			this.errorCode = ApiResponseStatus.UNKNOWN.getStatusCode();
			this.errorStatus = ApiResponseStatus.UNKNOWN.getReasonPhrase();
			this.errorMessage = message;
		}
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorStatus
	 */
	public String getErrorStatus() {
		return errorStatus;
	}

	/**
	 * @param errorStatus
	 *            the errorStatus to set
	 */
	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}