package com.github.yangm.mybatisplus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.github.yangm.mybatisplus.beans.CarInfo;
import com.github.yangm.mybatisplus.page.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangm
 * @since 2018-06-28
 */
public interface CarInfoService extends IService<CarInfo> {
	
	/**
	 * 分页获取车辆列表
	 * @param user
	 * @return
	 */
	Page<CarInfo> getCarInfoPage(PageInfo<CarInfo> page);
}
