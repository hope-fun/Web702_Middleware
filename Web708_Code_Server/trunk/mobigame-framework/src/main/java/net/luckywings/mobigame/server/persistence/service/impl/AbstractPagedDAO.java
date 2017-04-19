/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.persistence.service.impl;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.luckywings.mobigame.server.model.AbstractModel;
import net.luckywings.mobigame.server.service.IPaged;
import net.luckywings.mobigame.server.service.IPagedList;
import net.luckywings.mobigame.server.service.impl.PagedList;
import net.luckywings.mobigame.server.utils.CommonUtils;
import net.luckywings.mobigame.server.utils.SysProperties;


/**
 * 
 * ClassName: AbstractPagedDAO
 * 
 * @description
 * 
 */
public class AbstractPagedDAO<T extends AbstractModel> extends AbstractSimpleDAO<T> {

    /**
     * Get the result list.
     * 
     * @param totalQuery
     *            the query of search total size
     * @param query
     *            the query of search list data
     * @param searchData
     *            the pagination condition
     * @return
     */
    protected <K> IPagedList<K> getPagedList(TypedQuery<Long> totalQuery, TypedQuery<K> query, IPaged searchData) {
        IPagedList<K> rel = null;

        Long total = CommonUtils.toLong(totalQuery.getSingleResult());

        int index = searchData.getPageIndex() == null ? 0 : searchData.getPageIndex();
        int size = searchData.getPageSize() == null ? SysProperties.getInstance().getIntProperty("default.data.paged.size", 5) : searchData
                .getPageSize();

        int firstResult = index * size;

        if (total == 0) {
            rel = new PagedList<K>(null, 0, 0, size);
        } else {
            // When first result is more than current total of records, reset to
            // show first page result
            if (firstResult >= total) {
                index = 0;
                firstResult = index * size;
            }
            query.setFirstResult(firstResult);
            query.setMaxResults(size);

            rel = new PagedList<K>(query.getResultList(), total.intValue(), index, size);
        }
        return rel;
    }
    
    /**
     * @author qin_yan
     * Get the result list.
     * 
     * @param totalQuery
     *            the query of search total size
     * @param query
     *            the query of search list data
     * @param searchData
     *            the pagination condition
     * @return
     */
    protected <K> IPagedList<K> getPagedList(Query totalQuery, Query query, IPaged searchData) {
        IPagedList<K> rel = null;

        Long total = CommonUtils.toLong(totalQuery.getSingleResult());

        int index = searchData.getPageIndex() == null ? 0 : searchData.getPageIndex();
        int size = searchData.getPageSize() == null ? SysProperties.getInstance().getIntProperty("default.data.paged.size", 5) : searchData
                .getPageSize();

        int firstResult = index * size;

        if (total == 0) {
            rel = new PagedList<K>(null, 0, 0, size);
        } else {
            // When first result is more than current total of records, reset to
            // show first page result
            if (firstResult >= total) {
                index = 0;
                firstResult = index * size;
            }
            query.setFirstResult(firstResult);
            query.setMaxResults(size);

            rel = new PagedList<K>(query.getResultList(), total.intValue(), index, size);
        }
        return rel;
    }
}
