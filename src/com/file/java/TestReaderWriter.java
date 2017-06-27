package com.file.java;



/* 1.流的分类
 *    流向不通：1输入流   2.输出流
 *    按照处理的单位不同  ：字节流        字符流（处理的文本文件）
 *    按照处理数据角色不同：   节点流（直接作用于文件的）  处理流
 * 1.IO体系
 *     抽象基类                  节点流							缓冲流
 *     InputStream    FileInputStream(字节流)		BufferedInputStream
 *     OutputStream   FileOutputStream(字节流)		BufferedOutputStream
 *     Reader         FileReader(字符流)				BufferedReader
 *     Wrider         FileWrider(字符流)				BufferedWriter
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;


/*
 * 对于文本文件可以用FileReader和FileWriter实习读写复制 （字符流）
 * 对于非文本文件可以用非文本文件使用字节流。（FileInputStream FileOutputStream）
 * 
 * 
 */

public class TestReaderWriter {
	@Test
	public void copy(){
		long start =System.currentTimeMillis();
		copyFileReaderWriter("d:/io/testlong.log", "d:/io/testlong4.log");
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	
	
	/*
	 * 复制
	 * 
	 * 
	 */
	public void copyFileReaderWriter(String s1,String s2){
		//先建读入和吸入类的引用
			FileReader fr=null;
			FileWriter fw=null;
			try{
				File file1=new File(s1);
				File file2=new File(s2);
				fr=new FileReader(file1);
				fw=new FileWriter(file2);
				char [] c=new char[200];
				int len;
				while((len=fr.read(c)) != -1){
					fw.write(c,0,len);
				}
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(fw != null){
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(fr != null){
							try {
								fr.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		
	}
	
	
	
	
	@Test
	public void testReaderWriter(){
		FileReader fr=null;
		FileWriter fw=null;
		try{
			File file1 =new File("d:/io/testlong.log");
			File file2=new  File("d:/io/testlong2.log");
			fr=new FileReader(file1);
			fw=new FileWriter(file2);
			char [] c=new char[20];
			int len ;
			while((len=fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	//Reader方式
	@Test
	public void testReader(){
		File file1=new File("d:/io/testlong.log");
		FileReader fid=null;
		try{
			fid=new FileReader(file1);
			char [] c=new char[20]; 
			int len;
			while((len=fid.read(c)) !=-1){
				for(int i=0;i<len;i++){
					System.out.print(c[i]);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fid !=null){
				try {
					fid.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
