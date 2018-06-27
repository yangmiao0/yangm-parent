package com.github.yangm.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.yangm.common.entity.User;

/**   
 * 
 * 功能描述：
 * @Package: com.github.yangm.mybatis.model 
 * @author: yangm
 * @date: 2018年6月27日 下午12:06:35 
 * @email：1169290944@qq.com
 */
public interface UserMapper {
	
	@Select("select * from user")
	List<User> getUserList();
	
}
