package com.mean.greentea.service.Impl;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import com.mean.greentea.dao.UserMapper;
import com.mean.greentea.entity.User;
import com.mean.greentea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int login(User user, JSONObject result) {
        User userLogin = new User();
        try {
            userLogin = userMapper.login(user);
        } catch (JSONException e)
        {
            result.set("msg", "服务器错误");
            return 2;
        }
        if(userLogin == null)
        {
            result.set("msg", "用户名或密码错误");
        }
        else if(userLogin != null)
        {
            result.set("msg", "success");
        }
        return 1;
    }
}
