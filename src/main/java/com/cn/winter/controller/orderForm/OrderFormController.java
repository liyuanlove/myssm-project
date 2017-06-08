package com.cn.winter.controller.orderForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.winter.controller.BaseController;
import com.cn.winter.pojo.OrderForm;
import com.cn.winter.pojo.ProductForm;
import com.cn.winter.service.orderForm.OrderFormService;


/*订单控制层*/
@Controller("orderFormController")
public class OrderFormController extends BaseController{

	@Resource(name="orderFormService")
	private OrderFormService orderFormService; 
	
	
	/**
	 * 进入订单管理页面
	 * @return
	 */
	@RequestMapping("/to_order_form_page")
	public ModelAndView toOrderFormPage(){
		ModelAndView mv = new ModelAndView();
		//TODO 将所有的客户方入mv中，前台需要根据客户来筛选订单
		mv.addObject("formOut", null);
		mv.setViewName("");
		return mv;
	}
	
	/**
	 * 进入添加订单的页面
	 * @return
	 */
	@RequestMapping("to_add_orderf_page")
	public String toAddOrderFormPage(){
		return "";
	}
	
	
	/**
	 * 添加订单
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save_order_form_info")
	public Map<String,Object> addOrderFormInfo(OrderForm orderForm){
		Map<String, Object> map = new HashMap<>();
		Integer count = orderFormService.addOrderForm(orderForm);
		if(count != 0){
			
			map.put("data", 200);
		}else{
			map.put("data", 202);
			map.put("message", "添加失败");
		}
		return map;
	}
	
	/**
	 * 
	 * 通过订单开始时间和客户来筛选订单
	 * @param date
	 * @param CustomerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/select_orf_by_customer_time")
	public Map<String, Object> findOrderFormByCustomerAndTime(String customerId, String startTime, String endTime){
		Map<String, Object> map = new HashMap<>();
		
			List<OrderForm> formIn = orderFormService.findOrderFormByCustomerAndAddTime(customerId, startTime, endTime, "1");//查找正常的订单
			List<OrderForm> formOut = orderFormService.findOrderFormByCustomerAndAddTime(customerId, startTime, endTime, "2");//查找已经完成的订单
			map.put("formIn", formIn);
			map.put("formOut", formOut);
			return map;
		
	}
	
	/**
	 * 
	 * 进入修改订单基本信息页面
	 * @param orderFormId
	 * @return
	 */
	@RequestMapping("/to_edit_order_from_page")
	public ModelAndView toEditOrderFormPage(String orderFormId){
		ModelAndView mv = new ModelAndView();
		
		OrderForm of = orderFormService.findOrderFormByFormId(orderFormId);
		
		mv.addObject("data", of);
		mv.setViewName("");
		return mv;
		
	}
	
	/**
	 * 更新订单基本信息
	 * @param orderForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/edit_order_form_info")
	public Map<String, Object> updateOrderFormInfo(OrderForm orderForm){
		Map<String, Object> map = new HashMap<>();
		
		Integer count = orderFormService.updateOrder(orderForm);
		if(count != 0){
			map.put("count", 200);
			map.put("message", "修改成功");
		}else{
			map.put("count", 202);
			map.put("message", "修改失败");
		}
		
		return map;
	}
	
	/**
	 * 进入订单下的订单内产品列表
	 * @param orderFormId
	 * @return
	 */
	@RequestMapping("/to_product_form_page")
	public ModelAndView toProductFormPage(String orderFormId){
		ModelAndView mv = new ModelAndView();
		List<ProductForm> list = orderFormService.findProductFormByOrderFormId(orderFormId);
		mv.addObject("list", list);
		mv.setViewName("");
		return mv;
	}
	
	/**
	 * 将总成放入到产品订单中，并且放入总订单中
	 * @param assemblyId
	 * @param number
	 * @param price
	 * @param diameter
	 * @param customerProductId
	 * @param orderFormId
	 * @param oeNumber
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add_product_to_orderform")
	public Map<String, Object> addProductToOrderForm(String assemblyId, String number, String price, String diameter, String customerProductId, String orderFormId, String oeNumber){
		Map<String, Object> map = new HashMap<>();
		
		ProductForm product = new ProductForm();
		product.setAssemblyId(assemblyId);
		product.setCustomerProductId(customerProductId);
		product.setDiameter(diameter);
		product.setNumber(number);
		product.setOeNumber(oeNumber);
		product.setOrderFormId(orderFormId);
		product.setPrice(price);
		Integer totalp = Integer.parseInt(number) * Integer.parseInt(price);//计算总价格
		product.setTotalPrice(totalp.toString());
		
		Integer count = orderFormService.addProductForm(product);
		if(count != 0){
			map.put("count", 200);
			map.put("message", "添加成功");
		}else{
			map.put("count", 202);
			map.put("message", "添加失败");
		}
		
		return map;
	}
	
	/**
	 * 根据当前订单号查找该订单所属客户的相应产品的列表（客户编号对应内部编号）,将产品封装在ProductForm中即可
	 * @param orderFormId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/find_current_customer_product")
	public List<ProductForm> findCurrentOrderCustomerProduct(String orderFormId){
		
		List<ProductForm> list = orderFormService.findCurrentCustomerProductByOrderFormId(orderFormId);
		
		return list;
	}
	
	
	
}
