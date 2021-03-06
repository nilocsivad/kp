/**
 * 
 */
package com.iam_vip.kp.request;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

import com.iam_vip.kp.logic.model.__Model;
import com.iam_vip.kp.rs.c.IAPP;
import com.iam_vip.kp.rs.ref.RandomString;
import com.iam_vip.kp.rs.util.ConstUtil;
import com.iam_vip.kp.rs.util.MapUtil;
import com.iam_vip.kp.rs.util.StringUtil;

/**
 * @author Colin
 */
public class __Request implements IAPP {

	protected static final String REDIRECT = "redirect:";

	/**
	 * 
	 */
	public __Request() {
	}

	private RequestContext reqCtx;




	protected String getMessage(HttpServletRequest request, String key) {
		if (reqCtx == null) {
			reqCtx = new RequestContext(request);
		}
		return reqCtx.getMessage(key);
	}

	public Map<String, Object> queryLimit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put(JSON_KEY, this.getClass().getName());
		// map.put(JSON_RESULT_KEY, System.getenv());
		{
			Map<String, Object> extra = new HashMap<String, Object>(8);
			// extra.put("", );
			extra.put("webapp.root", System.getProperty("webapp.root"));
			// extra.put("package_name", System.getProperty("package_name"));
			// extra.put("file_name", System.getProperty("file_name"));
			// extra.put("project_name", System.getProperty("project_name"));
			// extra.put("time", System.getProperty("time"));
			// {
			// Properties props = System.getProperties();
			// props.forEach((key, value) -> {
			// extra.put(key.toString(), value);
			// });
			// }
			map.put(JSON_RESULT, extra);
		}
		return map;
	}

	protected boolean existsText(HttpServletRequest request, String find) {
		String uri = request.getRequestURI();
		return uri.indexOf(find) > 0;
	}

	protected String getSuffixOfURL(HttpServletRequest request, String find) {
		String uri = request.getRequestURI();
		if (uri.contains(";")) {
			uri = uri.substring(0, uri.indexOf(";"));
		}
		return uri.substring(uri.indexOf(find) + find.length());
	}

	protected String getHttpProj(HttpServletRequest request) {
		int port = request.getServerPort();
		String http = request.getServerName() + (port == 80 ? "" : ":" + port) + "/" + request.getContextPath() + "/";
		return request.getScheme() + "://" + http.replace("//", "/");
	}

	protected String getHttpResource(HttpServletRequest request) {
		int port = request.getServerPort();
		String http = request.getServerName() + (port == 80 ? "" : ":" + port) + "/" + ConstUtil.getResourcePrefix() + "/";
		return request.getScheme() + "://" + http.replace("//", "/");
	}

	protected void translateData(Map<String, Object> map, int from, String[] columns, List<?> listData) {
		this.translateData(map, from, columns, JSON_RESULT, listData);
	}

	protected void translateData(Map<String, Object> map, int from, String[] columns, String key, List<?> listData) {
		try {
			map.put(key, MapUtil.toMapList2(from, listData, columns));
		}
		catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			map.put(key, listData);
			e.printStackTrace();
		}
	}

	protected void translateData(Map<String, Object> map, int from, String[] columns, __Model oneData) {
		this.translateData(map, from, columns, JSON_RESULT, oneData);
	}

	protected void translateData(Map<String, Object> map, int from, String[] columns, String key, __Model oneData) {
		try {
			map.put(key, MapUtil.toMap2(from, oneData, columns));
		}
		catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			map.put(key, oneData);
			e.printStackTrace();
		}
	}

	protected String suffix(String file) {
		int index = file.lastIndexOf(".");
		if (index < 0) {
			return "";
		}
		return file.substring(index);
	}
	
	protected String storageImage(String folder, MultipartFile file) throws FileNotFoundException, IOException {

		folder = StringUtil.toPath(folder);

		String folderPath = ConstUtil.getResourcePath(); /// E:\resource or /appdata/resource
		File folderRes = new File(folderPath, folder);
		if (folderRes.exists() == false) {
			folderRes.mkdirs();
		}
		
		String suffix = this.suffix(file.getOriginalFilename());

		String fileName = String.format("%014Xd-%s%s", System.currentTimeMillis(), new RandomString(14), suffix);
		File fileImage = new File(folderRes, fileName);

		file.transferTo(fileImage);

		return folder + "/" + fileName;
	}

	protected String storageImage(String folder, InputStream imageStream, String suffix) throws FileNotFoundException, IOException {

		folder = StringUtil.toPath(folder);

		String folderPath = ConstUtil.getResourcePath(); /// E:\resource or /appdata/resource
		File folderRes = new File(folderPath, folder);
		if (folderRes.exists() == false) {
			folderRes.mkdirs();
		}


		String fileName = String.format("%014Xd-%s%s", System.currentTimeMillis(), new RandomString(14), suffix);
		File fileImage = new File(folderRes, fileName);

		BufferedInputStream input = new BufferedInputStream(imageStream);
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileImage));
		int len = 0;
		byte[] buf = new byte[1024 * 24]; /// 24k ///
		while ((len = input.read(buf)) > 0) {
			output.write(buf, 0, len);
		}
		input.close();
		output.close();

		return folder + "/" + fileName;
	}

}
