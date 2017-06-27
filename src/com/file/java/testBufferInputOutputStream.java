package com.file.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/* 1.流的分类
 *    流向不通：1输入流   2.输出流
 *    按照处理的单位不同  ：字节流        字符流（处理的文本文件）
 *    按照处理数据角色不同：   节点流（直接作用于文件的）  处理流，一般不用这个处理文本文件。
 * 1.IO体系
 *     抽象基类                  节点流							缓冲流
 *     InputStream    FileInputStream(字节流)		BufferedInputStream 
 *     OutputStream   FileOutputStream(字节流)		BufferedOutputStream ( 每次读取后要flush())
 *     Reader         FileReader(字符流)				BufferedReader   (readLine())
 *     Wrider         FileWrider(字符流)				BufferedWriter  (每次读取后要flush())
 */

public class testBufferInputOutputStream {
	/*
	 * BufferedInputStream BufferedOutputStream 实现文本文件的复制
	 * 
	 * 
	 */
	 @Test
	 public void testBufferedReader(){
		 BufferedReader br =null;
		BufferedWriter bw =null;
		try {
			File file1=new File("d:/io/testlong.log");
		
			 File file2=new File("d:/io/testlong10.log");
			 FileReader fr=new FileReader(file1);
			 FileWriter fw=new FileWriter(file2);
			 br = new BufferedReader(fr);
			 bw = new BufferedWriter(fw);
			 String str;
			 while((str=br.readLine()) != null){
				 	bw.write(str);
				 	bw.newLine();
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
			}if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
		 
		}
		
	 }
	
	
	
	
	//使用BufferedInputStream BufferedOutputStream实现非文本文件复制
	@Test
	public void copyFile(){
		long start=System.currentTimeMillis();
		testBufferedInputOutputStream("d:/io/ytg.rmvb","d:/io/ytg5.rmvb");
		long end= System.currentTimeMillis();
	}
	
	public void testBufferedInputOutputStream(String s1,String s2){
		//1.先创建读取写入的文件
		//2.创建相应的节点流，FileInputStream FileOutputStream
		FileInputStream fis =null;
		FileOutputStream fos =null;
		try {
			File file1=new File(s1);
			File file2=new File(s2);
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.将创建好的节点流的形参传递给缓冲流的构造器中。
			BufferedInputStream bis=new BufferedInputStream(fis);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			//4.创建个数组用来存放读入的数据。
			byte [] b=new byte[1048576];
			int len;
			//5.实现复制功能
			while((len=bis.read(b))!= -1){
				fos.write(b, 0, len);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭流
			if(fis !=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		
	}
	
}
