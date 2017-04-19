/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/** ID */
	@Id
	@Column(length = 64)
	private String id;

	/** 删除状态 */
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Status deleteStatus = Status.VALID;

	/** 更新时间 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	/** 创建时间 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	public AbstractModel() {
		this.id = UUID.randomUUID().toString();
	}

	public AbstractModel(String customId) {
		this.id = customId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Status getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Status deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractModel)) {
			return false;
		}
		AbstractModel other = (AbstractModel) obj;
		return getId().equals(other.getId());
	}

	/**
	 * Commonly used status codes defined for data model.
	 */
	public enum Status {
		/**
		 * 0 VALID, The data is valid
		 */
		VALID(0, "Valid"),
		/**
		 * 1 INVALID, The data is invalid
		 */
		INVALID(1, "Invalid"),
		/**
		 * 2 DELETED, The data is deleted
		 */
		DELETED(2, "Deleted"),
		/**
		 * 3 CREATED
		 */
		CREATED(3, "Created"),
		/**
		 * 4 PAY_SUCCESS
		 */
		PAY_SUCCESS(4, "Pay success"),
		/**
		 * 5 PAY_FAIL
		 */
		PAY_FAIL(5, "Pay fail");

		private final int code;
		private final String comments;

		Status(final int statusCode, final String reasonPhrase) {
			this.code = statusCode;
			this.comments = reasonPhrase;
		}

		public int getStatusCode() {
			return code;
		}

		public String getcomments() {
			return comments;
		}

		public static Status fromStatusCode(final int statusCode) {
			for (Status s : Status.values()) {
				if (s.code == statusCode) {
					return s;
				}
			}
			return null;
		}

	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}