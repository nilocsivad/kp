/**
 * 
 */
package com.iam_vip.kp.rs.quartz.job;

import org.springframework.web.context.support.WebApplicationObjectSupport;

import com.iam_vip.kp.rs.util.DTUtil;

/**
 * 定时调用工具类
 * @author Colin
 */
public class SchedulerTaskJob extends WebApplicationObjectSupport {

	/**
	 * 
	 */
	public SchedulerTaskJob() {
	}

	/**
	 * 定时调用的方法
	 */
	public void doTask() {

		System.out.println("Scheduler execute --> " + DTUtil.nowDT());
		
	}

}
