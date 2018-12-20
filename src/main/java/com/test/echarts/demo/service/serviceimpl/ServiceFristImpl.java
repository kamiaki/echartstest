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
import com.test.echarts.demo.service.ServiceFrist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceFristImpl implements ServiceFrist {
    public static void main(String[] args) {
    }

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
        return null;
    }
}
