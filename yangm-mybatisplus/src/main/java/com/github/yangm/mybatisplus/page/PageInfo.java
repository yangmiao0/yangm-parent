package com.github.yangm.mybatisplus.page;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;

/**   
 * 
 * 功能描述：获取入参条件参数
 * @Package: com.cheyouhui.common.page 
 * @author: yang
 * @date: 2018年6月2日 下午12:10:55 
 */
public class PageInfo<T> extends Page<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4930175256977508191L;
	
	

	private Map<String, Object> params = new HashMap<>();


	public Map<String, Object> getParams() {
		return params;
	}


	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
    
    @Override
    public String toString() {
        StringBuilder pg = new StringBuilder();
        pg.append(" PageInfo:{ [").append(super.toString()).append("], ");
        pg.append("params=").append(params.toString());
        return pg.append(" }").toString();
    }

}
