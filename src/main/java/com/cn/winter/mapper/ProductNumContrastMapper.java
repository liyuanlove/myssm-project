package com.cn.winter.mapper;

import java.util.List;

import com.cn.winter.pojo.ProductNumContrast;

public interface ProductNumContrastMapper {
    int deleteByPrimaryKey(Integer id)throws Exception;

    int insert(ProductNumContrast record)throws Exception;

    int insertSelective(ProductNumContrast record)throws Exception;

    ProductNumContrast selectByPrimaryKey(Integer id)throws Exception;

    int updateByPrimaryKeySelective(ProductNumContrast record)throws Exception;

    int updateByPrimaryKey(ProductNumContrast record)throws Exception;
    
    /**
     * 通过customerid查找客户的编号集合
     * @param customerId
     * @return
     * @throws Exception
     */
    List<ProductNumContrast> findCustomerProductByCustomerId(String customerId) throws Exception;
}