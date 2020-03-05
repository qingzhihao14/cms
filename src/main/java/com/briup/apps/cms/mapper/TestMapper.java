package com.briup.apps.cms.mapper;

import com.briup.apps.cms.bean.Test;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-44
 * @Time: 11:44
 * @Description:注解适合单表操作
 */
public interface TestMapper {
    //Dao层写完了
    @Select("select * from test")
    public List<Test> selectAll();

    //不允许name同名
    @Select("select * from test where name=#{name}")
    public Test selectByName(String name);

    @Delete("delete from test where id=#{id}")
    void deleteById(Long id);

    //保存
    @Insert("insert into test values(null,#{name},#{age})")
    void insert(Test test);
    //更新
    @Update("update test name=#{name},age=#{age} where id=#{id}")
    void update(Test test);



}
