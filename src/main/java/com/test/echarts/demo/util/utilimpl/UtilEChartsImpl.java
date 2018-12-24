package com.test.echarts.demo.util.utilimpl;

import com.test.echarts.demo.util.UtilECharts;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component(value = "utilController")
public class UtilEChartsImpl implements UtilECharts {

    public void sendJson(HttpServletResponse response, String json)throws Exception{
        response.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(json);
        printWriter.flush();
    }
}
