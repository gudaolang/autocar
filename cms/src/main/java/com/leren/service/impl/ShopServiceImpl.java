package com.leren.service.impl;

import com.leren.ConstantParams;
import com.leren.entity.auth.Shop;
import com.leren.mapper.ShopMapper;
import com.leren.service.ShopService;
import com.leren.service.param.ShopApplyParam;
import com.leren.service.results.ShopApplyResult;
import com.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lee
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;


    /**
     * 查询门店审核列表
     *
     * @param applyParam 查询参数
     * @return 未审核门店
     */
    @Override
    public List<ShopApplyResult> getApplyShopListByParam(ShopApplyParam applyParam) {
        Map<String, Object> param = MapUtils.bean2Map(applyParam);
        MapUtils.addToMap(param, "status", ConstantParams.AUDITING);
        return MapUtils.map2Array(shopMapper.selectShopListByParam(param), ShopApplyResult.class);
    }

    /**
     * 更新门店信息
     *
     * @param shop 门店信息
     * @return 记录条数
     */
    @Override
    public int updateByPrimaryKey(Shop shop) {
        return shopMapper.updateByPrimaryKeySelective(shop);
    }
}
