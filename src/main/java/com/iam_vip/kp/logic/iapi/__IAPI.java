/**
 * 
 */
package com.iam_vip.kp.logic.iapi;

import java.util.List;
import java.util.Map;

import com.iam_vip.kp.rs.c.IAPP;
import com.iam_vip.kp.rs.ref.DataGridModel;

/**
 * @author Colin
 */
public interface __IAPI<T> extends IAPP {

	public Object saveMulti(String sqlMapID, Object obj);

	public int update(String sqlMapID, Object obj);

	public int delete(String sqlMapID, Object obj);



	public T getOne(String[] columns, String sqlMapID, Object obj);

	public T getOne(String columns, String sqlMapID, Object obj);

	public T getOne(String[] columns, Object obj);

	public T getOne(String columns, Object obj);

	public T getOneByPK(String[] columns, Object obj);

	public T getOneByPK(String columns, Object obj);



	public List<T> getList(String[] columns, String sqlMapID, Object obj);

	public List<T> getList(String columns, String sqlMapID, Object obj);

	public List<T> getList(String[] columns, Object obj);

	public List<T> getList(String columns, Object obj);

	public List<T> getListByMap(String[] columns, String sqlMapID, Map<String, Object> map);

	public List<T> getListByMap(String columns, String sqlMapID, Map<String, Object> map);

	public List<T> getListByMap(String[] columns, Map<String, Object> map);

	public List<T> getListByMap(String columns, Map<String, Object> map);

	public Integer getCountInt(String sqlMapID, Object param);

	public Long getCountLong(String sqlMapID, Object param);
	
	
	
	
	public Map<String, Object> getPageList(String[] columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model);

	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model);
	
	public Map<String, Object> getPageList(String[] columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> map);

	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> map);




	public Object save(T model);

	public Integer saveReturnInt(T model);

	public Long saveReturnLong(T model);

	public int update(T obj);

	public int delete(T obj);

	public Integer getCountInt(T param);

	public Long getCountLong(T param);

	public Map<String, Object> getPageList(String columns, DataGridModel dgm, T model);

}
