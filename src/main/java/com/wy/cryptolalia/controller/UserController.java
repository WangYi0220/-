package com.wy.cryptolalia.controller;

import com.wy.cryptolalia.pojo.User;
import com.wy.cryptolalia.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户登陆 返回false为用户名/密码错误")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String username, String password) {
        return userService.login(username, password);
    }

    @ApiOperation("用户注册 false用户名已存在 true注册成功")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "用户密码", paramType = "query"),
            @ApiImplicitParam(name = "nickname", value = "用户昵称", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "用户电话", paramType = "query"),
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(User user, MultipartFile file){
        return userService.register(user, file);
    }

    @ApiOperation("根据用户编号查找对应的联系人列表 0好友未通过 1好友 2删除")
    @RequestMapping(value = "/list/{userID}/{status}", method = RequestMethod.GET)
    List<Map<String, Object>> getLinkListByUserID(@PathVariable("userID") String userID, @PathVariable("status") int status){
        return userService.getLinkListByUserID(userID, status);
    }

    @ApiOperation("根据用户名查找用户")
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    Map<String, Object> seekUserByUsername(@PathVariable("username") String username){
        return userService.seekUserByUsername(username);
    }
}
