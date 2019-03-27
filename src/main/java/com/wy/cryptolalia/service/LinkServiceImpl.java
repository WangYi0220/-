package com.wy.cryptolalia.service;

import com.wy.cryptolalia.mapper.LinkMapper;
import com.wy.cryptolalia.pojo.Link;
import com.wy.cryptolalia.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private WebSocketServer webSocketServer;

    /**
     * 添加好友
     * @param userID
     * @param linkUserID
     */
    @Override
    public void addLink(String userID, String linkUserID) {
        linkMapper.addLink(userID, linkUserID);
        webSocketServer.sendMessage(userID, linkUserID, "请求添加好友");
    }

    /**
     * 是否通过好友请求
     * @param link
     */
    @Override
    public void passLink(Link link) {
        linkMapper.passLink(link);
    }

}
