package com.file.java;



/* 1.���ķ���
 *    ����ͨ��1������   2.�����
 *    ���մ���ĵ�λ��ͬ  ���ֽ���        �ַ�����������ı��ļ���
 *    ���մ������ݽ�ɫ��ͬ��   �ڵ�����ֱ���������ļ��ģ�  ������
 * 1.IO��ϵ
 *     �������                  �ڵ���							������
 *     InputStream    FileInputStream(�ֽ���)		BufferedInputStream
 *     OutputStream   FileOutputStream(�ֽ���)		BufferedOutputStream
 *     Reader         FileReader(�ַ���)				BufferedReader
 *     Wrider         FileWrider(�ַ���)				BufferedWriter
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;


/*
 * �����ı��ļ�������FileReader��FileWriterʵϰ��д���� ���ַ�����
 * ���ڷ��ı��ļ������÷��ı��ļ�ʹ���ֽ�������FileInputStream FileOutputStream��
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
	 * ����
	 * 
	 * 
	 */
	public void copyFileReaderWriter(String s1,String s2){
		//�Ƚ�����������������
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
	
	
	
	//Reader��ʽ
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
