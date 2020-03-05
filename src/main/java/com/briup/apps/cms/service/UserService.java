package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.util.CustomerException;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface UserService {
    //查找
    List<User> findAll();

    void deleteById(long id);

    void add(User user);

    void saveOrUpdate(User user) throws CustomerException;

}
