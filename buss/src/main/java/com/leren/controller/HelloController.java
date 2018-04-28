package com.leren.controller;

import com.leren.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lee
 * @Date:22/02/2018
 */

@Controller
@RequestMapping("hello")
public class HelloController extends BaseController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }


    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    public void error() throws MyException {
        throw new MyException("错误了!");
    }

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("host", "http://blog.didispace.com");
        return "ABC";
    }
}
