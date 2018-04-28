package com.leren.mapper;

import com.leren.entity.auth.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    void insertBatch(List<Shop> shops);
}