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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.luckywings.mobigame.server.model.AbstractModel;
import net.luckywings.mobigame.server.model.enumtype.EnumFieldPjz;
import net.luckywings.mobigame.server.persistence.service.ISimpleDAO;
import net.luckywings.mobigame.server.service.IPagedList;
import net.luckywings.mobigame.server.service.impl.PagedList;
import net.luckywings.mobigame.server.utils.CommonUtils;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


/**
 * ClassName: AbstractSimpleDAO
 * 
 * @description
 * @author nikm
 * @Date Feb 26, 2013
 * 
 * @param <T>
 */
@Transactional
// (propagation = Propagation.MANDATORY)
public abstract class AbstractSimpleDAO<T extends AbstractModel> implements ISimpleDAO<T> {

    protected final static String MODEL_PACKAGE_NAME = "net.luckywings.mobigame.server.data.model";

    protected final static String SERVICE_CLASS_SUFFIX = "DAO";

    private final Logger log = Logger.getLogger(AbstractSimpleDAO.class);
    

    public AbstractSimpleDAO() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public T findOne(final String id) {
        try {
            return this.entityManager.find(getDomainClass(), id);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException:" + getDomainClassString(), e);
            throw new PersistenceException();
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public T findOne(String playerId, final String id) {
    	Query query = this.entityManager.createQuery("from " + getDomainClassString() + " where id=:id and playerId=:playerId");
        query.setParameter("id",id);
        query.setParameter("playerId",playerId);
        T res = null;
        List<T> results = query.getResultList();
        if(!results.isEmpty()){
            res = results.get(0);
        }
        return res;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return this.entityManager.createQuery("from " + getDomainClassString()).getResultList();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findAll(String playerId) {
         Query query = this.entityManager.createQuery("from " + getDomainClassString() + " where playerId=:playerId");
         query.setParameter("playerId",playerId);
         return query.getResultList();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findAllWithPageParam(int index,int size) {
         Query query = this.entityManager.createQuery("from " + getDomainClassString());
         query.setMaxResults(size);
 		// from index 0
 		if (index == 0) {
 			query.setFirstResult(index);
 		}
 		else {
 			query.setFirstResult(index-1);
 		}
         return query.getResultList();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findByType(String playerId,EnumFieldPjz type) {
         Query query = this.entityManager.createQuery("from " + getDomainClassString() + " where type=:type and playerId=:playerId");
         query.setParameter("type",type);
         query.setParameter("playerId",playerId);
         return query.getResultList();
    }
    
    
    
    @Transactional(readOnly=true)
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <VO> List<VO> getResultList(Query query, Class<VO> cls) {
        List<VO> rel = null;
        List<Object> objLst = query.getResultList();
        rel = new ArrayList<VO>();
        try {
            for (Object obj : objLst) {
                if (obj instanceof Object[]) {
                    Class[] parameterTypes = { Object[].class };
                    Object[] objs = { (Object[]) obj };
                    java.lang.reflect.Constructor constructor = cls.getConstructor(parameterTypes);
                    VO t = (VO) constructor.newInstance(objs);
                    rel.add(t);
                }
            }
        } catch (Exception e) {
            log.error(e, e);
        }

        return rel;
    }
    
    @Transactional(readOnly=true)
    protected <T> IPagedList<T> getPagedList(TypedQuery<Long> totalQuery, TypedQuery<T> query, int index, int size) {
        long total = CommonUtils.toLong(totalQuery.getSingleResult());
        return getPagedList(query, (int)total, index, size);
    }
    
    @Transactional(readOnly=true)
    protected <T> IPagedList<T> getPagedList(Query totalQuery, Query query, int index, int size) {
    	long total = CommonUtils.toLong(totalQuery.getSingleResult());
        return getPagedList(query, (int)total, index, size);
    }
    
    @Transactional(readOnly=true)
    protected <T> IPagedList<T> getPagedList(Query query, int total, int index, int size) {
        IPagedList<T> rel = null;

        int firstResult = index * size;

        if (total == 0) {
            rel = new PagedList<T>(null, 0, 0, size);
        } else {
            // When first result is more than current total of records, reset to
            // show first page result
            if (firstResult >= total) {
                index = 0;
                firstResult = index * size;
            }
            query.setFirstResult(firstResult);
            query.setMaxResults(size);

            rel = new PagedList<T>(query.getResultList(), total, index, size);
        }
        return rel;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(final T entity) {
    	Date curr = new Date();
    	entity.setUpdateTime(curr);
    	entity.setCreateTime(curr);
        this.entityManager.persist(entity);
        this.entityManager.flush();
        this.entityManager.refresh(entity);
    }

    @Override
    public void update(final T entity) { 
    	entity.setUpdateTime(new Date());
        this.entityManager.merge(entity);
    }

    @Override
    public void delete(final T entity) {
    	entity.setDeleteStatus(AbstractModel.Status.DELETED);
        this.save(entity);
    }

    @Override
    public void delete(final String entityId) {
        final T entity = this.findOne(entityId);
        if (entity != null) {
        	this.delete(entity);
        }
    }

    @Override
    public void deletePhysically(T entity) {
    	this.entityManager.remove(entity);
    }
    
    @Override
    public void deletePhysically(final String entityId) {
    	final T entity = this.findOne(entityId);
    	if (entity != null) {
    		this.entityManager.remove(entity);
    	}
    }

    @Override
    public void setDeleteStatus(final String entityId, final AbstractModel.Status status) {
        final T entity = this.findOne(entityId);
        entity.setDeleteStatus(status);
        this.save(entity);
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getDomainClass() throws ClassNotFoundException {
        return (Class<T>) Class.forName(getDomainClassString());
    }

    protected String getDomainClassString() {
        String className = this.getClass().getSimpleName();
        return MODEL_PACKAGE_NAME + "." + className.substring(0, className.indexOf(SERVICE_CLASS_SUFFIX));
    }

    /**
     * 
     * @param key
     * @param sql
     * @param param
     * @return
     */
    protected TypeCondition createCondition(String key, String sql, Object param) {
        return new TypeCondition(key, sql, param);
    }

    /**
     * 
     * @param query
     * @param cons
     * @return
     */
    protected Query addParameters(Query query, List<TypeCondition> cons) {
        for (TypeCondition con : cons) {
            if (StringUtils.hasLength(con.getKey())) {
                query = query.setParameter(con.getKey(), con.getParam());
            }
        }
        return query;
    }

    /**
     * 
     * @param cons
     * @param delim
     * @return
     */
    protected String joinConditions(List<TypeCondition> cons, String delim) {
        if (cons != null && cons.size() > 0) {
            List<String> sqlLst = new ArrayList<String>();
            for (TypeCondition con : cons) {
                sqlLst.add(con.getSql());
            }
            return StringUtils.collectionToDelimitedString(sqlLst, delim);
        }
        return null;
    }

    /**
     * 
     * ClassName: TypeCondition
     * 
     * @description
     * @author nikm
     * @Date 2013-3-13
     * 
     */
    protected class TypeCondition {
        private String key;
        private String sql;
        private Object param;

        public TypeCondition(String key, String sql, Object param) {
            this.key = key;
            this.sql = sql;
            this.param = param;
        }

        /**
         * @return the key
         */
        public String getKey() {
            return key;
        }

        /**
         * @return the sql
         */
        public String getSql() {
            return sql;
        }

        /**
         * @return the param
         */
        public Object getParam() {
            return param;
        }
    }
}