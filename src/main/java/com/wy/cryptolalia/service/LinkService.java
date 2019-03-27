package com.wy.cryptolalia.service;

import com.wy.cryptolalia.pojo.Link;

public interface LinkService {
    void addLink(String userID, String linkUserID);

    void passLink(Link link);
}
