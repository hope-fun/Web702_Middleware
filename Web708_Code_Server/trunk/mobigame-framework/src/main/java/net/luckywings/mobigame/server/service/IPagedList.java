/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.service;

import java.util.List;


/**
 * ClassName: IPagedList
 * 
 * @param <T> the type of list result
 * 
 * @description
 * @author nikm
 * @Date Mar 1, 2013
 * 
 */
public interface IPagedList<T> {

    /**
     * Total page size
     * 
     * @return the totalSize
     */
    int getTotalSize();

    /**
     * The size of each page
     * 
     * @return the pageSize
     */
    int getPageSize();

    /**
     * The page index
     * 
     * @return the page index
     */
    int getPageIndex();
    
    /***
     * The object list
     * 
     * @return
     */
    List<T> getList();
    
    /**
     * Check if list is empty
     * 
     * @return
     */
    boolean isEmpty();
}
