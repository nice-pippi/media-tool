package com.pippi.mediatool.pojo;

import com.pippi.mediatool.enums.FileTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: hong
 * @CreateTime: 2026-02-24
 * @Description:
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadTask {

    private String taskId;

    private boolean completed;

    private FileTypeEnum fileType;

    private String filePath;

    private LocalDateTime createTime;

    public static DownloadTask of(String taskId, FileTypeEnum fileType, String filePath) {
        return new DownloadTask(taskId, false, fileType, filePath, LocalDateTime.now());
    }

}
