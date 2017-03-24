/**
 * 
 */
package com.iam_vip.kp.logic.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  <br />
 * Database table: he_tong <br />
 * @author Colin
 */
public class HeTongModel extends __Model {

	/// Integer htID; //  INT (11) nullable: false
	/// String who; //  VARCHAR (24) nullable: true
	/// String address; // 租赁地址 VARCHAR (216) nullable: true
	/// String signDate; // 合同日期 CHAR (19) nullable: true
	/// String remark; // 备注 VARCHAR (5592405) nullable: true

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * All fields, like colPK,colA,colB,colC...
	 */
	public static final String ALL = "htID, who, address, signDate, remark";
	
	/**
	 * Fields without PK, like colA,colB,colC...
	 */
	public static final String NOPK = "who, address, signDate, remark";


	/**
	 *  <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_HTID = "htID";
	
	/**
	 *  <br />
	 * VARCHAR (24) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_WHO = "who";
	/**
	 * length of 
	 */
	public static final int LEN_WHO = 24;
	
	/**
	 * 租赁地址 <br />
	 * VARCHAR (216) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_ADDRESS = "address";
	/**
	 * length of 租赁地址
	 */
	public static final int LEN_ADDRESS = 216;
	
	/**
	 * 合同日期 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_SIGNDATE = "signDate";
	/**
	 * length of 合同日期
	 */
	public static final int LEN_SIGNDATE = 19;
	
	/**
	 * 备注 <br />
	 * VARCHAR (5592405) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_REMARK = "remark";
	/**
	 * length of 备注
	 */
	public static final int LEN_REMARK = 5592405;
	


	/**
	 * 
	 */
	public HeTongModel() {
	}

	/**
	 *  <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer htID; 
	/**
	 *  <br />
	 * VARCHAR (24) <br />
	 * String <br />
	 * nullable: true
	 */
	private String who; 
	/**
	 * 租赁地址 <br />
	 * VARCHAR (216) <br />
	 * String <br />
	 * nullable: true
	 */
	private String address; 
	/**
	 * 合同日期 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: true
	 */
	private String signDate; 
	/**
	 * 备注 <br />
	 * VARCHAR (5592405) <br />
	 * String <br />
	 * nullable: true
	 */
	private String remark; 
	
	

	private static String getMethodName(String name) {
		return (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}

	public static HeTongModel Make(String cols, Object... vals) {
		return Make(cols.split(","), vals);
	}
	
	public static HeTongModel Make(String[] fields, Object... vals) {
		HeTongModel instance = new HeTongModel();
		try {

			Class<?> cls = instance.getClass();

			for (int i = 0, l = fields.length; l > i; ++i) {
				String field = fields[i].trim();
				try {
					Field fd = cls.getDeclaredField(field);
					if (fd != null) {
						Method method = cls.getDeclaredMethod("set" + getMethodName(field), fd.getType());
						if (method != null) {
							method.invoke(instance, vals[i]);
						}
						// fd.setAccessible(true);
						// fd.set(instance, vals[i]);
						// fd.setAccessible(false);
					}
				}
				// catch (NoSuchFieldException e) {
				catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
	
	
	
	/**
	 *  <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the htID
	 */
	public Integer getHtID() {
		return htID;
	}
	
	/**
	 *  <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param htID the htID to set
	 */
	public void setHtID(Integer htID) {
		this.htID = htID;
	}
	
	/**
	 *  <br />
	 * VARCHAR (24) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the who
	 */
	public String getWho() {
		return who;
	}
	
	/**
	 *  <br />
	 * VARCHAR (24) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param who the who to set
	 */
	public void setWho(String who) {
		if (who != null && !"".equals(who) && who.length() > LEN_WHO) {
			who = who.substring(0, LEN_WHO);
		}
		this.who = who;
	}
	
	/**
	 * 租赁地址 <br />
	 * VARCHAR (216) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 租赁地址 <br />
	 * VARCHAR (216) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if (address != null && !"".equals(address) && address.length() > LEN_ADDRESS) {
			address = address.substring(0, LEN_ADDRESS);
		}
		this.address = address;
	}
	
	/**
	 * 合同日期 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the signDate
	 */
	public String getSignDate() {
		return signDate;
	}
	
	/**
	 * 合同日期 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param signDate the signDate to set
	 */
	public void setSignDate(String signDate) {
		if (signDate != null && !"".equals(signDate) && signDate.length() > LEN_SIGNDATE) {
			signDate = signDate.substring(0, LEN_SIGNDATE);
		}
		this.signDate = signDate;
	}
	
	/**
	 * 备注 <br />
	 * VARCHAR (5592405) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * 备注 <br />
	 * VARCHAR (5592405) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		if (remark != null && !"".equals(remark) && remark.length() > LEN_REMARK) {
			remark = remark.substring(0, LEN_REMARK);
		}
		this.remark = remark;
	}
	
	
}
