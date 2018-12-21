package com.test.echarts.demo.dao;

import com.test.echarts.demo.po.TestTable1;
import com.test.echarts.demo.po.TestTable1Example;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestTable1Mapper {
    int countByExample(TestTable1Example example);

    int deleteByExample(TestTable1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestTable1 record);

    int insertSelective(TestTable1 record);

    List<TestTable1> selectByExample(TestTable1Example example);

    TestTable1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestTable1 record, @Param("example") TestTable1Example example);

    int updateByExample(@Param("record") TestTable1 record, @Param("example") TestTable1Example example);

    int updateByPrimaryKeySelective(TestTable1 record);

    int updateByPrimaryKey(TestTable1 record);
}