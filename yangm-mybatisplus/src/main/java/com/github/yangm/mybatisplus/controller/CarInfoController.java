package com.github.yangm.mybatisplus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.yangm.mybatisplus.beans.CarInfo;
import com.github.yangm.mybatisplus.dao.CarInfoMapper;
import com.github.yangm.mybatisplus.page.PageInfo;
import com.github.yangm.mybatisplus.service.CarInfoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangm
 * @since 2018-06-28
 */
@RestController
@RequestMapping("/carInfo")
public class CarInfoController {

	private static final Logger log = LoggerFactory.getLogger(CarInfoController.class);
	
	@Autowired
	CarInfoService carInfoService;
	@Autowired
	CarInfoMapper carInfoMapper;
	
	@RequestMapping("/getCarInfoById")
	//@Transactional
	public CarInfo getCarInfoById(Long id) {
		CarInfo carInfo = new CarInfo();
		carInfo.setOpenId("bbbbb");
		carInfo.setId(3L);
		carInfoService.updateById(carInfo);
		//int i = 1/0;
		//测试从库
		log.info(carInfoMapper.getSlaveDate().toString());
		
		return carInfoService.selectById(id);
	}
	
	/**
	 * 分页示例
	 * @param pageInfo
	 * @return
	 */
	@RequestMapping("/getCarInfoPage")
	public Page<CarInfo> getCarInfoPage(PageInfo<CarInfo> pageInfo) {
		//如果key=value入参默认value值都是string类型 注意params条件参数类型转换 json字符串入参可不管
		return carInfoService.getCarInfoPage(pageInfo);
	}
	
	
}

