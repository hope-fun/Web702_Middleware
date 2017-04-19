/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
///*****************************************************************************
// *
// *                      HOPERUN PROPRIETARY INFORMATION
// *
// *          The information contained herein is proprietary to HopeRun
// *           and shall not be reproduced or disclosed in whole or in part
// *                    or used for any design or manufacture
// *              without direct written authorization from HopeRun.
// *
// *            Copyright (c) 2013 by HopeRun.  All rights reserved.
// *
// *****************************************************************************/
//package net.luckywings.mobigame.server.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.MappedSuperclass;
//
///**
// * @author wujianjun
// * @Date 2014-10-10
// */
//@MappedSuperclass
//public abstract class AbstractModelStatus  implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//
//	/** 删除状态 */
//	@Column(length = 20)
//	@Enumerated(EnumType.STRING)
//	private Status deleteStatus = Status.VALID;
//
//	public Status getDeleteStatus() {
//		return deleteStatus;
//	}
//
//	public void setDeleteStatus(Status deleteStatus) {
//		this.deleteStatus = deleteStatus;
//	}
//
//
//	/**
//	 * Commonly used status codes defined for data model.
//	 */
//	public enum Status {
//		/**
//		 * 0 VALID, The data is valid
//		 */
//		VALID(0, "Valid"),
//		/**
//		 * 1 INVALID, The data is invalid
//		 */
//		INVALID(1, "Invalid"),
//		/**
//		 * 2 DELETED, The data is deleted
//		 */
//		DELETED(2, "Deleted"),
//		/**
//		 * 3 CREATED
//		 */
//		CREATED(3, "Created"),
//		/**
//		 * 4 PAY_SUCCESS
//		 */
//		PAY_SUCCESS(4, "Pay success"),
//		/**
//		 * 5 PAY_FAIL
//		 */
//		PAY_FAIL(5, "Pay fail");
//
//		private final int code;
//		private final String comments;
//
//		Status(final int statusCode, final String reasonPhrase) {
//			this.code = statusCode;
//			this.comments = reasonPhrase;
//		}
//
//		public int getStatusCode() {
//			return code;
//		}
//
//		public String getcomments() {
//			return comments;
//		}
//
//		public static Status fromStatusCode(final int statusCode) {
//			for (Status s : Status.values()) {
//				if (s.code == statusCode) {
//					return s;
//				}
//			}
//			return null;
//		}
//	}
//}