package com.leren.service;

import com.util.result.DataResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lee
 * @Date:16/03/2018
 */
@FeignClient(name = "cms")
public interface CmsService {

    @RequestMapping(value = "cms/test", method = RequestMethod.GET)
    DataResult getAa();
}
