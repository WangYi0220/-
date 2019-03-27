package com.wy.cryptolalia.service;

import com.wy.cryptolalia.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface UserService {
    Object login(String username, String password);

    boolean register(User user, MultipartFile file);

    List<Map<String, Object>> getLinkListByUserID(String userID, int status);

    Map<String, Object> seekUserByUsername(String username);
}
