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

/* 1.���ķ���
 *    ����ͨ��1������   2.�����
 *    ���մ���ĵ�λ��ͬ  ���ֽ���        �ַ�����������ı��ļ���
 *    ���մ������ݽ�ɫ��ͬ��   �ڵ�����ֱ���������ļ��ģ�  ��������һ�㲻����������ı��ļ���
 * 1.IO��ϵ
 *     �������                  �ڵ���							������
 *     InputStream    FileInputStream(�ֽ���)		BufferedInputStream 
 *     OutputStream   FileOutputStream(�ֽ���)		BufferedOutputStream ( ÿ�ζ�ȡ��Ҫflush())
 *     Reader         FileReader(�ַ���)				BufferedReader   (readLine())
 *     Wrider         FileWrider(�ַ���)				BufferedWriter  (ÿ�ζ�ȡ��Ҫflush())
 */

public class testBufferInputOutputStream {
	/*
	 * BufferedInputStream BufferedOutputStream ʵ���ı��ļ��ĸ���
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
	
	
	
	
	//ʹ��BufferedInputStream BufferedOutputStreamʵ�ַ��ı��ļ�����
	@Test
	public void copyFile(){
		long start=System.currentTimeMillis();
		testBufferedInputOutputStream("d:/io/ytg.rmvb","d:/io/ytg5.rmvb");
		long end= System.currentTimeMillis();
	}
	
	public void testBufferedInputOutputStream(String s1,String s2){
		//1.�ȴ�����ȡд����ļ�
		//2.������Ӧ�Ľڵ�����FileInputStream FileOutputStream
		FileInputStream fis =null;
		FileOutputStream fos =null;
		try {
			File file1=new File(s1);
			File file2=new File(s2);
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.�������õĽڵ������βδ��ݸ��������Ĺ������С�
			BufferedInputStream bis=new BufferedInputStream(fis);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			//4.����������������Ŷ�������ݡ�
			byte [] b=new byte[1048576];
			int len;
			//5.ʵ�ָ��ƹ���
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
			//�ر���
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
