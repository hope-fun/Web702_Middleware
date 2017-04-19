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
//package net.luckywings.mobigame.server.model.enumtype;
//
///**
// * 数据库枚举类型定义
// * 
// * @ClassName: EnumField
// * @author nikm
// * @date 2013-9-6
// *
// */
//public enum EnumFieldWztx {	
//	NONE(0,"类型为空"),
//	/** 阵营*/
//	CAMP_XIAN(1, "仙"),
//	CAMP_SHEN(2, "神"),
//	CAMP_XIE(3, "邪"),
//	
//	/** 货币类型 */
////	MONEY_FPOINT(11, "友情点"),
//	MONEY_GCOIN(12, "金币"),
//	MONEY_DIAMOND(13, "钻石"),
//	MONEY_CASH(14, "现金"),
////	MONEY_AIR_TICKET(14, "机票"),
//	
//	/** 物品类别 */
//	ITEM_CARD(21, "类型卡牌"),
//	ITEM_PET(22, "类型宠物"),
//	ITEM_ICON(23, "类型头像"),
//	ITEM_APOINT(24, "类型成就点数"),
//	ITEM_POWDER(25, "粉末"),
//	ENERGY(26,"体能"),
////	CARD_COUNT_MAX(26,"卡牌上限"),  //和策划确认 去掉
//	DOUBLE_EXP(27,"双倍经验"),
//	DOUBLE_GCOIN(28,"双倍金币"),
//	
//	/** 物品状态 */
////	STATUS_GOT(31, "已获得"),
////	STATUS_NOT_GOT(32, "未获得"),
////	STATUS_SELECTED(33, "已选择"),
////	STATUS_BIND(34, "已绑定"),
////	STATUS_SHARED(35, "已共享"),
////	STATUS_GROUP(36, "已在卡组中"),
////	STATUS_SHARED_AND_GROUP(37, "已共享并且已在卡组中"),
////	STATUS_BIND_AND_GROUP(38, "已绑定并且已在卡组中"),
//	
//	/** 宠物类别*/
//	PET_YS(41, "野兽系"),
//	PET_YM(42, "幽冥系"),
//	PET_FX(42, "飞行系"),
//	PET_LS(42, "灵兽系"),
//	PET_ZW(42, "植物系"),
//	PET_SS(42, "神兽系"),
//	PET_XSC(43, "新手宠"),
//	PET_BOSS(44, "BOSS"),
//	
//	/** 通知类型 */
//	NOTICE(61, "系统公告"),
//	NOTICE_PUSH(62, "推送通知"),
//	
//	/** 商品促销,上架状态 */
//	Y(71, "Y"),
//	N(72, "N"),
//	SHOP_PROMOTION_NONE(73, "无"),
//	SHOP_PROMOTION_NEW(74, "新上物品"),
//	SHOP_PROMOTION_HOT(75, "热卖物品"),
//	SHOP_PROMOTION_BEST(76, "推荐打折商品"),
//	 
//	/** 卡牌技能类型 */
//	SKILL_FCYH(100, "房产优惠"),
//	SKILL_SGZK(101, "收购折扣"),
//	SKILL_SZZY(102, "收租增益"),
//	SKILL_ZJJM(103, "租金减免"),
//	SKILL_YWZ(104, "初始愿望值"),
//	SKILL_WZSJ(105, "提升未知事件好的几率"),
//	SKILL_DJC(106, "停留度假村花费减免"),
//	SKILL_CZCF(107, "出租车车费减免"),
//	SKILL_CZCC(108, "出租车路程增加"),
//	SKILL_NSZF(109, "纳税点支付减免"),
//	SKILL_GZHD(110, "工资获得增加"),
//	SKILL_YDSX(111, "移动上限增加"),
//	SKILL_SJJY(112, "升级经验增加"),
//	SKILL_JNLQ(113, "技能冷却减免"),
//	SKILL_CSZJ(114, "初始资金增加"),
//	SKILL_ZDJN(115,"组队技能"),
//	
//	/** 用户头像解锁条件 */
//	ICON_UL_LEVEL(201, "等级需求"),
//	ICON_UL_BEAT(202, "击败玩家次数"),
//	ICON_UL_SHOUZU(203, "收取玩家租金次数"),
//	ICON_UL_WIN(204, "匹配模式下胜利次数"),
//	ICON_UL_WIN10(205, "在匹配模式下以10倍资金数击败一名玩家"),
//	ICON_UL_PET(206, "拥有宠物数量"),
//	ICON_UL_PET_FX(207, "拥有飞行宠物数量"),
//	ICON_UL_PET_YM(208, "拥有幽冥宠物数量"),
//	ICON_UL_PET_YS(209, "拥有野兽宠物数量"),
//	ICON_UL_SKILL_YS(210, "使用野兽系宠物使用大招"),
//	
//	/** 宠物解锁条件 */
//	PET_UL_WIN(241, "胜利次数"),
//	PET_UL_ROUND(242, "绕场次数"),
//	PET_UL_ONE(243, "掷骰子为1次数"),
//	PET_UL_SIX(244, "掷骰子为6次数"),
//	PET_UL_SKILL(245, "使用宠物技能次数"),
//	PET_UL_STEP(246, "行走格子数"),
//	PET_UL_JIAOZU(247, "交付租金次数"),
//	
//	/** 好友状态 */
//	RELATION_APPLY(254, "申请"),
//	RELATION_REFUSED(255, "拒绝"),
//	RELATION_CONFIRM(256, "确定"),
//	
//	/**地图的类型 */
//	MAP_ST(300," 起始点"), // 起始点
//	MAP_B1(301,"商业街1"), // 商业街1 
//	MAP_NB(302,"普通地产"), // 普通地产
//	MAP_TAXI(303,"出租车"), // 出租车
//	MAP_B2(304,"商业街2"), // 商业街2
//	MAP_HV(305,"度假村"), // 度假村
//	MAP_SE(306,"特殊事件"), // 特殊事件
//	MAP_IN(307,"投资公司"), // 投资公司
//	MAP_TAX(308,"纳税点"), // 纳税点
//    MAP_CAIPIAO(309,"彩票点"),
//    MAP_GUAISHOU(310,"怪兽点"),
//    MAP_FENGXIAN(311,"风险投资"),
//    MAP_JIAYOU(312,"加油站"),
//
//	/** 地图 类型，当同一组内2个或以上 的建筑物构成连锁条件时，类型相同 */
//	MAP_TYPE_START(321,"起始点"),
//	MAP_TYPE_1(322,"第一个连锁点"),
//	MAP_TYPE_2(323,"第二个连锁点"),
//	MAP_TYPE_3(324,"第三个连锁点"),
//	MAP_TYPE_4(325,"第四个连锁点"),
//	MAP_TYPE_5(326,"第五个连锁点"),
//	MAP_TYPE_6(327,"第六个连锁点"),
//	MAP_TYPE_7(328,"第七个连锁点"),
//	MAP_TYPE_8(329,"第八个连锁点"),
//	
//	/** 特殊事件 */
//	SPECIAL_EVENT_1(340,"自动导航"),
//	SPECIAL_EVENT_2(341,"政府投资"),
//	SPECIAL_EVENT_3(342,"鬼迷心窍"),
//	SPECIAL_EVENT_4(343,"自然灾害"),
//	
//	/** 道具事件 */
//	PROPS_SYSTEM_WINDFALL(350,"天降横财"),
//	PROPS_SYSTEM_ACCIDENT(351,"飞来横祸"),
//	PROPS_SYSTEM_LUCKY_STARS(352,"福星高照"),
//	PROPS_SYSTEM_STRUCKBY_DISEASE(353,"病魔缠身"),
//	
//	/** 成就条件 */
//	ACHIEVEMENT_VICTORY(401,"任意模式获得胜利"),
//	ACHIEVEMENT_PET(402,"拥有宠物"),
//	ACHIEVEMENT_A_CARD(403,"拥有A级以上的卡牌"),
//	ACHIEVEMENT_TAXI(405,"打车次数"),
//	ACHIEVEMENT_COLLECT_RENT(406,"收租次数"),
//	ACHIEVEMENT_PAY_RENT(407,"交租次数"),
//	ACHIEVEMENT_PER_ASSET(408,"单局游戏资产达到100,000以上"),
//	ACHIEVEMENT_FRIEND(409,"拥有好友人数"),
//	ACHIEVEMENT_OWNER(410,"做房主次数"),
//	ACHIEVEMENT_USE_PET_SKILL(411,"使用宠物大技能次数"),
//	ACHIEVEMENT_USER_ICON(412,"拥有头像"),
//	ACHIEVEMENT_FX_PET(413,"拥有飞行系宠物"),
//	ACHIEVEMENT_YS_PET(414,"拥有野兽系宠物"),
//	ACHIEVEMENT_YM_PET(415,"拥有幽冥系宠物"),
//	ACHIEVEMENT_PER_BUILDING(416,"单局游戏占领12处以上地产"),
//	ACHIEVEMENT_NAGETIVE_EVENT(418,"遭遇负面事件"),
//	ACHIEVEMENT_POSITIVE_EVENT(419,"遭遇正面事件"),
//	ACHIEVEMENT_LEVEL_10(420,"玩家等级达到10级"),
//	ACHIEVEMENT_LEVEL_20(421,"玩家等级达到20级"),
//	ACHIEVEMENT_LEVEL_30(422,"玩家等级达到30级"),
//	ACHIEVEMENT_WIN(423,"连续游戏失败10次"),
//	ACHIEVEMENT_FAIL(424,"连续游戏胜利10次"),
//	ACHIEVEMENT_NEW_PLAYER(425,"完成新手引导"),
//	ACHIEVEMENT_TEMP1(426,"在一场游戏中达到的最高总资产。"),
//	ACHIEVEMENT_TEMP2(427,"在一场游戏中同时拥有10处房产。"),
//	
//	/**任务类型 */
//	TASK_TYPE_MAIN(440,"主线任务"),
//	TASK_TYPE_EVERYDAY(441,"每日任务"),
//	TASK_TYPE_ACTIVE(442,"活动任务"),
//	
//	/**任务状态 */
//	TASK_STATUS_START(443,"任务已开始"),
//	TASK_STATUS_FINISH(444,"任务已完成"),
//	TASK_STATUS_AWARD(445,"任务奖励已领取"),
//	
//	/**任务触发条件 */
//	TASK_WIN_ANY_MODE(450,"任意模式获得N场胜利"),
//	TASK_WIN_SINGLE_MODE(451,"人机模式获得N场胜利"),
//	TASK_WIN_MULTI_MODE(452,"匹配模式获得N场胜利"),
//	TASK_WIN_LEAGUE_MODE(453,"联赛模式获得N场胜利"),
//	TASK_CONTINUE_WIN(454,"连续游戏胜利N次"),
//	TASK_GET_ANY_CARD(455,"获得N张任意卡牌"),
//	TASK_EVOLVE_ANY_CARD(456,"强化任意卡牌N次"),
//	TASK_UPGRADE_ANY_CARD(457,"完成任意卡牌进阶N次"),
//	TASK_SELL_ANY_CARD(458,"出售任意卡牌N张"),
//	TASK_GROUP_ANY_CARD(459,"将任意卡牌加入编组"),
//	TASK_LOTTERY_FP(460,"完成N次友情抽奖"),
//	TASK_LOTTERY_GCOIN(461,"完成N次金币抽奖"),
//	TASK_LOTTERY_DIAMOND(462,"完成N次鑽石抽奖"),
//	TASK_GET_RENT(463,"收租次数"),
//	TASK_PAY_RENT(464,"交租次数"),
//	TASK_ASSET(465,"单局游戏资产达到N以上"),
//	TASK_FRIEND_COUNT(466,"拥有好友N名"),
//	TASK_ROOM_HOST(467,"做房主次数"),
//	TASK_OCCUPY_BUILDING(468,"单局游戏占领N处以上地产"),
//	TASK_PASS_STAGE(469,"通过指定关卡"),
//	TASK_PLAY_ANY_MODE(470,"进行N次任意模式游戏"),
//	TASK_PLAY_SINGLE_MODE(471,"进行N次人机模式游戏"),
//	TASK_PLAY_MULTI_MODE(472,"进行N次匹配模式游戏"),
//	TASK_PLAY_LEAGUE_MODE(473,"进行N次联赛模式游戏"),
//	TASK_ENTER_CITY(474,"进入指定城市"),
//	TASK_JOIN_CLUB(475,"加入俱乐部"),
//	TASK_CONSUME_ASSET(476,"消耗指定资源"),
//	TASK_CONSUME_CARD(477,"消耗指定卡牌"),
////	TASK_REACH_LEVEL(478,"玩家等级达到N级"),
//
//	/** 任务触发条件 */
//	TASK_CONDITION_1(901,"在任意一场对战游戏中将宠物升至满级"),
//	TASK_CONDITION_2(902,"在任意一场对战游戏中使用宠物任意技能N次"),
//	TASK_CONDITION_3(903,"在任意一场对战游戏中累计赚取资金达N万"),
//	TASK_CONDITION_4(904,"在任意一场对战游戏中累计购买N处房产"),
//	TASK_CONDITION_5(905,"在任意一场对战游戏中累计抢夺对手N处房产"),
//	TASK_CONDITION_6(906,"在任意一场对战游戏中累计购买N处商业街"),
//	TASK_CONDITION_7(907,"在任意一场对战游戏中将N处房产升级为终极建筑"),
//	TASK_CONDITION_8(908,"在任意一场对战游戏中乘坐N次出租车"),
//	TASK_CONDITION_9(909,"在任意一场对战游戏中资金总数最高达N万"),
//	TASK_CONDITION_10(910,"进行N场金币匹配对战游戏"),
//	TASK_CONDITION_11(911,"获得N场金币匹配对战游戏的胜利"),
//	TASK_CONDITION_12(912,"进行N场钻石匹配对战游戏"),
//	TASK_CONDITION_13(913,"获得N场钻石匹配对战游戏的胜利"),
//	TASK_CONDITION_14(914,"进行N场匹配对战游戏"),
//	TASK_CONDITION_15(915,"获得N场匹配对战游戏的胜利"),
//	TASK_CONDITION_16(916,"进行N场人机对战游戏"),
//	TASK_CONDITION_17(917,"获得N场人机对战游戏的胜利"),
//	TASK_CONDITION_18(918,"进行N场组队对战游戏"),
//	TASK_CONDITION_19(919,"获得N场组队对战游戏的胜利"),
//	TASK_CONDITION_20(920,"进行N场联赛对战游戏"),
//	TASK_CONDITION_21(921,"获得N场联赛对战游戏的胜利"),
//	TASK_CONDITION_22(922,"进行N场任意模式的对战游戏"),
//	TASK_CONDITION_23(923,"获得N场任意模式对战游戏的胜利"),
//	TASK_CONDITION_24(924,"在N场任意模式的对战游戏中使用幽冥系宠物"),
//	TASK_CONDITION_25(925,"使用幽冥系宠物获得N场对战游戏的胜利"),
//	TASK_CONDITION_26(926,"在N场任意模式的对战游戏中使用野兽系宠物"),
//	TASK_CONDITION_27(927,"使用野兽系宠物获得N场对战游戏的胜利"),
//	TASK_CONDITION_28(928,"在N场任意模式的对战游戏中使用飞行系宠物"),
//	TASK_CONDITION_29(929,"使用飞行系宠物获得N场对战游戏的胜利"),
//	TASK_CONDITION_30(930,"使用卡牌升级功能N次"),
//	TASK_CONDITION_31(931,"使用卡牌升阶功能N次"),
//	TASK_CONDITION_32(932,"获得N张任意品质的卡牌"),
//	TASK_CONDITION_33(933,"获得N张品质为D的卡牌"),
//	TASK_CONDITION_34(934,"获得N张品质为C的卡牌"),
//	TASK_CONDITION_35(935,"获得N张品质为B的卡牌"),
//	TASK_CONDITION_36(936,"获得N张品质为A的卡牌"),
//	TASK_CONDITION_37(937,"获得N张品质为S的卡牌"),
//	TASK_CONDITION_38(938,"获得N张品质为SS的卡牌"),
//	TASK_CONDITION_39(939,"获得N张品质为SSS的卡牌"),
//	TASK_CONDITION_48(948,"进行N次任意模式的抽奖"),
//	TASK_CONDITION_49(949,"进行N次钻石抽奖"),
//	TASK_CONDITION_50(950,"进行N次金币抽奖"),
//	TASK_CONDITION_51(951,"进行N次友情抽奖"),
//	TASK_CONDITION_52(952,"购买1个新的宠物"),
//	TASK_CONDITION_53(953,"获得1只幽冥系宠物"),
//	TASK_CONDITION_54(954,"获得1只飞行系宠物"),
//	TASK_CONDITION_55(955,"获得1只野兽系宠物"),
//	TASK_CONDITION_56(956,"拥有N只宠物"),
//	TASK_CONDITION_57(957,"玩家等级到达N级"),
//	TASK_CONDITION_58(958,"成功通过关卡：XXXX"),
//	TASK_CONDITION_59(959,"在N分钟以内结束一场任意模式的对战游戏并获得胜利"),
//	TASK_CONDITION_60(960,"添加N名新的好友"),
//	TASK_CONDITION_61(961,"与好友进行N场组队匹配对战游戏"),
//	TASK_CONDITION_62(962,"首次充值任意金额"),
//	TASK_CONDITION_63(963,"充值累计N元"),
//	TASK_CONDITION_64(964,"单次充值N元"),
//	TASK_CONDITION_65(965,"购买额外的卡牌背包"),
//	TASK_CONDITION_66(966,"在X地图中获得N场任意模式对战游戏的胜利"),
//	TASK_CONDITION_67(967,"在X地图中进行N场任意模式的对战游戏"),
//	TASK_CONDITION_68(968,"玩家在12:00~14:00期间上线"),
//	TASK_CONDITION_69(969,"玩家在18:00~20:00期间上线"),
//	TASK_CONDITION_70(970,"在联赛游戏中获得N积分"),
//	TASK_CONDITION_71(971,"加入任意俱乐部"),
//	
//	/** 邮件类型 */
//	EMAIL_TYPE_SYSTEM(501,"系统邮件"),
//	EMAIL_TYPE_PLAYER(502,"玩家邮件"),
//	EMAIL_TYPE_FRIEND(503,"添加好友邮件"),
//	EMAIL_TYPE_CLUB(504,"邀请加入俱乐部或申请加入俱乐部邮件"),
//	
//	/** 系統邮件接收者类型 */
//	EMAIL_SYSTEM_TYPE_APOINT(505,"成就點數"),
//	EMAIL_SYSTEM_TYPE_LEVEL(506,"等級"),
//	EMAIL_SYSTEM_TYPE_RANK(507,"排名"),
//	
//	/**宠物技能类型 */
//	PET_SKILL_GOLD(527,"天赋技能"),
//	PET_SKILL_COMMON_1(528,"技能1"),
//	PET_SKILL_COMMON_2(529,"技能2"),
//	PET_SKILL_SPECIAL(530,"大招，特殊技能"),
//	
//	/**俱乐部Tag */
//	CLUB_TAG_CASUAL(701,"休闲玩家"),
//	CLUB_TAG_SENIOR(702,"游戏高手"),
//	CLUB_TAG_GIRL(702,"MM公会"),
//	CLUB_TAG_FRIEND(702,"朋友圈"),
//	
//	/**成员在俱乐部中职位 */
//	CLUB_RANK_LEADER(703,"会长"),
//	CLUB_RANK_MANAGER(704,"管理员"),
//	CLUB_RANK_MEMBER(705,"会员"),
//	
//	/**成员在俱乐部中状态  */
//	CLUB_STATUS_APPLY(706,"申请"),
//	CLUB_STATUS_INVITED(707,"被邀请"),
//	CLUB_STATUS_APPLY_REFUSED(708,"申请拒绝"),
//	CLUB_STATUS_INVITED_REFUSED(709,"邀请拒绝"),
//	CLUB_STATUS_OK(710,"OK"),
//	
//	/**成员在俱乐部权限*/
//	CLUB_POWER_ADD(711, "添加成员权限"),
//	CLUB_POWER_EDIT(712, "编辑俱乐部公告权限"),
//	CLUB_POWER_DISMISS(713, "踢出成员权限"),
//	CLUB_POWER_SETJIONCONDITION(714, "设置加入条件权限"),
//	
//	/**俱乐部加入方式 */
//	CLUB_JOIN_ANYONE(715, "任意加入"),
//	CLUB_JOIN_INVITE(716, "邀请加入"),
//	CLUB_JOIN_UNABLE(717, "无法加入"),
//	
//	/**玩家状态*/
//	LEAGUE_STATUS_IDLE(801,"在线空闲"),
//	LEAGUE_STATUS_PLAYING(802,"游戏中"),
//	LEAGUE_STATUS_OFFLINE(803,"离线"),
//	/**赛季的类别*/
//	LEAGUE_SEASON_COMMON(804,"普通赛季"),
//	LEAGUE_SEASON_SPECIAL(805,"特殊赛季"),
//	/**联赛类型 */
//	LEAGUE_SINGLE(806,"单人联赛"),
//	LEAGUE_TEAM(807,"组对联赛"),
//	
//	/**神力值获取方式 */
//	GOD_GET_TYPE_ROUND_OVER(850,"回合结束增长"),
//	GOD_GET_TYPE_PAY(851,"支付金钱增长"),
//
//	/**VIP 特权名称 900-950*/
//	PHYSICAL_POWER(900,"体力额外购买次数");
//	
//	private final int code;
//    private final String comments;
//    
//    EnumFieldWztx(final int code, final String comments) {
//        this.code = code;
//        this.comments = comments;
//    }
//    
//    public static EnumFieldWztx fromCode(final int code) {
//        for (EnumFieldWztx s : EnumFieldWztx.values()) {
//            if (s.code == code) {
//                return s;
//            }
//        }
//        return null;
//    }
//
//    public static EnumFieldWztx fromName(final String name) {
//        for (EnumFieldWztx s : EnumFieldWztx.values()) {
//            if (s.name().equals(name)) {
//                return s;
//            }
//        }
//        return null;
//    }
//
//	/**
//	 * @return the code
//	 */
//	public int getCode() {
//		return code;
//	}
//
//	/**
//	 * @return the comments
//	 */
//	public String getComments() {
//		return toString();
//	}
//	
//    /**
//     * @return the reason phrase
//     */
//    public String toString() {
//        return comments;
//    }
//}
