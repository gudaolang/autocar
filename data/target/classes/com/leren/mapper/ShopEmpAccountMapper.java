package com.leren.mapper;


import com.leren.entity.auth.ShopEmpAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ShopEmpAccountMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ShopEmpAccount record);

    int insertSelective(ShopEmpAccount record);

    ShopEmpAccount selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ShopEmpAccount record);

    int updateByPrimaryKey(ShopEmpAccount record);

    ShopEmpAccount selectSingleByParam(Map<String, Object> param);

}