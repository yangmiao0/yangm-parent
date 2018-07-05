package com.github.yangm.common.entity;

import lombok.Data;

/**   
 * 
 * 功能描述：使用lombok框架插件 自动生成get set等 IDE需安装插件
 * @Package: com.github.yangm.mybatis.model 
 * @author: yangm
 * @date: 2018年6月27日 下午12:06:35 
 * @email：1169290944@qq.com
 */

@Data
public class User{

	private Integer id;
	
	private String name;

	private Integer age;
	
}
