package com.leren.service.impl;

import com.leren.entity.auth.Enterprise;
import com.leren.mapper.EnterpriseMapper;
import com.leren.service.EnterpriseService;
import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.results.EnterpriseApplyResult;
import com.util.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lee 2018/8/15 16:44
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    /**
     * 查询申请企业列表
     *
     * @param applyParam 参数
     * @return list
     */
    @Override
    public List<EnterpriseApplyResult> getApplyEnterpriseListByParam(EnterpriseApplyParam applyParam) {

        Map<String, Object> param = MapUtils.bean2Map(applyParam);

        return MapUtils.map2Array(enterpriseMapper.selectEnterpriseListByParam(param), EnterpriseApplyResult.class);
    }

    /**
     * 更新企业信息
     *
     * @param enterprise 企业信息
     * @return 更新记录条数
     */
    @Override
    public int updateByPrimaryKey(Enterprise enterprise) {
        return enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    }
}
