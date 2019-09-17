package com.zhitong.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//执行Python脚本工具类
public class PyUtil {
	public static String exePy() {
		// 调用python脚本
		String[] args1 = new String[] { "python", "H:\\workspace3\\zhitong\\WebContent\\py\\detect_cat_human.py" };
		try {
			Process pr = Runtime.getRuntime().exec(args1);
			pr.waitFor();
			// readLine()读入为空，改为：
			// py脚本将判断结果写入文件，java读取文件中的结果
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(pr.getInputStream()));
			// String line = in.readLine();
			// in.close();
			File file = new File("H:\\workspace3\\zhitong\\WebContent\\py\\result.txt");
			InputStream is = new FileInputStream(file);
			byte b[] = new byte[(int) file.length()];
			is.read(b);
			return new String(b);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}