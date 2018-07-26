package com.github.yangm.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yangm.cloud.provider.model.Book;
import com.github.yangm.cloud.provider.service.BookService;


/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.cloud.consumer.controller 
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private BookService bookService;
	
    @GetMapping("getBookByName")
    public Book getBookByName(String name) {
    	return bookService.getBookByName(name);
	}
    
}
