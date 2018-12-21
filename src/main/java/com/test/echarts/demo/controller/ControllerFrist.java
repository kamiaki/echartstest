package com.test.echarts.demo.controller;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;
import com.google.gson.Gson;
import com.test.echarts.demo.service.ServiceFrist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerFrist {
    @Autowired
    ServiceFrist serviceFrist;

    @Transactional  //事务回滚
    @RequestMapping(value = "/testDB")
    public String testDB()throws Exception{
        serviceFrist.testDB();
        return "thymeleaf/testDB";
    }

    @RequestMapping(value = "/")
    public String first(Model model)throws Exception{
        model.addAttribute("title","ECharts_Test");
        return "thymeleaf/echartsTEST";
    }

    @RequestMapping(value = "/ECharts/{chart}")
    public void basicLine(@PathVariable(value = "chart") String chart, @RequestParam(value = "url") String value , HttpServletResponse response)throws Exception{
        System.out.println(chart);
        System.out.println(value);
        Option option = null;
        String json = "";

        switch (chart){
            case "basicLine":
                option = serviceFrist.basicLine();
                break;
            case "basicColumn":
                break;
            default:
                break;
        }

        if(option!=null){
            json = GsonUtil.format(option);
        }else{
            json = "error";
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();

        return;
    }
}
