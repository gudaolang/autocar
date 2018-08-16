package com.leren.contorller;

import com.leren.service.RegisterService;
import com.leren.service.param.EpRegisterParam;
import com.leren.service.param.ShopRegisterParam;
import com.util.Md5Util;
import com.util.result.DataResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author lee
 * @Date:13/03/2018
 */

@Controller
@RequestMapping(value = "register")
public class RegisterController extends BaseController {


    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "注册首页")
    @RequestMapping(method = RequestMethod.GET, value = "index")
    public String registerIndex(Model model) {
        model.addAttribute("token", Md5Util.getBaseMd5(String.valueOf(System.currentTimeMillis())));
        return "index";
    }


    @ApiOperation(value = "企业(连锁门店)注册")
    @PostMapping("enterprise")
    public void enterpriseRegister(@RequestBody EpRegisterParam registerParam) {
        try {
            registerService.registerEnterprise(registerParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ApiOperation(value = "单门店注册")
    @PostMapping("shop")
    public void shopRegister(@RequestBody ShopRegisterParam registerParam) {

        registerService.registerShop(registerParam);

    }

    @GetMapping("cms/get")
    public DataResult cmsGet() {
        return null;
    }

}
