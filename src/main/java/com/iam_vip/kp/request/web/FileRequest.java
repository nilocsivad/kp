/**
 * 
 */
package com.iam_vip.kp.request.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.iam_vip.kp.rs.util.DTUtil;
import com.iam_vip.kp.rs.util.MapUtil;

/**
 * /// 文件上传 ///
 * 
 * @author Colin
 */
@Controller
@RequestMapping(value = { "web/file" })
public class FileRequest extends __WebRequest {

	/**
	 * 
	 */
	public FileRequest() {
	}

	/**
	 * /// 文件上传 ///
	 */
	@ResponseBody
	@RequestMapping(value = { "upload_4" }, method = RequestMethod.POST)
	public Map<String, Object> upload_$(MultipartFile file, @RequestParam(defaultValue = "image") String folder,
			HttpServletRequest request) throws Exception {
		return this.upload(file, folder, request);
	}

	/**
	 * /// 文件上传 ///
	 */
	@ResponseBody
	@RequestMapping(value = { "upload" }, method = RequestMethod.POST)
	public Map<String, Object> upload(MultipartFile file, @RequestParam(defaultValue = "image") String folder,
			HttpServletRequest request) throws Exception {

		Map<String, Object> map = MapUtil.mapThem(new String[] { "timelineN" }, DTUtil.nowDT());

		if (file == null || file.isEmpty()) {
			map.put("fileName", "---");
			return map;
		}

		String fileName = super.storageImage(folder, file);
		map.put("fileName", fileName);

		return map;
	}

}
