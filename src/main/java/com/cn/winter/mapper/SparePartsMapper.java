package com.cn.winter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.winter.pojo.AssAndPartRelation;
import com.cn.winter.pojo.SpareParts;

public interface SparePartsMapper {
	
    /**
     * 根据零件编号删除零件
     * @param partId
     * @return
     */
    int deletePartById(String partId) throws Exception;

    /**
     * 添加满足所有的属性的零件
     * @param record
     * @return
     */
    int addAllPropertyPart(SpareParts record) throws Exception;

    /**
     * 根据需要添加零件
     * @param record
     * @return
     */
    int addPartSelective(SpareParts record) throws Exception;

    /**
     * 查找零件根据Id
     * @param partId
     * @return
     */
    SpareParts findPartById(String partId) throws Exception;

    /**
     * 根据需要更新零件部分属性
     * @param record
     * @return
     */
    int updatePartSelective(SpareParts record) throws Exception;

    /**
     * 更新满足所有属性的零件
     * @param record
     * @return
     */
    int updateAllPropertyPart(SpareParts record) throws Exception;
    
    /**
     * 根据id查询零配件，并将通用该零配件的总成查出
     * @param partId
     * @return
     */
    SpareParts findPartAndAssembly(String partId) throws Exception;
    
    /**
     * 进行总成和零配件的关联的建立
     * @param assId
     * @param partId
     * @return
     */
    int addAssAndPartRelation(@Param("ass_id")String assId, @Param("fk_p_id")String partId) throws Exception;
    
    /**
     * 更新零件关系
     * @param assId
     * @param partId
     * @param status
     * @param id
     * @return
     */
    int updateAssAndPartRelation(@Param("ass_id")String assId, @Param("fk_p_id")String partId, @Param("fk_status")Integer status, @Param("id")Integer id);
    
    /**
     * 根据零件id查找关系
     * @param partId
     * @return
     */
    List<AssAndPartRelation> findAssAndPartRelation(@Param("fk_p_id")String partId);
    
    /**
     * 
     * 模糊查找零件
     * @param condition
     * @return
     */
    List<SpareParts> findSparePartByFuzzy(@Param("text")String condition);
    
    /**
     * 找到所有的删除状态的零件
     * @return
     */
    List<SpareParts> findSparePartIsDelete();
    
    /**
     * 找到所有的零件
     * @return
     */
    List<SpareParts> findAllSparePart();
    
    /**
     * 根据总称id查找总成的关系
     * @param assId
     * @return
     */
    List<AssAndPartRelation> findPartAndAssRelation(@Param("fk_a_id")String assId);
}