package com.file.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

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
public class TestFileInputOutputStream {
	
	@Test
	public void testCopyFile(){
		long start=System.currentTimeMillis();
		String from="d:/io/ytg.rmvb";
		String to="d:/io/ytg2.rmvg";
		copyFile(from,to);
		long end=System.currentTimeMillis();
		System.out.println("����ʱ��"+(end-start));
	}
	
	
	public void copyFile(String from,String to){
		
		//1.���������д���������ַ
		File file1=new File(from);
		File file2=new File(to);
		//2.�����������ĶԶ���
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(file1);
			fos=new FileOutputStream(file2);
			byte [] b=new byte[1048576];
			int len;
			while((len=fis.read(b))!= -1){
				fos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos !=null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}finally{
					if(fis !=null){
						try{
							fis.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			}
		}
	
	}
	
	
	@Test
	public void testInOut(){
		//1.���������д���������ַ
		File file1=new File("d:/io/test5.png");
		File file2=new File("d:/io/test6.png");
		//2.�����������ĶԶ���
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(file1);
			fos=new FileOutputStream(file2);
			byte [] b=new byte[20];
			int len;
			while((len=fis.read(b))!= -1){
				fos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fos !=null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}finally{
					if(fis !=null){
						try{
							fis.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
	
	
	/*
	 * ��һ���ļ���ȡ��д�뵽����ļ�
	 */
	@Test
	public void testFileInputStreamFileOutputStream(){
		//1��ȡ��д����ļ�
		File file1=new File("d:/io/test5.png");
		File file2=new File("d:/io/test6.png");
		//2.������Ӧ����
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			fis=new FileInputStream(file1);
			fos=new FileOutputStream(file2);
			//3.ʵ���ļ��ĸ���
			byte [] b=new byte[20];
			int len1;
			while((len1=fis.read())!=-1){
				fos.write(b, 0, len1);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	/*
	 * ���
	 */
	@Test
	public void testout(){
		//1.����һ���洢���ݵ��ļ���
		//�������������ļ����Բ����ڣ���ִ�й�������������ڣ������Զ������������ڻὫԭ���ĵ��ļ����ǡ�
		File file =new File("d:/io/HelloWord.txt");
		//2 ����һ��outputStream���Ķ��󣬽�File�Ķ������βε���ʽ��������
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream(file);
			//3.д�����
			fos.write(new String("I lov baby!").getBytes());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	
	
	@Test
	public void test2(){
		File file=new File("d:/io/HelloWord.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte [] b=new byte[20];//��ȡ��������Ҫд�������
			int len; //ÿ�ζ��뵽byte�е��ֽڵĳ���
			while((len=fis.read(b))!= -1){
				/*for(int i=00;i<len;i++){
					System.out.println((char)b[i]);
				}*/
				String str=new String(b,0,len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	// ��Ӳ�̴���һ���ļ��У���ȡ�����ݵ�������
	@Test 
	public void test1() {
		// 2.����һ��FileInputStream��Ķ���
		FileInputStream fis=null;
		try {
			// 1.����File��Ķ���ָ���ļ�·��
			// Ҫ��ȡ���ļ�һ��Ҫ����
			File file1 = new File("d:/io/HelloWord.txt");
			fis = new FileInputStream(file1);
			// 3.����FileInputStream�ķ���ʵ������
			/*
			 * read():��ȡһ���ֽڡ�abcdefg
			 */
			int b;
			while ((b = fis.read()) != -1) {
				/*System.out.print((char) b);
				fis.read();*/
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 4.�ر���Ӧ������
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
