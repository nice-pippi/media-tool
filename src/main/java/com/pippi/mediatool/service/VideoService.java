package com.pippi.mediatool.service;

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
    String download(String url);

}
