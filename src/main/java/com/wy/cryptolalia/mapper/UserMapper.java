package com.wy.cryptolalia.mapper;

import com.wy.cryptolalia.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);

    void register(User user);

    List<Map<String, Object>> getLinkListByUserID(@Param("userID") String userID, @Param("status") int status);

    String isExist(@Param("username") String username);

    Map<String, Object> seekUserByUsername(@Param("username") String username);
}
