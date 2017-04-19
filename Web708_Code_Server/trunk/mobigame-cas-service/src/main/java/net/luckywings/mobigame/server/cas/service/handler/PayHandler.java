/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 * 
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 * 
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.cas.service.handler;

import net.luckywings.mobigame.server.cas.service.handler.interfaces.IPayHandler;
import net.luckywings.mobigame.server.cas.service.vo.PayAuthVO;
import net.luckywings.mobigame.server.cas.service.vo.PayOrderVO;
import net.luckywings.mobigame.server.data.model.PayAuth;
import net.luckywings.mobigame.server.data.model.PayOrder;
import net.luckywings.mobigame.server.data.persistence.service.IPayAuthDAO;
import net.luckywings.mobigame.server.data.persistence.service.IPayOrderDAO;
import net.luckywings.mobigame.server.service.impl.AbstractHandler;
import net.luckywings.mobigame.server.service.vo.BaseSearchVO;
import net.luckywings.mobigame.server.utils.MobiBeanUtils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayHandler extends AbstractHandler implements IPayHandler {

    private static final Logger logger = LoggerFactory.getLogger(PayHandler.class);

    @Autowired
    private IPayAuthDAO payAuthDAO;

    @Autowired
    private IPayOrderDAO payOrderDAO;

    @Override
    public PayAuthVO findPayAuth(PayAuthVO req) {// 查找交易序列码
        PayAuthVO vo = new PayAuthVO();
        PayAuth entity = payAuthDAO.findPayAuth(req.getGameId(), req.getChannelId());
        if (entity != null) {
            MobiBeanUtils.copyProperties(entity, vo);
        }
        return vo;
    }

    @Override
    public PayOrderVO createOrder(PayOrderVO req) {// 创建表
        PayOrder order = new PayOrder();
        MobiBeanUtils.copyProperties(req, order, new String[] {"id"});
        order.setOpenOrderId(order.getId().substring(0,30));// 默认OpenOrderId为30位短ID, 如果第三方有他们的ID会覆盖次字段值
        payOrderDAO.save(order);
        BeanUtils.copyProperties(order, req);
        return req;
    }
    

    @Override
    public PayOrderVO getPayOrderById(PayOrderVO request) {
        PayOrderVO vo = null;
        if (request != null) {
            PayOrder entity = payOrderDAO.findOne(request.getId());
            if (entity != null) {
                vo = new PayOrderVO();
                MobiBeanUtils.copyProperties(entity, vo);
            }
        }
        return vo;
    }

    @Override
    public PayOrderVO getPayOrderByOpenId(PayOrderVO request) {
        PayOrderVO vo = null;
        if (request != null) {
            PayOrder entity = payOrderDAO.getPayOrderByOpenId(request.getId());
            if (entity != null) {
                vo = new PayOrderVO();
                MobiBeanUtils.copyProperties(entity, vo);
            }
        }
        return vo;
    }
    
    // 根据openorderid来查找数据
    @Override
    public PayOrderVO getPayOrderByOpenOrderId(PayOrderVO request) {
       logger.info("2222222"+request.getOpenOrderId());
    	PayOrderVO vo = null;
        if (request != null) {
            PayOrder entity = payOrderDAO.getPayOrderByOpenOrderId(request.getOpenOrderId());
            if (entity != null) {
                vo = new PayOrderVO();
                MobiBeanUtils.copyProperties(entity, vo);
            }
        }
        return vo;
    }

    
    @Override
    public List<PayOrderVO> getPayOrderByStatus(PayOrderVO request) {
        List<PayOrderVO> voList = null;
        List<PayOrder> entityList = payOrderDAO.getPayOrderByStatus(request.getRoleId(), request.getStatues());
        if (entityList != null) {
            voList = new ArrayList<PayOrderVO>();
            for (PayOrder entity : entityList) {
                PayOrderVO vo = new PayOrderVO();
                MobiBeanUtils.copyProperties(entity, vo);
                voList.add(vo);
            }
        }
        return voList;
    }

    @Override
    public PayOrderVO updatePayOrder(PayOrderVO vo) {// 更新表
        if (vo != null) {
            PayOrder entity = payOrderDAO.findOne(vo.getId());
            if (entity != null) {
                MobiBeanUtils.copyProperties(vo, entity);
                payOrderDAO.update(entity);
                return vo;
            }
        }
        return null;
    }

}
