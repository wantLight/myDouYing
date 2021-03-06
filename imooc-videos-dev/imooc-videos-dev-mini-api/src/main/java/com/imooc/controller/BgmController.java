package com.imooc.controller;

import com.imooc.service.BgmService;
import com.imooc.utils.IMoocJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xyzzg on 2018/8/12.
 */
@RestController
@RequestMapping("/bgm")
@Api(value = "Bgm选择接口",tags = {"Bgm选择业务的controller"})
public class BgmController {

    @Autowired
    private BgmService bgmService;

    @PostMapping("/list")
    @ApiOperation(value = "获取背景音乐",notes = "获取背景音乐列表接口")
    public IMoocJSONResult list(){
        return IMoocJSONResult.ok(bgmService.queryBgmList());
    }
}
