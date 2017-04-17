/**
 * 
 */
package kp;

import java.io.File;

/**
 * @author Administrator
 */
public class ScanIBatisXML {

	/**
	 * 
	 */
	public ScanIBatisXML() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		String path = System.getProperty("user.dir") + "/src/main/resources/config/ibatis";

		File folder = new File(path);

		String[] fs = folder.list();

		for (String f : fs) {
			System.out.format("	<sqlMap resource=\"config/ibatis/%s\" />\r\n", f);
		}

	}

}
