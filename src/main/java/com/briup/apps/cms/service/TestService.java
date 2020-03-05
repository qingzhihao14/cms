package com.briup.apps.cms.service;
import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.util.CustomerException;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-46
 * @Time: 11:46
 * @Description:
 */
//service层面向接口变成

/**
 * 如果test中包含id则为修改，不包含则为保存
 *
 *
 * Hibernate
 *      {name:"tom",age:12"}
 *  瞬态：对象在数据库中没有对应的记录（id）(一般是修改，更新操作)
 *      {id:1,name:"tom",age:12"}
 *  持久态 ：对象在数据库中有对应的记录(直接保存)
 *  游离态
 */
public interface TestService {

    List<Test> findAll();

    void deleteById(Long id);

    void saveOrUpdate(Test test) throws CustomerException;

}

