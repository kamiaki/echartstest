package com.test.echarts.demo.controller;

import com.github.abel533.echarts.Option;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerFrist {

    @RequestMapping(value = "/")
    public String first(Model model)throws Exception{
        model.addAttribute("value1","测试数据");
        Option option = new Option();
        return "thymeleaf/echartsTEST";
    }

    @RequestMapping(value = "/ajaxTest")
    public void ajaxTest(HttpServletResponse response, String username, String id)throws Exception{
        System.out.println(username);
        System.out.println(id);
        Map<String, String> map = new HashMap<String,String>();
        map.put("name1","aki1");
        map.put("name2","aki2");
        map.put("名字3","aki3");
        String json = new Gson().toJson(map);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
    }
}
