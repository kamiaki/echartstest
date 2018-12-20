package com.test.echarts.demo.controller;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;
import com.google.gson.Gson;
import com.test.echarts.demo.service.ServiceFrist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/")
    public String first(Model model)throws Exception{
        model.addAttribute("title","ECharts_Test");
        return "thymeleaf/echartsTEST";
    }

    @RequestMapping(value = "/basicLine")
    public void basicLine(@RequestParam(value = "url") String value , HttpServletResponse response)throws Exception{
        System.out.println(value);

        Option option = serviceFrist.basicLine();
        String json = GsonUtil.format(option);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();

        return;
    }
}
