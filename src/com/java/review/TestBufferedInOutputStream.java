package com.java.review;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestBufferedInOutputStream {

	/*
	 * 缓冲流复制文件
	 *    1.先创建要复制的文件和复制文件的路径 File的对象。
	 *    2.创建字节流的对象。
	 *    3.将字节流对象作形参放入到缓冲流的构造器中。
	 */
	@Test
	public void copyFile(){
		long start=System.currentTimeMillis();
		testBufferInputStream("d:/io/ytg.rmvb","d:/io/ytg3.rmvb");
		long end=System.currentTimeMillis();
		System.out.println("复制花费时长"+(end-start));
	}
	
	
	public void testBufferInputStream(String str1,String str2){
		BufferedInputStream bis =null;
		BufferedOutputStream bos=null;
		try {
			File file1=new File(str1);
			File file2=new File(str2);
			FileInputStream fis=new FileInputStream(file1);
			FileOutputStream fos=new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte [] b=new byte[1048576];
			int len;
			while((len=bis.read(b))!= -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis != null){
					try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	
	}		
}

