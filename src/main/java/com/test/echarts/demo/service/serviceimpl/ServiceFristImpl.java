package com.test.echarts.demo.service.serviceimpl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.feature.*;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.MarkLine;
import com.github.abel533.echarts.series.MarkPoint;
import com.github.abel533.echarts.series.Series;
import com.test.echarts.demo.dao.TestTable1Mapper;
import com.test.echarts.demo.po.TestTable1;
import com.test.echarts.demo.service.ServiceFrist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ServiceFristImpl implements ServiceFrist {
    @Autowired
    TestTable1Mapper testTable1Mapper;

    @Override
    public Option basicLine() throws Exception {
        Option option = new Option();
        option.title().text("未来一周气温变化");
        option.title().sublink("纯属虚构");
        option.tooltip().trigger(Trigger.axis);

        List<String> list = new ArrayList<>();
        list.add("最高气温");
        list.add("最低气温");
        option.legend().data(list);
        option.toolbox().show(true);

        list = new ArrayList<>();
        list.add("line");
        list.add("bar");
        option.toolbox().feature(Tool.mark,
                new DataView().show(true).readOnly(false),
                new MagicType().show(true).type(list),
                Tool.restore,
                Tool.saveAsImage);
        option.calculable(true);

        Axis xaxis = new CategoryAxis();
        xaxis.type(AxisType.category);
        xaxis.boundaryGap(false);
        String[] date = new String[]{"周一","周二","周三","周四","周五","周六","周日"};
        xaxis.data(date);
        List<Axis> xaxes = new ArrayList<>();
        xaxes.add(xaxis);
        option.xAxis(xaxes);

        Axis yaxis = new ValueAxis();
        yaxis.type(AxisType.value);
        yaxis.axisLabel().formatter("{value}℃");
        List<Axis> yaxes = new ArrayList<>();
        yaxes.add(yaxis);
        option.yAxis(yaxes);

        Series series = new Line();
        series.name("最高气温");
        series.type(SeriesType.line);
        series.data(new Integer[]{11, 11, 15, 13, 12, 13, 10});
        Data[] datas = new Data[]{new Data().type(MarkType.max).name("最大值"),
                new Data().type(MarkType.min).name("最小值")};
        MarkPoint markPoint = new MarkPoint();
        markPoint.data(datas);
        series.markPoint(markPoint);
        Data[] datas2 = new Data[]{new Data().type(MarkType.average).name("平均值") };
        MarkLine markLine = new MarkLine();
        markLine.data(datas2);
        series.markLine(markLine);

        Series series_2 = new Line();
        series_2.name("最低气温");
        series_2.type(SeriesType.line);
        series_2.data(new Integer[]{1, -2, 2, 5, 3, 2, 0});
        Data[] datas_2 = new Data[]{new Data().name("周最低")
                .value(-2).xAxis(1)
                .yAxis(-2) };
        MarkPoint markPoint_2 = new MarkPoint();
        markPoint_2.data(datas_2);
        series_2.markPoint(markPoint_2);
        Data[] datas2_2 = new Data[]{new Data().type(MarkType.average).name("平均值") };
        MarkLine markLine_2 = new MarkLine();
        markLine_2.data(datas2_2);
        series_2.markLine(markLine_2);

        List<Series> seriesList = new ArrayList<>();
        seriesList.add(series);
        seriesList.add(series_2);
        option.series(seriesList);

        option.calculable(true);
        System.out.println(GsonUtil.format(option));
        return option;
    }

    @Override
    public Option basicColumn() throws Exception {
        return null;
    }

    @Override
    public Option basicPie() throws Exception {
        return null;
    }

    @Override
    public Option basicMaps() throws Exception {
        String StrMap = "{\n" +
                "        title : {\n" +
                "            text: 'iphone销量',\n" +
                "            subtext: '纯属虚构',\n" +
                "            x:'center'\n" +
                "        },\n" +
                "        tooltip : {\n" +
                "            trigger: 'item'\n" +
                "        },\n" +
                "        legend: {\n" +
                "            orient: 'vertical',\n" +
                "            x:'left',\n" +
                "            data:['iphone3','iphone4','iphone5']\n" +
                "        },\n" +
                "        dataRange: {\n" +
                "            min: 0,\n" +
                "            max: 2500,\n" +
                "            x: 'left',\n" +
                "            y: 'bottom',\n" +
                "            text:['高','低'],           // 文本，默认为数值文本\n" +
                "            calculable : true\n" +
                "        },\n" +
                "        toolbox: {\n" +
                "            show: true,\n" +
                "            orient : 'vertical',\n" +
                "            x: 'right',\n" +
                "            y: 'center',\n" +
                "            feature : {\n" +
                "                mark : {show: true},\n" +
                "                dataView : {show: true, readOnly: false},\n" +
                "                restore : {show: true},\n" +
                "                saveAsImage : {show: true}\n" +
                "            }\n" +
                "        },\n" +
                "        roamController: {\n" +
                "            show: true,\n" +
                "            x: 'right',\n" +
                "            mapTypeControl: {\n" +
                "                'china': true\n" +
                "            }\n" +
                "        },\n" +
                "        series : [\n" +
                "            {\n" +
                "                name: 'iphone3',\n" +
                "                type: 'map',\n" +
                "                mapType: 'china',\n" +
                "                roam: false,\n" +
                "                itemStyle:{\n" +
                "                    normal:{label:{show:true}},\n" +
                "                    emphasis:{label:{show:true}}\n" +
                "                },\n" +
                "                data:[\n" +
                "                    {name: '北京',value: 300},\n" +
                "                    {name: '天津',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '上海',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '重庆',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '河北',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '河南',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '云南',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '辽宁',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '黑龙江',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '湖南',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '安徽',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '山东',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '新疆',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '江苏',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '浙江',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '江西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '湖北',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '广西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '甘肃',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '山西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '内蒙古',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '陕西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '吉林',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '福建',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '贵州',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '广东',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '青海',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '西藏',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '四川',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '宁夏',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '海南',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '台湾',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '香港',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '澳门',value: Math.round(Math.random()*1000)}\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                name: 'iphone4',\n" +
                "                type: 'map',\n" +
                "                mapType: 'china',\n" +
                "                itemStyle:{\n" +
                "                    normal:{label:{show:true}},\n" +
                "                    emphasis:{label:{show:true}}\n" +
                "                },\n" +
                "                data:[\n" +
                "                    {name: '北京',value: 200},\n" +
                "                    {name: '天津',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '上海',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '重庆',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '河北',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '安徽',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '新疆',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '浙江',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '江西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '山西',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '内蒙古',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '吉林',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '福建',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '广东',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '西藏',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '四川',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '宁夏',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '香港',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '澳门',value: Math.round(Math.random()*1000)}\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                name: 'iphone5',\n" +
                "                type: 'map',\n" +
                "                mapType: 'china',\n" +
                "                itemStyle:{\n" +
                "                    normal:{label:{show:true}},\n" +
                "                    emphasis:{label:{show:true}}\n" +
                "                },\n" +
                "                data:[\n" +
                "                    {name: '北京',value: 100},\n" +
                "                    {name: '天津',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '上海',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '广东',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '台湾',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '香港',value: Math.round(Math.random()*1000)},\n" +
                "                    {name: '澳门',value: Math.round(Math.random()*1000)}\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        Option option = GsonUtil.fromJSON(StrMap);
        return option;
    }



    @Override
    public void testDB() throws Exception {
        TestTable1 testTable1 = new TestTable1();
        testTable1.setName(String.valueOf(Math.random()));
        testTable1.setText(String.valueOf(Math.random()));
        testTable1Mapper.insert(testTable1);
    }
}
