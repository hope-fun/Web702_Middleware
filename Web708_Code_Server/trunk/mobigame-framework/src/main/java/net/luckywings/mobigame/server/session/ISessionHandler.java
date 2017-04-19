/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.session;

import java.util.List;

/**
 * TODO
 * 
 * @ClassName: ISessionHandler
 * @author nikm
 * @date 2013-7-23
 *
 */
public interface ISessionHandler {
	public Object get(String sid);
	
	public void set(String sid, Object session);
	
	public void refresh(String sid);
	
	public void delete(String sid);
	
	public List<String> getStats(String status);
}
