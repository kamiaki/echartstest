package com.test.echarts.demo.util;

import javax.servlet.http.HttpServletResponse;

public interface UtilECharts {
    public void sendJson(HttpServletResponse response, String json)throws Exception;
}
