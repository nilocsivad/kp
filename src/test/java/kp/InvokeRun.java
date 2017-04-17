/**
 * 
 */
package kp;

import java.lang.reflect.Field;

/**
 * @author Administrator
 */
public class InvokeRun {

	public static void main(String[] args) throws Exception {

		String line = "-------------------------------------------";

		System.out.println(line);

		Object obj = new Object();
		Class<?> cls = obj.getClass();
		String clsName = cls.getSimpleName();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			String f = field.getName();
			System.out.println(String.format("<if test=\"%s != null and %s != ''\"> AND %s = #{%s} </if>", f, f, f, f));
		}

		System.out.println(line);
		for (Field field : fields) {
			System.out.print("\"" + field.getName() + "\",");
		}
		System.out.println();

		System.out.println(line);
		for (Field field : fields) {
			System.out.println(field.getName() + ",");
		}

		System.out.println(line);
		for (Field field : fields) {
			System.out.println("#{obj." + field.getName() + "},");
		}

		System.out.println(line);
		for (Field field : fields) {
			System.out.println("#{" + field.getName() + "},");
		}

		System.out.println(line);
		for (Field field : fields) {
			System.out.format("\"%s\", ", field.getName());
		}
		System.out.println(line);

		System.out.println(line);
		for (Field field : fields) {
			String f = field.getName();
			if (f.startsWith("KEY_"))
				System.out.format("%s.%s, ", clsName, f);
		}
		System.out.println(line);

	}

}
