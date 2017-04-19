/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.utils;

/**
 * 数据库枚举类型定义
 * 
 * @ClassName: EnumFieldPjz
 * @author zhang.kun
 * @date 2014-6-5
 */

public enum FTPStatus {

	// Common 0 - 99
	DELETE_REMOTE_SUCCESS(0, "删除成功"),
	DELETE_REMOTE_FAILED(1,"删除失败"),
	FILE_NOT_EXIST(2,"文件不存在"),
	RENAME_REMOTE_SUCCESS(3,"文件不存在"),
	RENAME_REMOTE_FAILED(4,"文件不存在"),
	SERVER_ANDROID(3,"安卓");

	
	private final int code;
	private final String comments;

	FTPStatus(final int code, final String comments) {
		this.code = code;
		this.comments = comments;
	}

	public static FTPStatus fromCode(final int code) {
		for (FTPStatus s : FTPStatus.values()) {
			if (s.code == code) {
				return s;
			}
		}
		return null;
	}
	
	public static FTPStatus fromName(final String name) {
        for (FTPStatus s : FTPStatus.values()) {
            if (s.name().equals(name)) {
                return s;
            }
        }
        return null;
    }

	public int getCode() {
		return code;
	}

	public String getComments() {
		return toString();
	}

	public String toString() {
		return comments;
	}
}
