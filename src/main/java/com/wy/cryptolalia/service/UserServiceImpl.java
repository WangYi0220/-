package com.wy.cryptolalia.service;

import com.wy.cryptolalia.common.util.FileUtils;
import com.wy.cryptolalia.mapper.UserMapper;
import com.wy.cryptolalia.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final String PATH = "headImg/";

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登陆 返回false为用户名/密码错误
     * @param username
     * @param password
     * @return
     */
    @Override
    public Object login(String username, String password) {
        User userFromDB = userMapper.login(username, password);
        if (userFromDB == null) return false;
        userFromDB.setPassword(null);
        return userFromDB;
    }

    /**
     * 用户注册
     * @param user
     * @param file
     * @return false用户名已存在 true注册成功
     */
    @Override
    public boolean register(User user, MultipartFile file) {
        String isExist = userMapper.isExist(user.getUsername());
        if (user.getUsername().equalsIgnoreCase(isExist)) return false;
        if (file != null && !file.isEmpty()){
            String s = FileUtils.fileUP(file, PATH);
            user.setHeadImg(s);
        } else {
            user.setHeadImg("headImg/ba64868cdd3d4c1788d85de28178bddc.png");
        }
        user.setUserID(UUID.randomUUID().toString().replaceAll("-", ""));
        userMapper.register(user);
        return true;
    }

    /**
     * 根据用户编号查找对应的联系人列表
     * @param userID
     * @return
     */
    @Override
    public List<Map<String, Object>> getLinkListByUserID(String userID, int status) {
        return userMapper.getLinkListByUserID(userID, status);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Override
    public Map<String, Object> seekUserByUsername(String username) {
        return userMapper.seekUserByUsername(username);
    }
}
