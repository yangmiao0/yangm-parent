package com.guthub.yangm.fastdfs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tobato.fastdfs.domain.StorePath;
import com.guthub.yangm.fastdfs.service.FdfsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(FdfsApplicationTests.class);
	
	@Autowired
	FdfsService fdfsService;
	
	@Test
	public void contextLoads() {
		StorePath storePath = fdfsService.uploadFile("C:\\Users\\Administrator\\Desktop\\TIM截图20180709110310.png");
		log.info("返回路径信息 storePath={}",storePath.toString());
		fdfsService.downLoad(storePath.getGroup(),storePath.getPath(),"D:\\tup.png");
	}

}
