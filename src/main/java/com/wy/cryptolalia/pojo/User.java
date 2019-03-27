package com.wy.cryptolalia.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class User implements Serializable {
    private String userID;
    private String headImg;
    private String username;
    private String password;
    private String nickname;
    private String phone;
}
