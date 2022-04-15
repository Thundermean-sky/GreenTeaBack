package com.mean.greentea.service;

import cn.hutool.json.JSONObject;
import com.mean.greentea.entity.User;

public interface UserService {
    /**
     * 登录
     * @param user
     * @param result
     * @return 成功登录结果
     */
    int login(User user, JSONObject result);
}
