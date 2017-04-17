/**
 * 
 */
package kp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Administrator
 */
public class Base64Test {

	/**
	 * 
	 */
	public Base64Test() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String text = "hello-abbbbb";

		String eText = Base64.encodeBase64String(text.getBytes());

		System.out.println(eText);

		String nText = new String(Base64.decodeBase64(eText));

		System.out.println(nText);




		String fromFile = "txws-zly.mp3", toFile = "txws-zly-2.mp3";

		File mp3File = new File(fromFile);
		BufferedInputStream ins = new BufferedInputStream(new FileInputStream(mp3File));
		byte[] bbb = new byte[(int) mp3File.length()];
		ins.read(bbb, 0, bbb.length);
		ins.close();

		String base64 = Base64.encodeBase64String(bbb);

		byte[] bytes = Base64.decodeBase64(base64);
		InputStream input = new ByteArrayInputStream(bytes);
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(toFile));
		int len = 0;
		byte[] buf = new byte[1024 * 24]; /// 24k ///
		while ((len = input.read(buf)) > 0) {
			output.write(buf, 0, len);
		}
		input.close();
		output.close();

	}

}
