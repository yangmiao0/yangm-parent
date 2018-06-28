package com.github.yangm.dynamic.dbrouting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ChooseDataSource extends AbstractRoutingDataSource {
	
	private static Logger log = LoggerFactory.getLogger(ChooseDataSource.class);
	
	@Override
	protected Object determineCurrentLookupKey() {
		String datasourceKey = HandleDataSource.getDataSource();
		if (datasourceKey == null)
			log.debug("选择默认数据库");
		else
			log.debug("选择key={}的数据库", datasourceKey);
		return datasourceKey;
	}
}
