/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * ClassName: IndexController
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
@Controller
public class IndexController {

	@RequestMapping({ "/index", "/index.html", "/index.jsp" })
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED)
	public ModelAndView getDashBoard(HttpServletResponse response) {
		java.util.Map<String, Object> cmds = new java.util.HashMap<String, Object>();
		return new ModelAndView("/index", cmds);
	}
}
