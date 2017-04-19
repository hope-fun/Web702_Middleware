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

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.luckywings.mobigame.server.service.BaseVO;
import net.luckywings.mobigame.server.service.IPaged;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;


/**
 * ClassName: AbstractPagedVO
 * 
 * @description
 * 
 */
public class AbstractPagedVO extends BaseVO implements IPaged {
    private static final long serialVersionUID = -2922572560219959891L;

    private Integer pageSize;

    private Integer pageIndex;

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageIndex
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageIndex
     *            the pageIndex to set
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
    

    /**
     * TODO: When the sub-class wants to ignore some fields as search fields,
     * just declare them by override this method.
     *  
     * @return
     */
    protected List<String> getIgnoreSearchFields() {
        return null;
    }
    
    /**
     * 
     * @return
     */
    private List<String> getAllIgnoreSearchFields() {
        ArrayList<String> allIgnoreSearchFields = new ArrayList<String>();
        allIgnoreSearchFields.addAll(Arrays.asList("pageSize", "pageIndex"));
        List<String> ignoreSearchFields = this.getIgnoreSearchFields();
        if(ignoreSearchFields != null) {
            allIgnoreSearchFields.addAll(ignoreSearchFields);
        }
        return allIgnoreSearchFields;
    }
    
    /**
     * 
     * @return
     */
    public String getQueryFields() {
        List<String> allIgnoreSearchFields = this.getAllIgnoreSearchFields();
        List<String> queryFields = new ArrayList<String>();
        PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(this.getClass());
        for(PropertyDescriptor descriptor : descriptors) {
            if (descriptor != null && descriptor.getWriteMethod() != null && descriptor.getReadMethod() != null && !allIgnoreSearchFields.contains(descriptor.getName())) {
                queryFields.add(descriptor.getName());
            }
        }
        return StringUtils.collectionToDelimitedString(queryFields, ",");
    }
}
