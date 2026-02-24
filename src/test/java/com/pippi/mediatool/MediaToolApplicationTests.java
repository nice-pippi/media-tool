package com.pippi.mediatool;

import com.pippi.mediatool.mvc.co.TaskCO;
import com.pippi.mediatool.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootTest
class MediaToolApplicationTests {

    @MockitoBean
    private ServerEndpointExporter serverEndpointExporter;  // 添加这一行，避免启动失败

    @Autowired
    private VideoService videoService;

    @Test
    void contextLoads() {
        TaskCO taskCO = new TaskCO();
        taskCO.setTaskId("taskId");
        taskCO.setUrl("http://vd3.bdstatic.com/mda-sbkh0bh6cv529nzz/360p/h264/1771675233624462791/mda-sbkh0bh6cv529nzz.mp4");
        videoService.download(taskCO);
    }

}
