package com.leren.service;

import com.leren.entity.auth.Shop;
import com.leren.service.param.ShopApplyParam;
import com.leren.service.results.ShopApplyResult;

import java.util.List;

/**
 * @author lee
 */
public interface ShopService {

    /**
     * 查询门店审核列表
     *
     * @param applyParam
     * @return 未审核门店
     */
    List<ShopApplyResult> getApplyShopListByParam(ShopApplyParam applyParam);

    /**
     * 更新门店信息
     *
     * @param shop 门店信息
     * @return 记录条数
     */
    int updateByPrimaryKey(Shop shop);
}
