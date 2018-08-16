package com.leren.mapper;

import com.leren.entity.auth.ShopEmpAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * mapper:客户账号
 *
 * @author lee
 */
@Mapper
public interface ShopEmpAccountMapper {
    /**
     * 删除账号信息
     *
     * @param uuid 客户账号标识
     * @return 删除记录条数
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 保存客户账号信息[全部]
     *
     * @param record 账号信息
     * @return 插入记录条数
     */
    int insert(ShopEmpAccount record);

    /**
     * 保存客户账号信息[部分]
     *
     * @param record 账号信息
     * @return 插入记录条数
     */
    int insertSelective(ShopEmpAccount record);

    /**
     * 根据账号标识获取客户信息
     *
     * @param uuid 客户账号标识
     * @return 账号信息
     */
    ShopEmpAccount selectByPrimaryKey(String uuid);

    /**
     * 更新客户账号[部分更新]
     *
     * @param record 账号信息
     * @return 更新记录条数
     */
    int updateByPrimaryKeySelective(ShopEmpAccount record);

    /**
     * 更新客户账号[全更]
     *
     * @param record 账号信息
     * @return 更新记录条数
     */
    int updateByPrimaryKey(ShopEmpAccount record);

    /**
     * 获取客户信息
     *
     * @param param 可选参数列表
     * @return 账号信息
     */
    ShopEmpAccount selectSingleByParam(Map<String, Object> param);
}