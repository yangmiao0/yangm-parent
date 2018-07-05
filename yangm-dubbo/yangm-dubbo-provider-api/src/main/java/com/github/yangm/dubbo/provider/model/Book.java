package com.github.yangm.dubbo.provider.model;

import java.util.Date;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.rabbitmq.entity 
 * @author: yangm
 * @date: 2018年6月27日 下午3:42:08 
 * @email：1169290944@qq.com
 */
public class Book {
	
	private String name;
	
	private Date date;

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
