package com.github.yangm.dubbo.provider.service;

import com.github.yangm.dubbo.provider.model.Book;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.dubbo.provider.service 
 * @author: yangm
 * @date: 2018年7月2日 上午10:50:24 
 * @email：1169290944@qq.com
 */
public interface BookService {
	
	Book getBookByName(String name);
	
}
