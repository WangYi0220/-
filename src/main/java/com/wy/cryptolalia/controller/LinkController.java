package com.wy.cryptolalia.controller;

import com.wy.cryptolalia.pojo.Link;
import com.wy.cryptolalia.service.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "增删联系人")
@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @ApiOperation("添加好友")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addLink(String userID, String linkUserID){
        linkService.addLink(userID, linkUserID);
        return true;
    }

    @ApiOperation("是否通过好友请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userID", value = "A用户编号", paramType = "query"),
            @ApiImplicitParam(name = "linkUserID", value = "B用户编号", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "关系状态 0好友未通过 1好友 2删除", paramType = "query")
    })
    @RequestMapping(value = "/link", method = RequestMethod.POST)
    public boolean passLink(Link link){
        linkService.passLink(link);
        return true;
    }
}
