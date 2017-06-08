package com.cn.winter.mapper;

import java.util.List;

import com.cn.winter.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey (Integer id)throws Exception;

    int insert(Customer record)throws Exception;

    int insertSelective(Customer record)throws Exception;

    Customer selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(Customer record)throws Exception;

    int updateByPrimaryKey(Customer record)throws Exception;
    
    /**
     * 通过状态查找所有的客户
     * @param tags
     * @return
     * @throws Exception
     */
    List<Customer> findAllCustomerByStatus(String tags)throws Exception;
    
    
    /**
     * 通过客户的customerId查找客户
     * @param customerId
     * @return
     * @throws Exception
     */
    Customer findCustomerByCustomerId(String customerId) throws Exception;
}