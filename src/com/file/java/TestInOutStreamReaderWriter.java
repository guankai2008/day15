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
 * ת����
 * ���ʵ���ַ������ֽ���֮���ת��
 *     1.���룺 InputStreamReader �ֽ���ת��Ϊ�ַ���
 *         ����  
 *           a.����File�Ķ���
 *           b.����FileInputStream�Ķ���
 *           c.����InputStreamReader��Ķ���
 * 			 e.����BufferedReader�Ķ���
 * 
 */
public class TestInOutStreamReaderWriter {
	
	
	/*
	 * �����ȡ
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
