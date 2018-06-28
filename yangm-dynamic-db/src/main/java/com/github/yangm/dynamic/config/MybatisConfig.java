package com.github.yangm.dynamic.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.yangm.dynamic.config.properties.MasterDruidProperties;
import com.github.yangm.dynamic.config.properties.SlaveDruidProperties;
import com.github.yangm.dynamic.dbrouting.ChooseDataSource;


/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.dynamic.config 
 * @author: yangm
 * @date: 2018年6月28日 下午3:07:09 
 * @email：1169290944@qq.com
 */
@Configuration
@MapperScan("com.github.yangm.dynamic.dao")
public class MybatisConfig {

    @Autowired
    MasterDruidProperties masterDruidProperties;
    @Autowired
    SlaveDruidProperties slaveDruidProperties;
    
    /**
     * 初始化数据源
     * @return
     */
    @Bean
    public ChooseDataSource dataSource() {
        DruidDataSource dataSourceWrite = new DruidDataSource();
        masterDruidProperties.coinfig(dataSourceWrite);
        try {
			dataSourceWrite.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
        DruidDataSource dataSourceRead = new DruidDataSource();
        slaveDruidProperties.coinfig(dataSourceRead);
        try {
        	dataSourceRead.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        Map<Object,Object> map = new HashMap<>();
        map.put("write", dataSourceWrite);
        map.put("read", dataSourceRead);
        ChooseDataSource chooseDataSource = new ChooseDataSource();
        chooseDataSource.setTargetDataSources(map);
        chooseDataSource.setDefaultTargetDataSource(dataSourceWrite);
        
        return chooseDataSource;
    }
}
