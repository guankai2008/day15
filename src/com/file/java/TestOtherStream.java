package com.file.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

/*
 * 标准输出流
 *    1.System.out.print
 * 标准输入流
 * 	  2.Scanner
 */
public class TestOtherStream {
	/*
	 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
	 * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
	 * 
	 * 
	 * 分析：
	 *    1.从键盘输入需要用的
	 *    2.将输入的文件放到一个字符串
	 *    3.通过bufferreader读取这个字符串
	 *    4.无限循环while(true)实现键盘的输入。
	 *    5.判断输入的是否是e || exit
	 *    6.不是的大写打印到控制台
	 */
	@Test
	public void test2(){
		Scanner s=new Scanner(System.in);
		
		while(true){
			System.out.println("输入字符串");
			String str=s.nextLine();
			if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
				break;
			}
			System.out.println(str.toUpperCase());
		}
	}
	@Test
	public void test(){
		//将转换的字符流对象传给BufferedReader
		BufferedReader br =null;
		try {
			//读入一个字节流的数据
			InputStream in=System.in;
			//字节流转换为字符流
			InputStreamReader isr=new InputStreamReader(in);
			br = new BufferedReader(isr);
			String str;
			while(true){
				System.out.println("随机输入字符串");
				str=br.readLine();
				if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
					break;
				}
				String str1=str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br !=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
