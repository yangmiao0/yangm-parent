package com.github.yangm.dubbo.provider.service.impl;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.yangm.dubbo.provider.model.Book;
import com.github.yangm.dubbo.provider.service.BookService;

/**   
 * 
 * 功能描述：提供方
 * @Package: com.github.yangm.dubbo.provider.service.impl
 * @author: yangm
 * @date: 2018年7月2日 上午10:54:58 
 * @email：1169290944@qq.com
 */
@Service(version = "${demo.service.version}",
		interfaceClass = BookService.class)
//或直接@Service
@Component
public class BookServiceImpl implements BookService {
	
	@Override
	public Book getBookByName(String name) {
		Book book = new Book();
		book.setName(name);
		book.setDate(new Date());
		return book;
	}

}
