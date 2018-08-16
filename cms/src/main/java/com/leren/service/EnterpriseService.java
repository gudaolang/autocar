package com.leren.service;

import com.leren.entity.auth.Enterprise;
import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.results.EnterpriseApplyResult;

import java.util.List;

/**
 * @author lee 2018/8/15 16:45
 */
public interface EnterpriseService {

    /**
     * 查询申请企业列表
     *
     * @param applyParam 参数
     * @return list
     */
    List<EnterpriseApplyResult> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam);

    /**
     * 更新企业信息
     *
     * @param enterprise 企业信息
     * @return 更新记录条数
     */
    int updateByPrimaryKey(Enterprise enterprise);
}
