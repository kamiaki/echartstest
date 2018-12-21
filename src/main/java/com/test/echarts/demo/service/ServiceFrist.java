package com.test.echarts.demo.service;

import com.github.abel533.echarts.Option;

public interface ServiceFrist {
    //画图表
    Option basicLine()throws Exception;
    Option basicColumn()throws Exception;
    Option basicPie()throws Exception;
    Option basicMaps()throws Exception;

    //测试数据库
    void testDB()throws Exception;
}
