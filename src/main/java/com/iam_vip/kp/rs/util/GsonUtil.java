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

	public static Gson gson = new Gson();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

}
