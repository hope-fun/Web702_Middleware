/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * ClassName: AbstractSqlHandler
 * 
 * @description
 * @author wujianjun
 * @Date 9 26, 2014
 * 
 */
public abstract class AbstractSqlHandler  extends AbstractHandler {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Object>  addBySql(String strSql){
    	Query query = entityManager.createNativeQuery(strSql);
    	query.executeUpdate();
    	List<Object> objectList = new ArrayList<Object>();
    	objectList.add(Boolean.TRUE);
		return objectList;
    }
    public List<Object>  deleteBySql(String strSql){
    	Query query = entityManager.createNativeQuery(strSql);
    	query.executeUpdate();
    	List<Object> objectList = new ArrayList<Object>();
    	objectList.add(Boolean.TRUE);
		return objectList;
    }
    public List<Object>  updateBySql(String strSql){
    	Query query = entityManager.createNativeQuery(strSql);
    	query.executeUpdate();
    	List<Object> objectList = new ArrayList<Object>();
    	objectList.add(Boolean.TRUE);
		return objectList;
    }
    public List<Object>  queryBySql(String strSql){
    	Query query = entityManager.createNativeQuery(strSql);
    	List<Object> objectList = query.getResultList();
		return objectList;
    }
}
