/**
 * 
 */
package com.iam_vip.kp.logic.api.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestContext;

import com.iam_vip.kp.database.access.layout.IDAO;
import com.iam_vip.kp.logic.iapi.__IAPI;
import com.iam_vip.kp.logic.model.__Model;
import com.iam_vip.kp.rs.ref.DataGridModel;
import com.iam_vip.kp.rs.ref.RandomString;
import com.iam_vip.kp.rs.util.ConstUtil;
import com.iam_vip.kp.rs.util.MapUtil;
import com.iam_vip.kp.rs.util.StringUtil;

/**
 * @author Colin
 * @param <T>
 */
public abstract class __APIDefaultImpl<T> implements __IAPI<T> {

	/**
	 * 
	 */
	public __APIDefaultImpl() {
	}

	protected abstract IDAO<T> getDAO();

	protected abstract String getPrefixOfSqlMapID();

	private RequestContext reqCtx;




	protected String getMessage(HttpServletRequest request, String key) {
		if (reqCtx == null) {
			reqCtx = new RequestContext(request);
		}
		return reqCtx.getMessage(key);
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

	protected int toInt(String txt) {
		return Integer.parseInt(txt);
	}

	protected Float toFt(String txt) {
		return Float.parseFloat(txt);
	}

	protected double toDb(String txt) {
		return Double.parseDouble(txt);
	}

	protected String suffix(String file) {
		int index = file.lastIndexOf(".");
		if (index < 0) {
			return "";
		}
		return file.substring(index);
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







	@Override
	public Object save(T model) {
		return this.save(this.getPrefixOfSqlMapID() + "save", model);
	}

	public Object save(String sqlMapID, Object model) {
		return this.getDAO().save(sqlMapID, model);
	}

	@Override
	public Object saveMulti(String sqlMapID, Object obj) {
		return this.getDAO().saveMulti(sqlMapID, obj);
	}

	@Override
	public Integer saveReturnInt(T model) {
		return this.saveReturnInt(this.getPrefixOfSqlMapID() + "saveReturnInt", model);
	}

	public Integer saveReturnInt(String sqlMapID, T model) {
		return this.getDAO().saveReturnInt(sqlMapID, model);
	}

	@Override
	public Long saveReturnLong(T model) {
		return this.saveReturnLong(this.getPrefixOfSqlMapID() + "saveReturnLong", model);
	}

	public Long saveReturnLong(String sqlMapID, T model) {
		return this.getDAO().saveReturnLong(sqlMapID, model);
	}

	@Override
	public int update(T model) {
		return this.update(this.getPrefixOfSqlMapID() + "update", model);
	}

	@Override
	public int update(String sqlMapID, Object obj) {
		return this.getDAO().update(sqlMapID, obj);
	}

	@Override
	public int delete(T model) {
		return this.delete(this.getPrefixOfSqlMapID() + "delete", model);
	}

	@Override
	public int delete(String sqlMapID, Object obj) {
		if (obj == null) {
			return 0;
		}
		return this.getDAO().delete(sqlMapID, obj);
	}
	
	@Override
	public T getOneByPK(String[] columns, Object obj) {
		return this.getOneByPK(__Model.cols2(columns), obj);
	}

	@Override
	public T getOneByPK(String columns, Object obj) {
		return this.getOne(columns, this.getPrefixOfSqlMapID() + "getOneByPK", obj);
	}
	
	@Override
	public T getOne(String[] columns, Object obj) {
		return this.getOne(__Model.cols2(columns), obj);
	}

	@Override
	public T getOne(String columns, Object obj) {
		return this.getOne(columns, this.getPrefixOfSqlMapID() + "getOne", obj);
	}
	
	@Override
	public T getOne(String[] columns, String sqlMapID, Object obj) {
		return this.getOne(__Model.cols2(columns), sqlMapID, obj);
	}

	@Override
	public T getOne(String columns, String sqlMapID, Object obj) {
		Map<String, Object> map = MapUtil.mapThem(new String[] { "columns", "param" }, columns, obj);
		return this.getDAO().getOne(sqlMapID, map);
	}
	
	@Override
	public List<T> getList(String[] columns, Object obj) {
		return this.getList(__Model.cols2(columns), obj);
	}

	@Override
	public List<T> getList(String columns, Object obj) {
		return this.getList(columns, this.getPrefixOfSqlMapID() + "getList", obj);
	}
	
	@Override
	public List<T> getList(String[] columns, String sqlMapID, Object obj) {
		return this.getList(__Model.cols2(columns), sqlMapID, obj);
	}

	@Override
	public List<T> getList(String columns, String sqlMapID, Object obj) {
		Map<String, Object> map = MapUtil.mapThem(new String[] { "columns", "param" }, columns, obj);
		return this.getDAO().getList(sqlMapID, map);
	}
	
	@Override
	public List<T> getListByMap(String[] columns, Map<String, Object> map) {
		return this.getListByMap(__Model.cols2(columns), map);
	}

	@Override
	public List<T> getListByMap(String columns, Map<String, Object> map) {
		return this.getListByMap(columns, this.getPrefixOfSqlMapID() + "getList", map);
	}
	
	@Override
	public List<T> getListByMap(String[] columns, String sqlMapID, Map<String, Object> map) {
		return this.getListByMap(__Model.cols2(columns), sqlMapID, map);
	}

	@Override
	public List<T> getListByMap(String columns, String sqlMapID, Map<String, Object> map) {
		map.put("columns", columns);
		return this.getDAO().getList(sqlMapID, map);
	}

	@Override
	public Integer getCountInt(T param) {
		return this.getCountInt(this.getPrefixOfSqlMapID() + "getCountInt", param);
	}

	@Override
	public Integer getCountInt(String sqlMapID, Object param) {
		return this.getDAO().getCountInt(sqlMapID, param);
	}

	@Override
	public Long getCountLong(T param) {
		return this.getCountLong(this.getPrefixOfSqlMapID() + "getCountLong", param);
	}

	@Override
	public Long getCountLong(String sqlMapID, Object param) {
		return this.getDAO().getCountLong(sqlMapID, param);
	}

	@Override
	public Map<String, Object> getPageList(String columns, DataGridModel dgm, T model) {
		return this.getPageList(columns, this.getPrefixOfSqlMapID() + "getPageList", this.getPrefixOfSqlMapID() + "getCountLongMap", dgm, model);
	}
	
	@Override
	public Map<String, Object> getPageList(String[] columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model) {
		return this.getPageList(__Model.cols2(columns), sqlMapSelectID, sqlMapCountID, dgm, model);
	}

	@Override
	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model) {
		return this.getPageList(columns, sqlMapSelectID, sqlMapCountID, dgm, model, null);
	}

	@Override
	public Map<String, Object> getPageList(String[] columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> map) {
		return this.getPageList(__Model.cols2(columns), sqlMapSelectID, sqlMapCountID, dgm, model, map);
	}
	
	@Override
	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> map) {
		return this.getDAO().getPageList(columns, sqlMapSelectID, sqlMapCountID, dgm, model, map);
	}


}
