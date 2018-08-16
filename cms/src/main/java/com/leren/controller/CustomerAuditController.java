package com.leren.controller;

import com.leren.service.CustomerAuditService;
import com.leren.service.param.EnterpriseApplyParam;
import com.leren.service.param.EnterpriseAuditInfoParam;
import com.leren.service.param.ShopApplyParam;
import com.leren.service.param.ShopAuditParam;
import com.util.result.DataResult;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @RequiresAuthentication
    @GetMapping(value = "shop/list")
    public DataResult findShopApplyList(ShopApplyParam applyParam) {
        return new DataResult<>(customerAuditService.getApplyShopListByParam(applyParam));
    }

    /**
     * 门店审核[多门店审核]
     * @param shopAuditParam 要审核的门店信息
     * @param result 参数校验结果
     * @return  审核结果
     */
    @PostMapping(value = "shop/audit")
    public DataResult shopAudit(@RequestBody ShopAuditParam shopAuditParam, BindingResult result) {

        customerAuditService.auditShops(shopAuditParam);
        return new DataResult();
    }

    /**
     * 连锁企业申请列表
     *
     * @param applyParam status:0 申请中;1 审核通过;2 审核失败[失败原因]
     * @return
     */
    @GetMapping(value = "enterprise/list")
    public DataResult findEnterpriseApplyList(EnterpriseApplyParam applyParam) {
        return new DataResult<>(customerAuditService.getApplyEnterpriseListByParam(applyParam));
    }

    /**
     * 连锁企业审核
     */
    @PostMapping(value = "enterprise/audit")
    public DataResult enterpriseAudit(@RequestBody EnterpriseAuditInfoParam enterpriseAuditInfoParam, BindingResult result) {
        customerAuditService.auditEnterprise(enterpriseAuditInfoParam);
        return new DataResult();
    }


    @GetMapping(value = "test")
    public DataResult test() {
        StringBuilder builder = new StringBuilder();
        ServiceInstance instance = client.getLocalServiceInstance();
        builder.append("host:").append(instance.getHost()).append("====").append(instance.getPort());
        return new DataResult<>(builder);
    }

}
