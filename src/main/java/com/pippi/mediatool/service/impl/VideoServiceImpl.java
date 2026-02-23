package com.pippi.mediatool.service.impl;

import com.pippi.mediatool.exception.BusinessException;
import com.pippi.mediatool.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hong
 * @CreateTime: 2026-02-21
 * @Description: 视频业务层-实现
 * @Version: 1.0
 */
@Slf4j
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private FFmpeg ffmpeg;

    @Autowired
    private FFprobe ffprobe;

    @Override
    public String download(String url, String outputPath) {
        String fileName = null;
        try {
            // 确保输出目录存在
            Files.createDirectories(Paths.get(outputPath));

            // 获取视频源信息
            FFmpegProbeResult in = ffprobe.probe(url);

            // 随机文件名
            fileName = outputPath + UUID.randomUUID() + ".mp4";

            // 构建FFmpeg命令参数
            FFmpegBuilder builder = new FFmpegBuilder()
                    .setInput(url)
                    .addOutput(fileName)
                    .setAudioCodec("copy")
                    .setVideoCodec("copy")
                    .done();

            // 创建FFmpeg执行器
            FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

            // 创建下载任务并设置进度监听器
            FFmpegJob job = executor.createJob(builder, new ProgressListener() {
                // 获取视频总时长（纳秒）
                final double duration_ns = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

                @Override
                public void progress(Progress progress) {
                    // 计算下载进度百分比
                    int percentage = (int) Math.round(progress.out_time_ns / duration_ns * 100);

                    log.info("下载进度: {}%", percentage);
                }
            });

            // 异步执行下载任务
            CompletableFuture.runAsync(job);

            return fileName;
        } catch (IOException e) {
            log.error("下载视频异常：{}", e.getMessage());
            throw new BusinessException("下载视频异常");
        }
    }
}