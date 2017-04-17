/**
 * 
 */
package kp;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Colin
 */
public class MinimizeFile {

	/**
	 * 
	 */
	public MinimizeFile() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String filePath = "D:/EclipseData/mp2017/src/main/webapp/assets/location.json";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		StringBuffer buf = new StringBuffer();
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			buf.append(line.replace(" ", "") + "\r\n");
			line = null;
		}
		
		reader.close();
		System.out.println(buf);

	}

}
