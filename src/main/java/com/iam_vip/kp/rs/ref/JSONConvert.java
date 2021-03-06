/**
 * 
 */
package com.iam_vip.kp.rs.ref;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.iam_vip.kp.rs.util.GsonUtil;

/**
 * @author Colin
 */
public class JSONConvert extends MappingJackson2HttpMessageConverter {

	/**
	 * 是否打印返回值
	 */
	public static boolean OUTPUT_RESULT = false;

	/**
	 * 
	 */
	public JSONConvert() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.http.converter.json.MappingJacksonHttpMessageConverter
	 */
	@Override
	protected void writeInternal(Object arg0, HttpOutputMessage arg1) throws IOException, HttpMessageNotWritableException {
		super.writeInternal(arg0, arg1);

		if (OUTPUT_RESULT) {
			System.out.println(GsonUtil.toJson(arg0));
		}

	}

}
