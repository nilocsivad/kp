package com.iam_vip.kp.database.access.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.iam_vip.kp.rs.ref.DataGridModel;

@Repository
@SuppressWarnings("deprecation")
public class DAOImpl<T> extends SqlMapClientTemplate implements IDAO<T> {

	@Override
	public Object save(String sqlMapID, Object model) {
		return super.insert(sqlMapID, model);
	}

	@Override
	public Object saveMulti(String sqlMapID, Object obj) {
		return super.insert(sqlMapID, obj);
	}

	@Override
	public Integer saveReturnInt(String sqlMapID, T model) {
		Object obj = this.save(sqlMapID, model);
		if (obj instanceof Integer)
			return (Integer) obj;
		return 0;
	}

	@Override
	public Long saveReturnLong(String sqlMapID, T model) {
		Object obj = this.save(sqlMapID, model);
		if (obj instanceof Long)
			return (Long) obj;
		return 0L;
	}

	@Override
	public int update(String sqlMapID, Object obj) {
		return super.update(sqlMapID, obj);
	}

	@Override
	public int delete(String sqlMapID, Object obj) {
		return super.delete(sqlMapID, obj);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getOne(String sqlMapID) {
		return (T) queryForObject(sqlMapID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T getOne(String sqlMapID, Object obj) {
		return (T) queryForObject(sqlMapID, obj);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getList(String sqlMapID) {
		return queryForList(sqlMapID);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getList(String sqlMapID, Object obj) {
		return queryForList(sqlMapID, obj);
	}

	@Override
	public Integer getCountInt(String sqlMapID, Object param) {
		Object obj = queryForObject(sqlMapID, param);
		if (obj instanceof Integer)
			return (Integer) obj;
		return 0;
	}

	@Override
	public Long getCountLong(String sqlMapID, Object param) {
		Object obj = queryForObject(sqlMapID, param);
		if (obj instanceof Long)
			return (Long) obj;
		return 0L;
	}

	@Override
	public Map<String, Object> getPageList(String columns, String sqlMapSelectID, String sqlMapCountID, DataGridModel dgm, T model, Map<String, Object> extra) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map<String, Object> map = new HashMap<String, Object>();
		if (extra != null && extra.isEmpty() == false) {
			for (Map.Entry<String, Object> itm : extra.entrySet()) {
				map.put(itm.getKey(), itm.getValue());
			}
		}
		map.put("columns", columns);
		map.put("param", model);
		map.put("begin", (dgm.getPage() - 1) * dgm.getRows());
		map.put("end", dgm.getRows());
		map.put("sort", dgm.getSort());
		map.put("order", dgm.getOrder());
		Object sum = super.queryForObject(sqlMapCountID, map);
		if (sum == null) {
			result.put("total", 0);
			result.put("rows", new ArrayList<Object>());
			return result;
		}
		long totalsum = (long) sum;
		result.put("total", totalsum);
		result.put("rows", super.queryForList(sqlMapSelectID, map));
		return result;
	}

}
