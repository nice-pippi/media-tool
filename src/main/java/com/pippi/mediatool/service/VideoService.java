package com.pippi.mediatool.service;

import com.pippi.mediatool.mvc.vo.TaskVO;

/**
 * @Author: hong
 * @CreateTime: 2026-02-21
 * @Description: 视频业务层
 * @Version: 1.0
 */
public interface VideoService {

    /**
     * 下载视频
     *
     * @param url 视频地址
     * @return 任务ID
     */
    TaskVO download(String url);

}
