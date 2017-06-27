package com.file.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

/*
 * 转换流
 * 如何实现字符流和字节流之间的转换
 *     1.编码： InputStreamReader 字节流转换为字符流
 *         过程  
 *           a.创建File的对象。
 *           b.创建FileInputStream的对象
 *           c.创建InputStreamReader类的对象
 * 			 e.创建BufferedReader的对象
 * 
 */
public class TestInOutStreamReaderWriter {
	
	
	/*
	 * 编码读取
	 */
	@Test
	public void testInputStreamReader(){
		BufferedReader br =null;
		try {
			File file1=new File("d:/io/testlong.log");
			FileInputStream fis=new FileInputStream(file1);
			InputStreamReader isr=new InputStreamReader(fis, "gbk");
			br = new BufferedReader(isr);
			String str;
			while((str=br.readLine())!= null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
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
