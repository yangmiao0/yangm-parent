package com.github.yangm.swagger.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.yangm.swagger.bean.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.swagger.controller 
 * @author: yangm
 * @date: 2018年8月9日
 * @email：1169290944@qq.com
 */
@Api(value = "Swagger接口", tags = "Swagger接口")
@RestController
@RequestMapping("/swaggerBook")
public class SwaggerController {

	@ApiOperation(value="获取book", notes="获取book",consumes="application/x-www-form-urlencoded")
	@ApiImplicitParam(name = "book", value = "实体book", dataType = "Book",paramType="form")
	@PostMapping("/getBook")
	public Book get(Book book) {
		return book;
	}
	
}
