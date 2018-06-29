package com.github.yangm.mybatisplus.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**   
 * 
 * 功能描述：代码生成器 包括service和controller
 * @Package: com.github.yangm.mybatisplus.util 
 * @author: yangm
 * @date: 2018年6月28日 上午10:13:33 
 * @email：1169290944@qq.com
 */
public class MyBatisPlusGenerator {

	/**
	 * 代码生成    示例代码
	 */
	@Test
	public void  myBatisPlusGenerator() {
		
		//可多个表名
		String[] tableNames = {"car_info"};
		
		String outputDir = "D:\\eclipse-workspace3\\yangm-parent\\yangm-mybatisplus";
		
		//1. 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false) // 是否支持AR模式
			  .setAuthor("yangm") // 作者
			  .setOutputDir(outputDir + "\\src\\main\\java") // 生成路径
			  .setFileOverride(true)  // 文件覆盖
			  .setIdType(IdType.AUTO) // 主键策略
			  .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
			  .setEnableCache(false)// XML 二级缓存
 			  .setBaseResultMap(true)// XML ResultMap
 			  .setBaseColumnList(true);// XML columList
		
		//2. 数据源配置
		DataSourceConfig  dsConfig  = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://localhost:3306/test")
				.setUsername("root")
				.setPassword("123456");
		 
		//3. 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) //全局大写命名
				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				//.setSuperControllerClass("com.baomidou.demo.TestController")//自定义 controller 父类
				//.setTablePrefix("tbl_")	// 表前缀
				.setInclude(tableNames);  // 生成的表
		
		//4. 包名策略配置 
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.github.yangm.mybatisplus")
				.setMapper("dao")
				.setService("service")
				.setController("controller")
				//.setXml("dao.mapper")
				.setEntity("beans");
		
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 mapper 生成路径
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return outputDir + "\\src\\main\\resources\\mapping\\" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        
        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        
		//5. 整合配置
		AutoGenerator  ag = new AutoGenerator();
		ag.setGlobalConfig(config)
		  .setDataSource(dsConfig)
		  .setStrategy(stConfig)
		  .setPackageInfo(pkConfig)
		  .setCfg(cfg)
		  .setTemplate(tc);
		
		//6. 执行
		ag.execute();
	}
	
}
