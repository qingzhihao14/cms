package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.util.CustomerException;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface PrivilegeService {
    //查找
    List<Privilege> findAll();

    void deleteById(long id);

    void add(Privilege privilege);

    void saveOrUpdate(Privilege privilege) throws CustomerException;
}
