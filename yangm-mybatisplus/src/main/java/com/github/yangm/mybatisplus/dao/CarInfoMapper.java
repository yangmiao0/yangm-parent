package com.github.yangm.mybatisplus.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.DS;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.github.yangm.mybatisplus.beans.CarInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangm
 * @since 2018-06-28
 */
public interface CarInfoMapper extends BaseMapper<CarInfo> {

	@DS//根据DynamicDataSourceStrategy策略，选择一个从库。默认负载均衡策略
	//@DS("one")
	@Select("select * from sys_user limit 1")
	Map<String,Object> getSlaveDate();
	
	/**
	 * 分页查询列表
	 * @param page
	 * @param user
	 * @return
	 */
	 public List<CarInfo> getCarInfoPage(Pagination page,Map<String, Object> params);
	
}
