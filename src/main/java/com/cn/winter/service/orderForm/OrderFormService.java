package com.cn.winter.service.orderForm;

import java.util.List;

import com.cn.winter.pojo.OrderForm;
import com.cn.winter.pojo.ProductForm;

public interface OrderFormService {
	
	
	/**
	 * 添加订单
	 * @param orderForm
	 * @return
	 */
	Integer addOrderForm(OrderForm orderForm);
	
	
	/**
	 * 根据订单状态查找订单
	 * @param status
	 * @return
	 */
	List<OrderForm> findAllOrderFormByStatus(String status);
	
	
	/**
	 * 根据订单编号查找订单
	 * @param fromId
	 * @return
	 */
	OrderForm findOrderFormByFormId(String fromId);
	
	
	/**
	 * 
	 * 更新订单信息
	 * @param orderForm
	 * @return
	 */
	Integer updateOrder(OrderForm orderForm);
	
	
	/**
	 * 根据客户id和订单启动时间查找订单
	 * @param customer
	 * @param date
	 * @return
	 */
	List<OrderForm> findOrderFormByCustomerAndAddTime(String customerId, String startTime, String endTime, String status);
	
	/**
	 * 根据上级订单编号查找订单内的产品
	 * @param orderFormId
	 * @return
	 */
	List<ProductForm> findProductFormByOrderFormId(String orderFormId);
	
	/**
	 * 添加订单的产品
	 * @param productForm
	 * @return
	 */
	Integer addProductForm(ProductForm productForm);
	
	
	/**
	 * 
	 * 根据当前订单号查找当前的用户所有的产品
	 * @param orderFormId
	 * @return
	 */
	List<ProductForm> findCurrentCustomerProductByOrderFormId(String orderFormId);

}
