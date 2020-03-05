package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.*;
import com.briup.apps.cms.mapper.ArticleMapper;
import com.briup.apps.cms.mapper.UserMapper;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.UserService;
import com.briup.apps.cms.util.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-48
 * @Time: 11:48
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        UserExample example = new UserExample();
        example.createCriteria().andUsernameIsNotNull();

        return userMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(User user) {
        if(user.getUsername()!=null){
            userMapper.insert(user);
        }
    }
    @Override
    public void saveOrUpdate(User user) throws CustomerException {
        if(user.getId()==null){
            //保存
            user.setRegisterTime(new Date().getTime());
            user.setStatus("正常");
            userMapper.insert(user);
        }{
            //更新
            userMapper.updateByPrimaryKey(user);
        }

    }

}
