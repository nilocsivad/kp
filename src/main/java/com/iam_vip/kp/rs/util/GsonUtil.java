/**
 * 
 */
package com.iam_vip.kp.rs.util;

import com.google.gson.Gson;

/**
 * @author Colin
 */
public class GsonUtil {

	/**
	 * 
	 */
	public GsonUtil() {
	}

	static Gson gson = new Gson();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

}
