package com.pippi.mediatool.controller;

import com.pippi.mediatool.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/test")
    public R<Boolean> test() {
        return R.success(true);
    }

}
