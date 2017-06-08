package com.cn.winter.controller.part;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cn.winter.controller.BaseController;
import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.SpareParts;
import com.cn.winter.pojo.User;
import com.cn.winter.service.part.PartsService;
import com.cn.winter.service.part.impl.dto.PartDTO;
import com.cn.winter.utils.DateUtil;

/**
 * 零件控制器
 * @author Administrator
 *
 */
@Controller("partController")
public class PartController extends BaseController{

	@Resource
	private PartsService partService;
	
	@RequestMapping("/to_ass_add_page")
	public ModelAndView toPartAddPage(){
		User user = (User) this.request.getAttribute("userInfo");
		ModelAndView mv = new ModelAndView();
		mv.addObject("userInfo", user);
		mv.addObject("currentTime", DateUtil.format(new Date()));
		mv.setViewName("add_assembly");
		return mv;
	}
	
	/**
	 * ajax异步添加总称和零配件
	 * @param parts
	 * @param ass
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add_ass_and_parts")
	public Map<String, Object> addAssAndParts(SpareParts part, String partId){
		
		Map<String, Object> map = new HashMap<>();
		Integer count = partService.addAssmeblyAndPart(partId, part, null,"save");
		
		if(count != 0){
			map.put("data", 200);
			return map;
		}else{
			map.put("data", 202);
			return map;
		}
	}
	
	/**
	 * 
	 * 添加总成
	 * @param ass
	 * @param pic  总成的照片
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add_one_assembly")
	public ModelAndView addOneAssembly(Assembly ass, @RequestParam("pic")MultipartFile pic){
		User u = (User) this.request.getSession().getAttribute("userInfo");
		try {
			ass.setUserId(u.getUserId().toString());
			Integer count = partService.addAssembly(ass, pic);
			if(count != 0 && count != null){
				ModelAndView mv = new ModelAndView();
				mv.setViewName("redirect:/get_bm_assembly");
				return mv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 进入总成BM的页面
	 * @return
	 */
	@RequestMapping("get_bm_assembly")
	public String getBmAssembly(){
		
		return "bm_table_assemblys";
	}
	/**
	 * 进入总成CM的页面
	 * @return
	 */
	@RequestMapping("get_cm_assembly")
	public String getCmAssembly(){
		return "cm_table_assemblys";
	}
	/**
	 * 进入总成CS的页面
	 * @return
	 */
	@RequestMapping("get_cs_assembly")
	public String getCsAssembly(){
		return "cs_table_assemblys";
	}
	/**
	 * 进入总成WC的页面
	 * @return
	 */
	@RequestMapping("get_wc_assembly")
	public String getWcAssembly(){
		return "wc_table_assemblys";
	}
	
	/**
	 * ajax异步获取所有的总成列表
	 * @param pageNum
	 * @param pageSize
	 * @return List<BM,CM,CS,WC>
	 */
	@ResponseBody
	@RequestMapping("get_every_assembly")
	public Map<String, Object> getAllAssemblyList(String ass, int pageNum, int pageSize){
		Map<String, Object> map = partService.findAssemblyByFuzzySearch(ass, pageNum, pageSize);
		return map;
	}
	
	/**
	 * 进入总成编辑页面
	 * @param partId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("to_edit_ass_page")
	public ModelAndView toEditAssPage(String partId){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		ModelAndView mv = new ModelAndView();
		Assembly ass = partService.findAssemblyById(partId);
		ass.setAssembleTime(DateUtil.format(new Date()));
		ass.setUserId(user.getUserName());
		mv.addObject("data", ass);
		mv.setViewName("edit_assembly");
		return mv;
	}
	
	/**
	 * 
	 * 进入零配件页面
	 * @return
	 */
	@RequestMapping("/to_spare_part_page")
	public ModelAndView toSparePartPage(String partId){
		ModelAndView mv = new ModelAndView();
		
		Assembly ass = partService.findAssemblyAndPartsById(partId);
		
		mv.addObject("data", ass);
		mv.setViewName("spare_part");
		
		return mv;
	}
	
	/**
	 * 
	 * 根据总成id获取当前总成最多可装配的数量
	 * @param partId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get_max_assembly_num")
	public Map<String, Object> getMaxAssembleNum(String partId){
		Map<String, Object> map = new HashMap<>();
		//TODO 完善装配量，应该获取所有的零配件中数量最少的一个 
		
		Integer maxNum = partService.findMaxAssemableNum(partId);
		
		map.put("maxNum", maxNum);
		return map;
	}
	
	/**
	 * 
	 * 删除总成
	 * @param partId
	 * @return
	 */
	@RequestMapping("/to_delete_ass")
	public ModelAndView deleteAssByPartId(String partId){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		Integer count = partService.deleteOrUseAssByPartId(partId, user,0);
		
		String str = partId.substring(0, 2);
		
		if(count != 0){
			
			ModelAndView mv = new ModelAndView();
			if("BM".equals(str) || "Bm".equals(str) || "bm".equals(str))
				mv.setViewName("redirect:/get_bm_assembly");
			if("CM".equals(str) || "Cm".equals(str) || "cm".equals(str))
				mv.setViewName("redirect:/get_cm_assembly");
			if("CS".equals(str) || "Cs".equals(str) || "cs".equals(str))
				mv.setViewName("redirect:/get_cs_assembly");
			if("WC".equals(str) || "Wc".equals(str) || "wc".equals(str))
				mv.setViewName("redirect:/get_wc_assembly");
			
			return mv;
			
		}else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ERROR");
			return mv;
		}
		
	}
	
	/**
	 * 启用总成
	 * @param partId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/to_use_ass")
	public Map<String, Object> UseAssByPartId(String partId){
		
		Map<String, Object> map = new HashMap<>();
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		Integer count = partService.deleteOrUseAssByPartId(partId, user,1);
		
		
		if(count != 0){
			
			map.put("coun", 200);
			
			return map;
			
		}else{
			map.put("coun", 202);
			return map;
		}
	}
	
	/**
	 * 删除零件
	 * @param partId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete_spare_part")
	public Map<String,Object> toDeleteSparePart(String partId){
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		Integer count = partService.deleteOrUsesparePartById(partId, user, 0);
		if(count !=0){
			map.put("delete", 200);
			map.put("delete", "删除成功");
		}else{
			map.put("delete", 202);
			map.put("delete", "删除失败");
		}
		return map;
	}
	
	/**
	 * 进入零件添加页面
	 * @param partId
	 * @return
	 */
	@RequestMapping("/to_add_sparepart_page")
	public ModelAndView toAddSparePartPage(String partId){
		User user = (User) this.request.getSession().getAttribute("userInfo");
		ModelAndView mv = new ModelAndView();
		mv.addObject("assId", partId);
		mv.addObject("currentTime", DateUtil.format(new Date()));
		mv.addObject("userInfo", user);
		mv.setViewName("add_spare_part");
		return mv;
	}
	
	/**
	 * 
	 * 添加零件
	 * @param part
	 * @param pic
	 * @param assId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/add_one_spare_part")
	public String addSparePart(SpareParts part, MultipartFile pic, String assId, RedirectAttributes redirectAttributes){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		
		part.setUserId(user.getUserId().toString());
		
		Integer count = partService.addAssmeblyAndPart(assId, part, pic, "save");
		
		if(count != 0){
			//mv.addObject("partId", assId);
			redirectAttributes.addAttribute("partId", assId);
			return "redirect:/to_spare_part_page";
		}else{
			
			return "ERROR";
		}
		
	}
	/**
	 * 
	 * 编辑零件
	 * @param part
	 * @param pic
	 * @param assId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/edit_one_spare_part")
	public String editSparePart(SpareParts part, MultipartFile pic, String assId, RedirectAttributes redirectAttributes){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		
		part.setUserId(user.getUserId().toString());
		
		Integer count = partService.addAssmeblyAndPart(assId, part, pic,"update");
		
		if(count != 0){
			//mv.addObject("partId", assId);
			redirectAttributes.addAttribute("partId", assId);
			return "redirect:/to_spare_part_page";
		}else{
			
			return "ERROR";
		}
		
	}
	
	/**
	 * 
	 * 编辑零件
	 * @param assId
	 * @return
	 */
	@RequestMapping("/edit_spare_part")
	public ModelAndView editSparePart(String partId, String assId){
		User user = (User) this.request.getSession().getAttribute("userInfo");
		
		ModelAndView mv = new ModelAndView();
		
		SpareParts part = partService.findSparePartByPartId(partId);
		part.setUserId(user.getUserName());
		mv.addObject("part", part);
		mv.addObject("assId", assId);
		mv.setViewName("/edit_spare_part");
		
		return mv;
	}
	
	
	/**
	 * 进行总成装配
	 * @param assId
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/to_assemble_ass")
	public Map<String, Object> toAssembleAss(String assId, Integer num){
		
		User user = (User) this.request.getSession().getAttribute("userInfo");
		Map<String, Object> map = new HashMap<>();
		
		boolean flag = partService.updateAssAndSparePartNum(assId, num, user);
		
		if(flag){
			map.put("flag", 200);
		}else{
			map.put("flag", 202);
		}
		
		return map;
	}
	
	/**
	 * 模糊查找总成和零件
	 * @param condition
	 * @return
	 */
	@RequestMapping("/search_all_part")
	public ModelAndView searchAllPart(String condition){
		
		List<PartDTO> list = partService.findPartBySearch(condition);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("condition", condition);
		mv.addObject("list", list);
		mv.setViewName("/search");
		return mv;
	}
	
	/**
	 * 更改总成的数量
	 * @param partId
	 * @param status
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/change_ass_num")
	public Map<String, Object> changeAssemblyNum(String partId, String status, Integer num){
		Map<String, Object> map = new HashMap<>();
		
		User u = (User) this.request.getSession().getAttribute("userInfo");
		
		Integer count = partService.updateAssemblyNum(partId, num, status, u);
		
		if(count != 0){
			map.put("count", 200);
		}else{
			map.put("count", 202);
		}
		
		return map;
	}
	/**
	 * 更改零件的数量
	 * @param partId
	 * @param status
	 * @param num
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/change_part_num")
	public Map<String, Object> changeSparePartNum(String partId, String status, Integer num){
		Map<String, Object> map = new HashMap<>();
		
		User u = (User) this.request.getSession().getAttribute("userInfo");
		
		Integer count = partService.updateSparePartNum(partId, num, status, u);
		
		if(count != 0){

			map.put("count", 200);
		}else{
			
			map.put("count", 202);
		}
		
		return map;
	}
	
	/**
	 * 进入回收站
	 * @return
	 */
	@RequestMapping("/to_recycle_bin")
	public ModelAndView toRecycleBin(){
		ModelAndView mv = new ModelAndView();
		
		List<PartDTO> list = partService.findDeletePart();
		mv.addObject("list", list);
		mv.setViewName("/is_delete_part");
		
		return mv;
	}
	
	/**
	 * 恢复数据--零件
	 * @param Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("to_recover_sparepart_data")
	public Map<String, Object> recoveryData(String id){
		Map<String, Object> map = new HashMap<>();
		User user = (User) this.request.getSession().getAttribute("userInfo");
		Integer count = partService.deleteOrUsesparePartById(id, user, 1);
		if(count != 0){
			map.put("count",200);
		}else{
			map.put("count", 202);
		}
		return map;
	}
	
	/**
	 * 验证part编号已经存在
	 * @param partId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("verification_part")
	public Map<String, Object> verificationPartId(String partId){
		Map<String, Object> map = new HashMap<>();
		
		boolean flag = partService.findVerificationPartIdById(partId);
		
		if(flag){
			
			map.put("fl", 200);
		}else{
			
			map.put("fl", 202);
			map.put("message", "该产品已经存在&nbsp;<a href='search_all_part?condition="+partId+"'>[点击查看]</a>");
		}
		
		return map;
	}
	
	
}
