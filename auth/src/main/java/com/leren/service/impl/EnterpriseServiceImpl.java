package com.leren.service.impl;

import com.leren.entity.auth.Enterprise;
import com.leren.mapper.EnterpriseMapper;
import com.leren.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @Date:28/03/2018
 */

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public void save(Enterprise enterprise) {
        enterpriseMapper.insertSelective(enterprise);
    }
}
