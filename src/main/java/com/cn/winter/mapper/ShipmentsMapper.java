package com.cn.winter.mapper;

import com.cn.winter.pojo.Shipments;

public interface ShipmentsMapper {
	
    /**
     * 根据Id删除发货对象
     * @param id
     * @return
     */
    int deleteShipmentById(Integer id);

    /**
     * 添加满足所有属性的发货对象
     * @param record
     * @return
     */
    int addAllPropertyShipment(Shipments record);

    /**
     * 有选择性的添加发货对象
     * @param record
     * @return
     */
    int addShipmentSelective(Shipments record);

    /**
     * 根据id查找发货对象
     * @param id
     * @return
     */
    Shipments findShipmentById(Integer id);

    /**
     * 根据id更新发货对象 ，有选择性的
     * @param record
     * @return
     */
    int updateShipmentByIdSelective(Shipments record);

    /**
     * 根据id更新发货对象
     * @param record
     * @return
     */
    int updateShipmentById(Shipments record);
}