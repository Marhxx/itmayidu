package com.spring.api.config;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 每天早上六点评价上个星期当天的未评价订单
 * @author Administrator
 *
 */
@Component
public class ScheduledRun {
	 private static final Logger logger = LoggerFactory.getLogger(ScheduledRun.class);
	 
	 
	//@Scheduled(fixedDelay = 5000)测试五秒执行一次
	//@Scheduled(cron = "0 0 8 ? * MON")
	 @Scheduled(cron = "0 0 6 * * ?")
	 public void testTaskWithDate() {
		logger.info("=========>>>>>>开始评价未评价的订单");
		long startTime=System.currentTimeMillis();
		int count=0;
		try {
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		long endTime=System.currentTimeMillis();
		logger.info("=========>>>>>>评价完成总耗时:"+(endTime-startTime)/1000+"秒;系统评价订单数:"+count+"条");
	 }
	
	
}
