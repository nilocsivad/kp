/**
 * 
 */
package com.iam_vip.kp.request.phone;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iam_vip.kp.rs.c.IAPP;
import com.iam_vip.kp.rs.util.DTUtil;
import com.iam_vip.kp.rs.util.MapUtil;

/**
 * @author Colin
 */
@Controller
@RequestMapping(value = { "phone/he/tong" })
public class HeTongPhoneRequest extends __PhoneRequest implements IAPP {

	/**
	 * 
	 */
	public HeTongPhoneRequest() {
	}

	@ResponseBody
	@RequestMapping(value = { "data.json" })
	public Map<String, Object> data(HttpServletRequest request) throws Exception {
		Map<String, Object> map = MapUtil.mapThem(new String[] { "datetime" }, DTUtil.nowDT());
		
		int len1 = fuJianService.getCountInt(null);
		int len2 = heTongService.getCountInt(null);
		
		map.put("len1", len1);
		map.put("len2", len2);
		
		return map;
	}
}
