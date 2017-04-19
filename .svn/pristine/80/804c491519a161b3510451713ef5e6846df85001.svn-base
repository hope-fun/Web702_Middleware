/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.service.vo;

import java.util.List;

/**
 * @author nikm
 * @param <T>
 * @date 2013-8-13
 */
public class BaseSearchListVO<T extends BaseSearchVO> extends BaseSearchVO {

	private static final long serialVersionUID = 5489023588451456807L;

	private List<T> list;

	public BaseSearchListVO() {

	}

	public BaseSearchListVO(String pid, List<T> list) {
		this.setPlayerId(pid);
		this.setList(list);
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
