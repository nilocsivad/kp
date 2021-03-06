/**
 * 
 */
package com.iam_vip.kp.rs.ref;

/**
 * @author Colin
 *
 */
public class RandomString {

	/**
	 * 
	 */
	public RandomString() {
	}

	private int len = 8;

	public static final String[] codes = { "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F", "g", "G", "h", "H", "i", "I", "j", "J", "k", "K", "l", "L", "m", "M", "n", "N", "o", "O", "p", "P", "q", "Q", "r", "R", "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X", "y", "Y", "z", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static final int max = codes.length;

	/**
	 * @param len
	 */
	public RandomString(int len) {
		this.len = len;
	}

	/**
	 * @return
	 */
	public String toString() {

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < len; ++i) {
			buf.append(codes[(int) (Math.random() * max)]);
		}
		return buf.toString();
	}

	/**
	 * @return
	 */
	public static String random() {
		return new RandomString().toString();
	}

}
