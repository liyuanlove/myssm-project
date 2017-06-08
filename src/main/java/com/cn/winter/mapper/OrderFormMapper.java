package com.cn.winter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.winter.pojo.OrderForm;

public interface OrderFormMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(OrderForm record)throws Exception;

    int insertSelective(OrderForm record)throws Exception;

    OrderForm selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(OrderForm record)throws Exception;

    int updateByPrimaryKey(OrderForm record)throws Exception;
    
    
    /**
     * 通过订单状态查找相关订单
     * @param status
     * @return
     * @throws Exception
     */
    List<OrderForm> findAllOrderFormByStatus(String status) throws Exception;
    
    
    /**
     * 
     * 通过订单编号查找订单
     * @param formId
     * @return
     * @throws Exception
     */
    OrderForm findOrderFormByOrderFormId(String formId) throws Exception;
    
    
    /**
     * 通过客户id或者时间去查找相关的订单
     * @param customerId
     * @param startTime
     * @param endTime
     * @return
     */
    List<OrderForm> findOrderFormByCustomerAndTime(@Param("customerId") String customerId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("orderStatus") String orderStatus) throws Exception;
}