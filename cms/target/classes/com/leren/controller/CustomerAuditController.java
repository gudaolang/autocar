package com.leren.controller;

import com.leren.service.CustomerAuditService;
import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.param.EnterpriseAuditParam;
import com.leren.service.param.ShopApplyParam;
import com.leren.service.param.ShopAuditParam;
import com.util.result.DataResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @Date:13/03/2018
 */

@RestController
@RequestMapping(value = "cms")
public class CustomerAuditController extends BaseController {

    private Logger logger = Logger.getLogger(CustomerAuditController.class);

    @Autowired
    private CustomerAuditService customerAuditService;


    @Autowired
    private DiscoveryClient client;


    /**
     * 查询门店列表
     *
     * @param applyParam status:0 申请中;1 审核通过;2 审核失败[失败原因]
     * @return
     */
    @GetMapping(value = "shop/list")
    public DataResult findShopApplyList(ShopApplyParam applyParam) {
        return new DataResult(customerAuditService.getApplyShopListByParam(applyParam));
    }

    /**
     * 门店审核[可多门店审核]
     *
     * @param result
     */
    @GetMapping(value = "shop/audit")
    public void shopAudit(@RequestBody ShopAuditParam shopAuditParam, BindingResult result) {
        customerAuditService.auditShop();
    }

    /**
     * 连锁企业申请列表
     *
     * @param applyParam status:0 申请中;1 审核通过;2 审核失败[失败原因]
     * @return
     */
    @GetMapping(value = "enterprise/list")
    public DataResult findEnterpriseApplyList(EnterpriseApplyParam applyParam) {
        return new DataResult(customerAuditService.getApplyEnterpriseListByParam(applyParam));
    }

    /**
     * 连锁企业审核
     */
    @GetMapping(value = "enterprise/audit")
    public void enterpriseAudit(@RequestBody EnterpriseAuditParam shopAuditParam, BindingResult result) {
        customerAuditService.auditEnterprise();
    }


    @GetMapping(value = "test")
    public DataResult test() {
        StringBuilder builder = new StringBuilder();
        ServiceInstance instance = client.getLocalServiceInstance();
        builder.append("host:").append(instance.getHost()).append("====").append(instance.getPort());
        return new DataResult(builder);
    }

}
