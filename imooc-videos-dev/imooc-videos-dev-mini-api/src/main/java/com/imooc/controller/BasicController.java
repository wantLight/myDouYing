package com.imooc.controller;

import com.imooc.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xyzzg on 2018/8/10.
 *
 * 路径未修改前，服务器会在tomcat/bin/D:imooc_dev/下创建？
 */
@RestController
public class BasicController {


    @Autowired
    public RedisOperator redis;

    public static final String USER_REDIS_SESSION = "user-redis-session";

    //public static final String FFMPEG_EXE = "D:\\ffmpeg\\bin\\ffmpeg.exe";

    public static final String FFMPEG_EXE = "/usr/bin/ffmpeg";

    //public static final String FILE_SPACE = "D:\\imooc_videos_dev";

    public static final String FILE_SPACE = "/home/imooc_videos_dev";

    public static final Integer PAGE_SIZE = 5;

    //public static final String UPLOAD_PATHDB = "";
}
