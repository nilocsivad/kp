/**
 * 
 */
package com.iam_vip.kp.logic.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  <br />
 * Database table: fu_jian <br />
 * @author Colin
 */
public class FuJianModel extends __Model {

	/// String fuJianID; // 附件唯一字符串ID CHAR (50) nullable: false
	/// Integer refNID; // 附件对应的数字ID INT (11) nullable: true
	/// String refSID; // 附件对应的字符串ID VARCHAR (50) nullable: true
	/// String timeline; // 上传时间 CHAR (19) nullable: false
	/// Integer stepNum; // 先后顺序 按照时间与当前字段排序 INT (4) nullable: false

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * All fields, like colPK,colA,colB,colC...
	 */
	public static final String ALL = "fuJianID, refNID, refSID, timeline, stepNum";
	
	/**
	 * Fields without PK, like colA,colB,colC...
	 */
	public static final String NOPK = "refNID, refSID, timeline, stepNum";


	/**
	 * 附件唯一字符串ID <br />
	 * CHAR (50) <br />
	 * String <br />
	 * nullable: false
	 */
	public static final String KEY_FUJIANID = "fuJianID";
	/**
	 * length of 附件唯一字符串ID
	 */
	public static final int LEN_FUJIANID = 50;
	
	/**
	 * 附件对应的数字ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: true
	 */
	public static final String KEY_REFNID = "refNID";
	
	/**
	 * 附件对应的字符串ID <br />
	 * VARCHAR (50) <br />
	 * String <br />
	 * nullable: true
	 */
	public static final String KEY_REFSID = "refSID";
	/**
	 * length of 附件对应的字符串ID
	 */
	public static final int LEN_REFSID = 50;
	
	/**
	 * 上传时间 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: false
	 */
	public static final String KEY_TIMELINE = "timeline";
	/**
	 * length of 上传时间
	 */
	public static final int LEN_TIMELINE = 19;
	
	/**
	 * 先后顺序 按照时间与当前字段排序 <br />
	 * INT (4) <br />
	 * Integer <br />
	 * nullable: false
	 */
	public static final String KEY_STEPNUM = "stepNum";
	


	/**
	 * 
	 */
	public FuJianModel() {
	}

	/**
	 * 附件唯一字符串ID <br />
	 * CHAR (50) <br />
	 * String <br />
	 * nullable: false
	 */
	private String fuJianID; 
	/**
	 * 附件对应的数字ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: true
	 */
	private Integer refNID; 
	/**
	 * 附件对应的字符串ID <br />
	 * VARCHAR (50) <br />
	 * String <br />
	 * nullable: true
	 */
	private String refSID; 
	/**
	 * 上传时间 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: false
	 */
	private String timeline; 
	/**
	 * 先后顺序 按照时间与当前字段排序 <br />
	 * INT (4) <br />
	 * Integer <br />
	 * nullable: false
	 */
	private Integer stepNum; 
	
	

	private static String getMethodName(String name) {
		return (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}

	public static FuJianModel Make(String cols, Object... vals) {
		return Make(cols.split(","), vals);
	}
	
	public static FuJianModel Make(String[] fields, Object... vals) {
		FuJianModel instance = new FuJianModel();
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
	 * 附件唯一字符串ID <br />
	 * CHAR (50) <br />
	 * String <br />
	 * nullable: false <br />
	 * @return the fuJianID
	 */
	public String getFuJianID() {
		return fuJianID;
	}
	
	/**
	 * 附件唯一字符串ID <br />
	 * CHAR (50) <br />
	 * String <br />
	 * nullable: false <br />
	 * @param fuJianID the fuJianID to set
	 */
	public void setFuJianID(String fuJianID) {
		if (fuJianID != null && !"".equals(fuJianID) && fuJianID.length() > LEN_FUJIANID) {
			fuJianID = fuJianID.substring(0, LEN_FUJIANID);
		}
		this.fuJianID = fuJianID;
	}
	
	/**
	 * 附件对应的数字ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: true <br />
	 * @return the refNID
	 */
	public Integer getRefNID() {
		return refNID;
	}
	
	/**
	 * 附件对应的数字ID <br />
	 * INT (11) <br />
	 * Integer <br />
	 * nullable: true <br />
	 * @param refNID the refNID to set
	 */
	public void setRefNID(Integer refNID) {
		this.refNID = refNID;
	}
	
	/**
	 * 附件对应的字符串ID <br />
	 * VARCHAR (50) <br />
	 * String <br />
	 * nullable: true <br />
	 * @return the refSID
	 */
	public String getRefSID() {
		return refSID;
	}
	
	/**
	 * 附件对应的字符串ID <br />
	 * VARCHAR (50) <br />
	 * String <br />
	 * nullable: true <br />
	 * @param refSID the refSID to set
	 */
	public void setRefSID(String refSID) {
		if (refSID != null && !"".equals(refSID) && refSID.length() > LEN_REFSID) {
			refSID = refSID.substring(0, LEN_REFSID);
		}
		this.refSID = refSID;
	}
	
	/**
	 * 上传时间 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: false <br />
	 * @return the timeline
	 */
	public String getTimeline() {
		return timeline;
	}
	
	/**
	 * 上传时间 <br />
	 * CHAR (19) <br />
	 * String <br />
	 * nullable: false <br />
	 * @param timeline the timeline to set
	 */
	public void setTimeline(String timeline) {
		if (timeline != null && !"".equals(timeline) && timeline.length() > LEN_TIMELINE) {
			timeline = timeline.substring(0, LEN_TIMELINE);
		}
		this.timeline = timeline;
	}
	
	/**
	 * 先后顺序 按照时间与当前字段排序 <br />
	 * INT (4) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @return the stepNum
	 */
	public Integer getStepNum() {
		return stepNum;
	}
	
	/**
	 * 先后顺序 按照时间与当前字段排序 <br />
	 * INT (4) <br />
	 * Integer <br />
	 * nullable: false <br />
	 * @param stepNum the stepNum to set
	 */
	public void setStepNum(Integer stepNum) {
		this.stepNum = stepNum;
	}
	
	
}
