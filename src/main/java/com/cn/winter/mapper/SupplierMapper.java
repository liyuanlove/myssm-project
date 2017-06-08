package com.cn.winter.mapper;

import com.cn.winter.pojo.Supplier;

public interface SupplierMapper {
	
    /**
     * 根据编号删除供应商
     * @param supplierId
     * @return
     */
    int deleteSupplierById(Integer supplierId);

    /**
     * 添加所有属性的供应商
     * @param record
     * @return
     */
    int addAllPropertySupplier(Supplier record);

    /**
     * 根据需要添加供应商
     * @param record
     * @return
     */
    int addSupplierSelective(Supplier record);

    /**
     * 根据Id查找供应商
     * @param supplierId
     * @return
     */
    Supplier findSupplierById(Integer supplierId);

    /**
     * 选择性的更新供应商信息
     * @param record
     * @return
     */
    int updateSupplierByIdSelective(Supplier record);

    /**
     * 更新供应商的所有数据
     * @param record
     * @return
     */
    int updateAllPropertySupplier(Supplier record);
}