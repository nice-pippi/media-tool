package com.pippi.mediatool.constant;

import java.io.File;

/**
 * @Author: hong
 * @CreateTime: 2026-02-24
 * @Description:
 * @Version: 1.0
 */
public class FilePathConstant {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;
    private static final String TEMP_DIR = "temp";

    public static final String VIDEO_TEMP_PATH = USER_DIR + SEPARATOR + TEMP_DIR + SEPARATOR + "video" + SEPARATOR;

}
