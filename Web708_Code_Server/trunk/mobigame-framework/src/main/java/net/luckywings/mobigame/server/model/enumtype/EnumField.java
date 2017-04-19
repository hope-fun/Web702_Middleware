/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.model.enumtype;

/**
 * 数据库枚举类型定义
 * 
 * @ClassName: EnumField
 * @author zhang.kun
 * @date 2014-6-5
 */

public enum EnumField {

	// Common 0 - 99
	NONE(0, "类型为空"),
	SERVER_ALL(1,"所有服务"),
	SERVER_IOS(2,"苹果"),
	SERVER_ANDROID(3,"安卓");

	
	private final int code;
	private final String comments;

	EnumField(final int code, final String comments) {
		this.code = code;
		this.comments = comments;
	}

	public static EnumField fromCode(final int code) {
		for (EnumField s : EnumField.values()) {
			if (s.code == code) {
				return s;
			}
		}
		return null;
	}
	
	public static EnumField fromName(final String name) {
        for (EnumField s : EnumField.values()) {
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
