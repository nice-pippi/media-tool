package com.pippi.mediatool;

import com.pippi.mediatool.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediaToolApplicationTests {

    @Autowired
    private VideoService videoService;

    @Test
    void contextLoads() {
        String url = "http://vd3.bdstatic.com/mda-sbkh0bh6cv529nzz/360p/h264/1771675233624462791/mda-sbkh0bh6cv529nzz.mp4";
        String outputPath = "D:\\desktop\\";
        System.out.println(videoService.download(url, outputPath));
    }

}
