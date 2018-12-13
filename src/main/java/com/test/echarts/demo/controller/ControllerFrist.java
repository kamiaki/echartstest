package com.test.echarts.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerFrist {

    @RequestMapping(value = "/")
    public String first(Model model)throws Exception{
        model.addAttribute("value1","测试数据");
        return "thymeleaf/echartsTEST";
    }
}
