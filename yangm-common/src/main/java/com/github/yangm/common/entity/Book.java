package com.github.yangm.common.entity;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**   
 * 
 * 功能描述：
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
