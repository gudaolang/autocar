package com.leren.mapper;

import com.leren.entity.auth.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 */
@Mapper
public interface ShopMapper {
    /**
     * 删除门店信息
     *
     * @param uuid 门店标识
     * @return 删除记录条数
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 保存门店信息[全部]
     *
     * @param record 门店标识
     * @return 插入记录条数
     */
    int insert(Shop record);

    /**
     * 保存门店信息[部分]
     *
     * @param record 门店标识
     * @return 插入记录条数
     */
    int insertSelective(Shop record);

    /**
     * 查询门店信息
     *
     * @param uuid 门店标识
     * @return 门店信息
     */
    Shop selectByPrimaryKey(String uuid);

    /**
     * 更新门店信息[部分]
     *
     * @param record 门店标识
     * @return 更新记录条数
     */
    int updateByPrimaryKeySelective(Shop record);

    /**
     * 更新门店信息[全部]
     *
     * @param record 门店标识
     * @return 更新记录条数
     */
    int updateByPrimaryKey(Shop record);

    /**
     * 批量保存门店信息[全部]
     *
     * @param shops 要保存的门店信息
     * @return 插入记录条数
     */
    int insertBatch(List<Shop> shops);


    /**
     * //TODO 查询门店列表
     *
     * @param param 参数
     * @return 门店列表
     */
    List<Map<String, Object>> selectShopListByParam(Map<String, Object> param);
}