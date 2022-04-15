package com.mean.greentea.controller;

import cn.hutool.json.JSONObject;
import com.mean.greentea.entity.User;
import com.mean.greentea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param user
     * @return 登录成功体
     */
    @PostMapping
    public ResponseEntity<JSONObject> login(@RequestBody User user)
    {
        JSONObject result = new JSONObject();
        int res = userService.login(user, result);
        if(res != 1)
        {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
