package com.wy.cryptolalia.mapper;

import com.wy.cryptolalia.pojo.Link;
import org.apache.ibatis.annotations.Param;

public interface LinkMapper {
    void addLink(@Param("userID") String userID, @Param("linkUserID") String linkUserID);

    void passLink(Link link);
}
