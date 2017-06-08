package com.cn.winter.service.customer;

import java.util.List;

import com.cn.winter.pojo.Customer;

public interface CustomerService {

	
	/**
	 * 添加客户
	 * @param customer
	 * @return
	 */
	Integer addCustomer(Customer customer);
	
	
	/**
	 * 查找所有的客户
	 * @param tags 客户状态
	 * @return
	 */
	List<Customer> findAllCustomer(String tags);
	
	
	/**
	 * 更新客户信息
	 * @param customer
	 * @return
	 */
	Integer updateCustomer(Customer customer);
	
	
	/**
	 * 通过客户的id查找客户
	 * @param customerId
	 * @return
	 */
	Customer findCustomerByCustomerId(String customerId);
	
	
}
