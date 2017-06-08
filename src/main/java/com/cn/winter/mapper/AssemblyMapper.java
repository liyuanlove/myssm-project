package com.cn.winter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.winter.pojo.Assembly;

public interface AssemblyMapper {
	
    /**
     * 通过id去删除总成（不适用）
     * @param partId
     * @return
     */
    int deleteAssemblyById(String partId) throws Exception;
    
    /**
     * 不常用 因为需要所有的属性都要满足
     * @param record
     * @return
     */
    int insert(Assembly record) throws Exception;

    /**
     * 添加总成
     * @param record
     * @return
     */
    int addAssembly(Assembly record) throws Exception;

    /**
     * 通过总成编号查找总成
     * @param partId
     * @return
     */
    Assembly findAssemblyById(String partId) throws Exception;

    /**
     * 更新总成byId
     * @param record
     * @return
     */
    int updateAssemblyById(Assembly record) throws Exception;

    /**
     * 根据总成编号更新总成的所有属性（不常用）
     * @param record
     * @return
     */
    int updateAssemblyAllPropertyById(Assembly record) throws Exception;
    
    /**
     * 查询总成的时候一并将零配件查出
     * @param id
     * @return
     */
    Assembly findAssAndPart(String assId) throws Exception;
    
    /**
     * 
     * 查找所有的总成
     * @return
     */
    List<Assembly> findAllAss(int pageNum, int pageSize);
    
    /**
     * 模糊查找总成列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Assembly> findAssemblyByFuzzy(@Param("text")String text,int pageNum, int pageSize);
    
    
    /**
     * 
     * 查找删除状态的总成
     * @return
     */
    List<Assembly> findAssIsDelete();
    
}