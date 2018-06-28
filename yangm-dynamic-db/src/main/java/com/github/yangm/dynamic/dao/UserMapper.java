package com.github.yangm.dynamic.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.github.yangm.common.entity.User;
import com.github.yangm.dynamic.dbrouting.DataSource;
import com.github.yangm.dynamic.dbrouting.DataSourceType;

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
	
	@DataSource(DataSourceType.READ)
	@Select("select * from sys_user")
	List<Map<String,Object>> getSlaveDate();
}
