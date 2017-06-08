package com.cn.winter.mapper;

import java.util.List;

import com.cn.winter.pojo.ProductForm;

public interface ProductFormMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(ProductForm record)throws Exception;

    int insertSelective(ProductForm record)throws Exception;

    ProductForm selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(ProductForm record)throws Exception;

    int updateByPrimaryKey(ProductForm record)throws Exception;
    
    /**
     * 根据订单的id查找订单产品列表
     * @param orderFormId
     * @return
     */
    List<ProductForm> findProductFormByOrderFormId(String orderFormId) throws Exception;
}