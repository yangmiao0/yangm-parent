package com.github.yangm.cloud.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.yangm.cloud.provider.model.Book;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.cloud.provider.service
 * @author: yangm
 * @date: 2018年7月26日
 * @email：1169290944@qq.com
 */
@FeignClient(value = "cloud-provider")
public interface BookService {
	
	@RequestMapping(value = "/getBookByName")
	Book getBookByName(@RequestParam(value = "name") String name);
	
}
