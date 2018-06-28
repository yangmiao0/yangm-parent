package com.github.yangm.mybatisplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.yangm.mybatisplus.beans.CarInfo;
import com.github.yangm.mybatisplus.dao.CarInfoMapper;
import com.github.yangm.mybatisplus.page.PageInfo;
import com.github.yangm.mybatisplus.service.CarInfoService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangm
 * @since 2018-06-28
 */
@Service
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfo> implements CarInfoService {

	
	@Autowired
	CarInfoMapper carInfoMapper;
	
	/**
	 * 分页获取车辆列表
	 * @param user
	 * @return
	 */
    @Override
	public Page<CarInfo> getCarInfoPage(PageInfo<CarInfo> page) {
		return page.setRecords(carInfoMapper.getCarInfoPage(page,page.getParams()));
	}
	
}
