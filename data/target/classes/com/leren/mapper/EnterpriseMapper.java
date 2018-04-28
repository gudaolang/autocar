package com.leren.mapper;


import com.leren.entity.auth.Enterprise;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EnterpriseMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}