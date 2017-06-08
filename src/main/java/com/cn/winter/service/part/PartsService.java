package com.cn.winter.service.part;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cn.winter.pojo.Assembly;
import com.cn.winter.pojo.SpareParts;
import com.cn.winter.pojo.User;
import com.cn.winter.service.part.impl.dto.PartDTO;

/**
 * 零配件服务层接口
 * @author Winterchen
 *
 */
public interface PartsService {

	/**
	 * 进行总成和零配件的关联添加
	 * @param assId	总成编号
	 * @param partId	零配件编号
	 * @return
	 */
	int addAssmeblyAndPartRelation(String assId, String partId);
	
	
	/**
	 * 添加或者更新总成和他的零配件
	 * @param partId
	 * @param part
	 * @param pic
	 * @param saveOrUpdate 更新还是添加
	 * @return
	 */
	int addAssmeblyAndPart(String partId, SpareParts part, MultipartFile pic, String saveOrUpdate);
	
	/**
	 * 通过id查找总成和其下的所有零配件
	 * @param id
	 * @return
	 */
	Assembly findAssemblyAndPartsById(String id);
	
	/**
	 * 通过零件Id查找零件
	 * @param partId
	 * @return
	 */
	SpareParts findSparePartByPartId(String partId);
	
	/**
	 * 更新零件
	 * @param part
	 * @return
	 */
	Integer updateSparePartByPartId(SpareParts part);
	
	
	/**
	 * 查找所有的总称 并分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<Assembly> findAllAssembly(int pageNum, int pageSize);
	
	/**
	 * 模糊查找总成
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	Map<String, Object> findAssemblyByFuzzySearch(String ass, int pageNum, int pageSize);
	
	/**
	 * 添加总成
	 * @param ass
	 * @param pic 
	 * @return
	 */
	Integer addAssembly(Assembly ass, MultipartFile pic) throws Exception;
	
	/**
	 * 
	 * 通过总称Id查找总成
	 * @param partId
	 * @return
	 */
	Assembly findAssemblyById(String partId);
	
	
	/**
	 * 查找最大的装配数量，以零件数量最少的那个为准
	 * @return
	 */
	Integer findMaxAssemableNum(String partId);
	
	/**
	 * 根据总成编号删除总成
	 * @param partId
	 * @param user
	 * @return
	 */
	Integer deleteOrUseAssByPartId(String partId, User user, Integer status);
	
	
	/**
	 * 
	 * 根据id删除或者启用零件，包括关系
	 * @param partId
	 * @param user
	 * @param status
	 * @return
	 */
	Integer deleteOrUsesparePartById(String partId, User user, Integer status);
	
	
	/**
	 * 
	 * 装配总成
	 * @param assId
	 * @param num
	 * @param user
	 * @return
	 */
	boolean updateAssAndSparePartNum(String assId, Integer num, User user);
	
	
	
	/**
	 * 
	 * 模糊查找总成或者零件
	 * @param condition
	 * @return
	 */
	List<PartDTO> findPartBySearch(String condition);
	
	
	/**
	 * 更新总成数量
	 * @param partId
	 * @param Num
	 * @param status
	 * @return
	 */
	Integer updateAssemblyNum(String partId, Integer num, String status, User u);
	
	/**
	 * 更新零件数量
	 * @param partId
	 * @param Num
	 * @param status
	 * @return
	 */
	Integer updateSparePartNum(String partId, Integer num, String status, User u);
	
	
	/**
	 * 查找所有状态为删除的总成和零件
	 * @return
	 */
	List<PartDTO> findDeletePart();
	
	
	/**
	 * 验证零件的编号是否已经存在
	 * @param partId
	 * @return
	 */
	boolean findVerificationPartIdById(String partId);
	
	
}
