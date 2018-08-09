package com.github.yangm.swagger.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * 功能描述：
 * @Package: com.github.yangm.swagger.Bean
 * @author: yangm
 * @date: 2018年8月9日
 * @email：1169290944@qq.com
 */
@ApiModel()
@Data
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty(hidden=true)
    private Long id;
    
    @ApiModelProperty(value="书名")
    private String Name;
    
}
