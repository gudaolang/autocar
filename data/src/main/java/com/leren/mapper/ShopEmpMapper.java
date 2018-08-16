package com.leren.mapper;

import com.leren.entity.auth.ShopEmp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lee
 */
@Mapper
public interface ShopEmpMapper {
    /**
     * 删除门店员工信息
     *
     * @param uuid 员工标识
     * @return 删除记录条数
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 添加门店员工信息[全部]
     *
     * @param record 保存门店员工信息
     * @return 添加记录条数
     */
    int insert(ShopEmp record);

    /**
     * 添加门店员工信息[部分]
     *
     * @param record 门店员工信息
     * @return 添加记录条数
     */
    int insertSelective(ShopEmp record);

    /**
     * 查询门店员工信息
     *
     * @param uuid 门店员工标识
     * @return 门店员工信息
     */
    ShopEmp selectByPrimaryKey(String uuid);

    /**
     * 更新门店员工信息[部分]
     *
     * @param record 门店员工信息
     * @return 更新记录条数
     */
    int updateByPrimaryKeySelective(ShopEmp record);

    /**
     * 更新门店员工信息[全部]
     *
     * @param record 门店员工信息
     * @return 更新记录条数
     */
    int updateByPrimaryKey(ShopEmp record);
}