/**
 * 
 */
package com.iam_vip.kp.rs.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Colin
 */
public class MD5Util {

	public static final String TYPE_MD5 = "MD5";

	/**
	 * 
	 */
	private MD5Util() {
	}

	public static final String getMD5(final String text) {

		try {
			MessageDigest md = MessageDigest.getInstance(TYPE_MD5);
			byte[] bytes = md.digest(text.getBytes("UTF-8"));

			StringBuffer buf = new StringBuffer();
			for (byte b : bytes) {
				int n = b & 0xFF;
				String s = Integer.toHexString(n);
				buf.append(n > 15 ? s : "0" + s);
			}
			return buf.toString().toUpperCase();
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return text;
	}

}
