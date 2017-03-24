/**
 * 
 */
package com.iam_vip.kp.logic.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iam_vip.kp.database.access.layout.IDAO;
import com.iam_vip.kp.logic.iapi.IFuJianService;
import com.iam_vip.kp.logic.model.FuJianModel;

/**
 *  <br />
 * Database table: fu_jian <br />
 * @author Colin
 */
@Service
public class FuJianServiceImplement extends __APIDefaultImpl<FuJianModel> implements IFuJianService {

	@Autowired
	private IDAO<FuJianModel> __FuJianDAO;

	/**
	 * 
	 */
	public FuJianServiceImplement() {
	}

	@Override
	protected IDAO<FuJianModel> getDAO() {
		return __FuJianDAO;
	}

	@Override
	protected String getPrefixOfSqlMapID() {
		return PREFIX_OF_SQL_MAP_ID;
	}

}
