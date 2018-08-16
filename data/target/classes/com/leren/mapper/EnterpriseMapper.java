package com.leren.mapper;

import com.leren.entity.auth.Enterprise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 */
@Mapper
public interface EnterpriseMapper {
    /**
     * 删除企业信息
     *
     * @param uuid 企业标识
     * @return 删除记录条数
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * 保存企业信息[全部]
     *
     * @param record 企业信息
     * @return 保存记录条数
     */
    int insert(Enterprise record);

    /**
     * 保存企业信息[部分]
     *
     * @param record 企业信息
     * @return 保存记录条数
     */
    int insertSelective(Enterprise record);


    /**
     * 查询企业信息
     *
     * @param uuid 企业标识
     * @return 企业信息
     */
    Enterprise selectByPrimaryKey(String uuid);

    /**
     * 更新企业信息[全部]
     *
     * @param record 企业信息
     * @return 更新记录条数
     */
    int updateByPrimaryKeySelective(Enterprise record);

    /**
     * 更新企业信息[部分]
     *
     * @param record 企业信息
     * @return 更新记录条数
     */
    int updateByPrimaryKey(Enterprise record);

    /**
     * //TODO 查询企业列表
     *
     * @param param 参数
     * @return list
     */
    List<Map<String, Object>> selectEnterpriseListByParam(Map<String, Object> param);
}