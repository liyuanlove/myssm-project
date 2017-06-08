package com.cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.SpareParts;
import com.cn.winter.pojo.User;
import com.cn.winter.service.part.PartsService;
import com.cn.winter.service.user.UserService;
import com.cn.winter.utils.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class PartTest {
	
	private static Logger logger = Logger.getLogger(PartTest.class);
	
	@Resource
	private PartsService partsService;
	
	@Resource(name="userService")
	private UserService userService;
	/**
	 * 添加总成和零配件
	 */
//	@Test
//	public void test1(){
//		for(int x=0; x<9; x++){
//			
//			Assembly ass = new Assembly();
//			ass.setPartId("WC0202"+x);
//			ass.setPartName("离合器总泵");
//			ass.setDiameter("22.22");
//			ass.setPartStatus(1);
//			ass.setAssembleTime(DateUtil.format(new Date()));
//			ass.setWeight("2.00");
//			ass.setUserId("1");
//			ass.setPrice("34.00");
//			ass.setNumber(60000);
//			
//			
//			List<SpareParts> list = new ArrayList<SpareParts>();
//			for(int i = 0; i < 5; i++){
//				SpareParts part = new SpareParts();
//				part.setPartId("204202"+x+i);
//				part.setPartName("活塞");
//				part.setNumber(300);
//				part.setMaterial("FE");
//				part.setProductionTime(DateUtil.format(new Date()));
//				part.setSupplier("慈溪恒渊汽车零配件厂");
//				part.setAddTime(DateUtil.format(new Date()));
//				part.setUserId("1234");
//				part.setPrice("2.00");
//				list.add(part);
//			}
//			partsService.addAssmeblyAndPart(ass, list);
//		}
//	}
	
	@Test
	public void test2(){
		Assembly asss = partsService.findAssemblyAndPartsById("WC02033");
		System.out.println(asss);
	}
	
	@Test
	public void test3(){
		SpareParts part = partsService.findSparePartByPartId("20420332");
		System.out.println(part);
	}
	
	@Test
	public void test4(){
		
		List<Assembly> list = partsService.findAllAssembly(2, 2);
		for(Assembly a : list){
			System.out.println(a);
		}
	}
	
	@Test
	public void test5(){
		User user = new User();
		user.setCreateTime(DateUtil.format(new Date()));
		user.setPhone("15258800630");
		user.setPassword("123456");
		user.setRoldId(3);
		user.setUserName("陈冬华");
		user.setUserStatus(1);
		
		Integer count = userService.addUser(user);
		System.out.println(count);
	}
	
	@Test
	public void test6(){
		
		Integer count = userService.deleteUserById(2, 3);
		System.out.println(count);
	}
	
	@Test
	public void test7(){
		
		User user = new User();
		user.setPassword("123456");
		user.setUserId(1);
		Integer count = userService.updateUser(user);
		System.out.println(count);
	}
	
	@Test
	public void test8(){
		
		List<User> list = userService.findAllUser(1, 2);
		for(User u : list){
			System.out.println(u);
		}
	}
	@Test
	public void test9(){
		
		String roleName = userService.findUserAuthorityByUserId(1);
		System.out.println(roleName);
	}
}
