package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.util.CustomerException;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface RoleService {
    //查找
    List<Role> findAll();

    void deleteById(long id);

    void add(Role role);

    void saveOrUpdate(Role role) throws CustomerException;

}
