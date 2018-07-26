package com.github.yangm.cloud.provider.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.yangm.cloud.provider.model.Book;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.cloud.provider.controller 
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */

@RestController
public class BookController {

	@RequestMapping(value = "/getBookByName")
	public Book getBookByName(@RequestParam(value = "name") String name) {
		Book book = new Book();
		book.setName(name);
		book.setDate(new Date());
		return book;
	}
	
}
