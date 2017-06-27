package com.java.review;

/*
 * �ֽ������ļ������ı���
 *  
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class ReviewInOutStream {
	/*
	 * �ļ�����
	 */
	@Test
	public void copyFile(){
		long start =System.currentTimeMillis();
		testInOutputStream("d:/io/ytg.rmvb","d:/io/ytg2.rmvb");
		long end=System.currentTimeMillis();
		System.out.println("���ƻ���ʱ��"+(end-start));
	}
	
	
	public void testInOutputStream(String str1,String str2){
		File file1=new File(str1);
		File file2=new File(str2);
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			fis=new FileInputStream(file1);
			fos=new FileOutputStream(file2);
			byte [] b=new byte[1048576];
			int len;
			while((len=fis.read(b))!= -1){
				fos.write(b, 0, len);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null){
				try{
					
					fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/*
	 * �ַ���ͨ��byte�ķ�ʽд�뵽�ı�
	 */
	@Test
	public void testOutputStream() {
		File file1 = new File("d:/io/outTest.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file1);
			fos.write("I love baby".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	/*
	 * review FileInputSteam
	 */
	@Test
	public void testInput() {
		
		File file1 = new File("d:/io/Hello.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file1);
			byte[] b = new byte[5];
			int len;
			while ((len = fis.read(b)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.print((char) b[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}
