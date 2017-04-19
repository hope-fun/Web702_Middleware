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
 * @ClassName: EnumType
 * @author nikm
 * @date 2013-8-13
 *
 */
public enum EnumFieldCfy {
	/*** 物品类别 */
	GCOIN(0, "金币"),
	ITEM(1, "道具"),
	
	/*** ACHIEVEMENT_REQUIRE */
	AREQ1(11, "完成答题"),
	AREQ2(12, "不借助道具成功答题"),
	AREQ3(13, ""),
	AREQ4(14, ""),
	AREQ5(15, "使用金币开启问题包"),
	AREQ6(16, "累计获得金币"),
	AREQ7(17, "使用道具"),
	AREQ8(18, "分享游戏问题"),
	AREQ9(19, "分享游戏"),
	AREQ10(20, ""),
	AREQ11(21, "完成上海话关卡"),
	AREQ12(22, "完成4川话关卡"),
	AREQ13(23, "完成东北话关卡"),
	AREQ14(24, "完成山东话关卡"),
	AREQ15(25, "完成台湾话关卡"),
	AREQ16(26, "总共完成关卡");
	
	private final int code;
    private final String comments;
    
    EnumFieldCfy(final int code, final String comments) {
        this.code = code;
        this.comments = comments;
    }
    
    public static EnumFieldCfy fromCode(final int code) {
        for (EnumFieldCfy s : EnumFieldCfy.values()) {
            if (s.code == code) {
                return s;
            }
        }
        return null;
    }

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return toString();
	}
	
    /**
     * @return the reason phrase
     */
    public String toString() {
        return comments;
    }
}
