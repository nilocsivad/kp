/**
 * 
 */
package com.iam_vip.kp.logic.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iam_vip.kp.database.access.layout.IDAO;
import com.iam_vip.kp.logic.iapi.IHeTongService;
import com.iam_vip.kp.logic.model.HeTongModel;

/**
 *  <br />
 * Database table: he_tong <br />
 * @author Colin
 */
@Service
public class HeTongServiceImplement extends __APIDefaultImpl<HeTongModel> implements IHeTongService {

	@Autowired
	private IDAO<HeTongModel> __HeTongDAO;

	/**
	 * 
	 */
	public HeTongServiceImplement() {
	}

	@Override
	protected IDAO<HeTongModel> getDAO() {
		return __HeTongDAO;
	}

	@Override
	protected String getPrefixOfSqlMapID() {
		return PREFIX_OF_SQL_MAP_ID;
	}

}
