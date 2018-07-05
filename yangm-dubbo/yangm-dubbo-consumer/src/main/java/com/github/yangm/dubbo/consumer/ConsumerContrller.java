package com.github.yangm.dubbo.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.yangm.dubbo.provider.model.Book;
import com.github.yangm.dubbo.provider.service.BookService;

/**   
 * 
 * 功能描述：dubbo消费方
 * @Package: com.github.yangm.dubbo.consumer 
 * @author: yangm
 * @date: 2018年7月2日 下午7:53:00 
 * @email：1169290944@qq.com
 */
@RestController
public class ConsumerContrller {

    @Reference(version = "${demo.service.version}")
    //或直接@Reference
	private BookService bookService;
    
    @GetMapping("getBookByName")
    public Book getBookByName(String name) {
    	return bookService.getBookByName(name);
	}
	
}
