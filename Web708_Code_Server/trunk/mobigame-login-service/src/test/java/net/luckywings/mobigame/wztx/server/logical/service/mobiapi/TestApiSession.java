/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.wztx.server.logical.service.mobiapi;

import net.luckywings.mobigame.server.logical.service.mobiapi.BaseModule;

import net.luckywings.mobigame.server.session.ApiSession;

/**
 * TODO
 * 
 * @ClassName: TestApiSession
 * @author nikm
 * @date 2013-7-24
 *
 */
public class TestApiSession extends BaseModule {

	public static void main(String[] args) {
		ApiSession session = new ApiSession();
		String sid = session.getSessionId();
		//session.setUserName("nikm-test-session-001");
		
		//System.out.println("First session id=" + sid + ", userName="+session.getUserName());
		
		TestApiSession testModule = new TestApiSession();
		
		for (int i=0; i<1000000; i++) {
			testModule.setSessionId(session.getSessionId());
			testModule.updateSession(session);
			
			if ((i%1000) == 0) System.out.println((i/100)+"00 session store");
			
			testModule.setSessionId(sid);
			if (testModule.getSession() == null) {
				System.out.println("First session not exists, i="+i);
				break;
			}
			
			session = new ApiSession();
		}
		
		testModule.setSessionId(sid);
		session = testModule.getSession();
		//System.out.println("First session exists, id=" + sid + ", userName="+session.getUserName());
	}
}
