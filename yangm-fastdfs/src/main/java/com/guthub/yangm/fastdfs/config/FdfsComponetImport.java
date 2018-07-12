package com.guthub.yangm.fastdfs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import com.github.tobato.fastdfs.FdfsClientConfig;

/**   
 * 
 * 功能描述：
 * @Package: com.guthub.yangm.fastdfs 
 * @author: yangm
 * @date: 2018年7月11日
 * @email：1169290944@qq.com
 */
@Configuration
@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FdfsComponetImport {

}
