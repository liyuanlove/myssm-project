package com.cn.winter.service.customer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cn.winter.mapper.CustomerMapper;
import com.cn.winter.pojo.Customer;
import com.cn.winter.service.customer.CustomerService;
import com.cn.winter.utils.StringUtil;


/*客户服务层*/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerMapper customerMapper;

	@Override
	public Integer addCustomer(Customer customer) {
		
		if(customer == null)
			return 0;
		try {
			customer.setCustomerId(StringUtil.uuid());//UUID
			customer.setTags("1");//状态为正常
			Integer count = customerMapper.insertSelective(customer);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	
		
	}

	@Override
	public List<Customer> findAllCustomer(String tags) {
		
		if(StringUtils.isEmpty(tags))
			tags = "1";
		
		try {
			List<Customer> list = customerMapper.findAllCustomerByStatus(tags);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Integer updateCustomer(Customer customer) {
		
		if(customer == null)
			return 0;
		
		try {
			
			Customer cu = customerMapper.selectByPrimaryKey(customer.getId());
			if(cu != null){
				
				Integer count = customerMapper.updateByPrimaryKeySelective(customer);
				return count;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
		
	}
	
	@Override
	public Customer findCustomerByCustomerId(String customerId) {
		
		if(StringUtils.isEmpty(customerId))
			return null;
		
		try {
			 Customer cu = customerMapper.findCustomerByCustomerId(customerId);
			 return cu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
