/**
 * 
 */
package com.iam_vip.kp.rs.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Colin
 */
public class StringToArrayUtil {

	/**
	 * 
	 */
	public StringToArrayUtil() {
	}
	
	public static Integer[] toIntObj(String arr, String separator) {
		
		if (arr == null || "".equals(arr)) {
			return new Integer[0];
		}
		
		String[] array = arr.split(separator);
		Integer[] r = new Integer[array.length];
		
		for (int i = 0; i < array.length; i++) {
			r[i] = Integer.parseInt(array[i]);
		}
		
		return r;
	}

	public static int[] toInt(String arr, String separator) {

		if (arr == null || "".equals(arr)) {
			return new int[0];
		}

		String[] array = arr.split(separator);
		int[] r = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			r[i] = Integer.parseInt(array[i]);
		}

		return r;
	}

	public static List<Integer> toIntList(String arr, String separator) {
		String[] array = arr.split(separator);
		List<Integer> r = new ArrayList<Integer>(array.length + 1);

		for (int i = 0; i < array.length; i++) {
			r.add(Integer.parseInt(array[i]));
		}

		return r;
	}

	public static Set<Integer> toIntSet(String arr, String separator) {
		String[] array = arr.split(separator);
		Set<Integer> r = new HashSet<Integer>(array.length + 1);

		for (int i = 0; i < array.length; i++) {
			r.add(Integer.parseInt(array[i]));
		}

		return r;
	}

}
