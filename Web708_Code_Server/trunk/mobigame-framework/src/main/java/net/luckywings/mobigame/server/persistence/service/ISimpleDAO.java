/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.persistence.service;

import java.util.List;

import net.luckywings.mobigame.server.model.AbstractModel;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldPjz;


/**
 * 
 * ClassName: ISimpleDAO
 * 
 * @description
 * @author nikm
 * @Date 2013-3-7
 * 
 */
public interface ISimpleDAO<T extends AbstractModel> {

    /**
     * 
     * @param id
     * @return Entity the entity
     */
    T findOne(final String id);
    
    T findOne(String playerId, final String id);

    /**
     * 
     * @return List the entity list
     */
    List<T> findAll();
    
    List<T> findAll(String roleId);
    
    /**
     * 带分页参数
     * @param index pageIndex
     * @param size pageSize
     * @return List
     */
    List<T> findAllWithPageParam(int index,int size);
    
    
    
    List<T> findByType(String playerId,EnumFieldPjz type);

    /**
     * 
     * @param entity
     */
    void save(final T entity);

    /**
     * 
     * @param entity
     */
    void update(final T entity);

    /**
     * 
     * @param entity
     */
    void delete(final T entity);
    
    /**
     * 
     * @param entityId
     */
    void delete(final String entityId);

    /**
     * 
     * @param entity
     */
    void deletePhysically(T entity);
    
    /**
     * 
     * @param entityId
     */
    void deletePhysically(final String entityId);
    
    /**
     * 
     * @param entityId
     * @param status
     */
    void setDeleteStatus(final String entityId, final AbstractModel.Status status);
}
