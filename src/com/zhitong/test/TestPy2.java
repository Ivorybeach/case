package com.zhitong.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//调用Py脚本测试
public class TestPy2 {

	public static void main(String[] args) {
		String[] args1 = new String[] {"python","H:\\workspace3\\zhitong\\WebContent\\py\\cat_face.py"};
		try {
			//借助本机python环境执行python命令
			//Runtime()是java程序正在运行，getRuntime()获取runtime实例，
			//exec执行specified command and arguments in a separate process
			//即表示在java application运行时调用其他程序，其他程度在独立进程中执行
			Process pr = Runtime.getRuntime().exec(args1);
			//pr.getInputStream()获取程序输出内容的输入流
			//readLine()：Reads a line of text
			 //This method returns immediately if the subprocess has already terminated.
			 //python程序结束，方法立即返回；如果python未结束方法将一直等待、一直执行；
			pr.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
