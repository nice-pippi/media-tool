package com.pippi.mediatool.mvc.controller;

import com.pippi.mediatool.common.R;
import com.pippi.mediatool.mvc.vo.TaskVO;
import com.pippi.mediatool.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hong
 * @CreateTime: 2026-02-10
 * @Description: 视频-控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoServiceImpl videoService;

    @GetMapping("/download")
    public R<TaskVO> download(@RequestParam("url") String url) {
        return R.success(videoService.download(url));
    }

}
