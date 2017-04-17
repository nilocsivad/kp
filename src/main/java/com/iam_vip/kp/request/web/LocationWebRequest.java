/**
 * 
 */
package com.iam_vip.kp.request.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iam_vip.kp.rs.util.LocationUtil;
import com.iam_vip.kp.rs.util.LocationUtil.Location;

/**
 * @author Colin
 */
@Controller
@RequestMapping(value = { "web/location" })
public final class LocationWebRequest extends __WebRequest {

	/**
	 * 
	 */
	public LocationWebRequest() {
	}

	@ResponseBody
	@RequestMapping(value = { "data4.json" })
	public List<Location> data_$(@RequestParam(defaultValue = "0") int ic, HttpServletRequest request) {
		return this.data(ic, request);
	}

	@ResponseBody
	@RequestMapping(value = { "data.json" })
	public List<Location> data(@RequestParam(defaultValue = "0") int ic, HttpServletRequest request) {
		return LocationUtil.getData(ic);
	}

}
