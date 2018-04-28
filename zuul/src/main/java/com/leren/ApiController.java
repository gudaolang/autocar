package com.leren;

import com.leren.service.CmsService;
import com.util.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @Date:16/03/2018
 */

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private CmsService cmsService;

    @GetMapping("cms/test")
    public DataResult cms() {

        return cmsService.getAa();
    }

}
