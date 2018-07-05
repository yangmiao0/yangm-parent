package com.github.yangm.common.entity;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**   
 * 
 * 功能描述：使用lombok框架插件 自动生成get set等 IDE需安装插件
 * @Package: com.github.yangm.rabbitmq.entity 
 * @author: yangm
 * @date: 2018年6月27日 下午3:42:08 
 * @email：1169290944@qq.com
 */
@Data
@Accessors(chain=true)
public class Book {
	
	private String name;
	
	private Date date;
}
