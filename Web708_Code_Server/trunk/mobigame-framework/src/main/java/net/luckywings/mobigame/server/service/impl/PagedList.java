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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.luckywings.mobigame.server.service.BaseVO;
import net.luckywings.mobigame.server.service.IPagedList;
import net.luckywings.mobigame.server.utils.MobiBeanUtils;


/**
 * 
 * ClassName: DefaultPagedList
 *
 * @description
 * @author nikm
 * @Date 2013-3-4
 *
 */
public class PagedList<T> implements IPagedList<T>, Serializable {
    private static final long serialVersionUID = 5920986017420227704L;

    private int totalSize;
    private int pageSize;
    private int pageIndex;
    private List<T> list;
    
    public PagedList() {

    }

    public PagedList(int totalSize, int pageIndex, int pageSize) {
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
    
    public PagedList(List<T> list, int totalSize, int pageIndex, int pageSize) {
        if(list != null) {
            this.list = list;
        }
        
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
    
    /**
     * Help to create paged list  
     * 
     * @param orgi
     * @param objClass
     * @return
     */
    public static <S, D extends BaseVO> PagedList<D> toPagedList(IPagedList<S> sources, Class<D> objClass) {
        PagedList<D> target = null;
        if (sources != null) {
        	target = new PagedList<D>(sources.getTotalSize(), sources.getPageIndex(), sources.getPageSize());
        	target.copyToBean(sources.getList(), objClass);
        } 
        return target;
    }
    
    /**
     * 
     * @param orgi
     */
    public <S> void copyToBean(List<S> orgi, Class<T> objClass) {
        try {
            for(S s : orgi) {
                T t = objClass.newInstance();
                MobiBeanUtils.copyProperties(s, t);
                add(t);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isEmpty() {
    	return (this.list == null || this.list.size() < 1);
    }
    
    public void add(T e) {
    	if (this.list == null) this.list = new ArrayList<T>();
    	this.list.add(e);
    }
    
	public void clear() {
		this.list = null;
	}
    
    @Override
	public int getTotalSize() {
		return totalSize;
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public int getPageIndex() {
		return pageIndex;
	}

	@Override
	public List<T> getList() {
		return list;
	}
}