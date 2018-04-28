package com.leren.controller.auth;

import com.leren.service.CmsService;
import com.util.result.DataResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lee
 * @Date:13/03/2018
 */
@RestController
@RequestMapping(value = "enterprise")
public class EnterpriseController {

    private Logger logger = Logger.getLogger(EnterpriseController.class);


    @Autowired
    private CmsService cmsService;


    @PostMapping(value = "register")
    public void register() {

    }


    @GetMapping(value = "test")
    public DataResult feightTest() {
        return cmsService.getAa();
    }

}
