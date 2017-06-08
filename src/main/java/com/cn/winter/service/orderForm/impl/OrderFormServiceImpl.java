package com.cn.winter.service.orderForm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cn.winter.mapper.AssemblyMapper;
import com.cn.winter.mapper.OrderFormMapper;
import com.cn.winter.mapper.ProductFormMapper;
import com.cn.winter.mapper.ProductNumContrastMapper;
import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.OrderForm;
import com.cn.winter.pojo.ProductForm;
import com.cn.winter.pojo.ProductNumContrast;
import com.cn.winter.service.orderForm.OrderFormService;

@Service("orderFormService")
public class OrderFormServiceImpl implements OrderFormService {
	
	@Resource
	private OrderFormMapper orderFormMapper;
	
	@Resource
	private ProductFormMapper productFormMapper;
	
	@Resource
	private AssemblyMapper assemblyMapper;
	
	@Resource
	private ProductNumContrastMapper productNumContrastMapper;

	@Override
	public Integer addOrderForm(OrderForm orderForm) {
		
		if(orderForm == null)
			return 0;
		
		try {
			
			orderForm.setOrderStatus("1");
			Integer count = orderFormMapper.insertSelective(orderForm);
			return count;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return 0;
		
	}

	@Override
	public List<OrderForm> findAllOrderFormByStatus(String status) {
		
		if(StringUtils.isEmpty(status))
			status = "1";
		try {
			List<OrderForm> list = orderFormMapper.findAllOrderFormByStatus(status);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public OrderForm findOrderFormByFormId(String formId) {
		
		if(StringUtils.isEmpty(formId))
			return null;
		try {
			OrderForm form = orderFormMapper.findOrderFormByOrderFormId(formId);
			return form;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer updateOrder(OrderForm orderForm) {
		
		if(orderForm == null)
			return 0;
		
		try {
			Integer count = orderFormMapper.updateByPrimaryKeySelective(orderForm);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<OrderForm> findOrderFormByCustomerAndAddTime(String customerId, String startTime, String endTime, String status) {
		
		try {
			List<OrderForm> list = orderFormMapper.findOrderFormByCustomerAndTime(customerId, startTime, endTime, status);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public List<ProductForm> findProductFormByOrderFormId(String orderFormId) {
		
		if(orderFormId == null)
			return null;
		
		try {
			List<ProductForm> list = productFormMapper.findProductFormByOrderFormId(orderFormId);
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Integer addProductForm(ProductForm productForm) {
		
		if(productForm == null)
			return 0;
		
		try {
			Integer count = productFormMapper.insertSelective(productForm);
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public List<ProductForm> findCurrentCustomerProductByOrderFormId(String orderFormId) {
		
		List<ProductForm> list = new ArrayList<>();
		
		if(orderFormId == null)
			return list;
		
		//首先查找当前订单的客户对象
		try {
			OrderForm of =orderFormMapper.findOrderFormByOrderFormId(orderFormId);
			if(of != null){
				
				String customerId = of.getCustomerId();
				//根据客户id查找他的产品
				List<ProductNumContrast> proList = productNumContrastMapper.findCustomerProductByCustomerId(customerId);
				for(ProductNumContrast pro : proList){
					
					ProductForm proForm = new ProductForm();
					//根据一个编号去查找总成
					Assembly ass = assemblyMapper.findAssemblyById(pro.getAssemblyId());
					
					proForm.setAssemblyId(ass.getPartId());
					proForm.setCustomerProductId(pro.getCustomerProId());
					proForm.setDiameter(ass.getDiameter());
					proForm.setDescription(pro.getDescription());
					proForm.setNumber(ass.getNumber().toString());
					proForm.setOeNumber(ass.getOeNumber());
					list.add(proForm);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
