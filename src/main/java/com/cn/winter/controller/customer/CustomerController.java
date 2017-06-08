package com.cn.winter.controller.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.winter.controller.BaseController;
import com.cn.winter.pojo.Customer;
import com.cn.winter.service.customer.CustomerService;

/*客户管理层*/
@Controller
public class CustomerController extends BaseController{

	@Resource(name="customerService")
	private CustomerService customerService;
	
	/**
	 * 跳转到添加用户页面
	 * @return
	 */
	@RequestMapping("/to_add_cu_page")
	public String toAddCustomerPage(){
		return "";
	}
	
	/**
	 * 添加客户
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add_customer_info")
	
	public Map<String, Object> addCustomer(Customer customer){
		Map<String, Object> map = new HashMap<>();
		Integer count = customerService.addCustomer(customer);
		if(count != 0){
			map.put("data", 200);
		}else{
			map.put("data", 202);
			map.put("message", "添加出错，请重试");
		}
		
		return map;
	}
	
	/**
	 * 进入客户信息列表
	 * @return
	 */
	@RequestMapping("/get_customer_info")
	public ModelAndView toCustomerInfoPage(){
		ModelAndView mv = new ModelAndView();
		List<Customer> list = customerService.findAllCustomer("1");//"1"表示正常的客户
		mv.addObject("list", list);
		mv.setViewName("");
		return mv;
	}
	
	/**
	 * 进入客户编辑页
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/to_edit_cu_page")
	public ModelAndView toEditCustomerPage(String customerId){
		
		ModelAndView mv = new ModelAndView();
		
		Customer cu = customerService.findCustomerByCustomerId(customerId);
		
		mv.addObject("data", cu);
		mv.setViewName("");
		return mv;
	}
	
	/**
	 * 保存编辑后的客户信息
	 * @param customer
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/edit_customer_info")
	public Map<String, Object> editCustomerInfo(Customer customer){
		Map<String, Object> map = new HashMap<>();
		
		Integer count = customerService.updateCustomer(customer);
		if(count != 0){
			map.put("count", 200);
		}else{
			map.put("count", 202);
			map.put("mess", "保存出错 请重试");
		}
		return map;
	}
	
	/**
	 * 删除客户
	 * @param customerId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete_customer_info")
	public Map<String, Object> deleteCustomer(String customerId){
		
		Map<String, Object> map = new HashMap<>();
		
		Customer customer = customerService.findCustomerByCustomerId(customerId);
		customer.setTags("0");
		Integer count = customerService.updateCustomer(customer);
		if(count != 0){
			map.put("flag", 200);
			map.put("message", "删除成功");
		}else{
			map.put("flag", 202);
			map.put("message", "删除失败,请重试");
		}
		
		return map;
		
	}
	
	
	
}
