package com.java.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class ReviewInOutputStreamReaderWriter {
	/*
	 * 转换流
	 * 	 1.创建文件的的存取位置
	 * 	 2.创建对应的字节流的对象。以1的对象做形参
	 *   3.创建解码流的对象。	
	 *   4.创建缓存流的对象。
	 * 
	 */
	//编码 OutputStreamWriter
	/*
	 * 字符流到字节流，保存文件
	 */
	@Test
	public void testDecodeCode(){
		BufferedReader br =null;
		BufferedWriter bw =null;
		try {
			File file1=new File("d:/io/testlong.log");
			File file2=new File("d:/io/testlong3.log");
			InputStream is=new FileInputStream(file1);
			OutputStream os=new FileOutputStream(file2);
			InputStreamReader isr=new InputStreamReader(is);
			OutputStreamWriter osw=new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			bw = new BufferedWriter(osw);
			String str;
			while((str=br.readLine())!=null){
				bw.write(str);
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw !=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	@Test
	public void testCode(){
		File file=new File("d:/io/test.log");
		try {
			FileOutputStream  fos=new FileOutputStream(file);
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write("I love baby,You are my switer!");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	//InputStreamReader解码过程
	/*
	 * 字节流到字符流
	 */
	@Test
	public void testDecode(){
		File file=new File("d:/io/testlong.log");
		BufferedReader br=null;
		try {
			InputStream fis=new FileInputStream(file);
			InputStreamReader isr=new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null){
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
