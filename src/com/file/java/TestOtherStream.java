package com.file.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

/*
 * ��׼�����
 *    1.System.out.print
 * ��׼������
 * 	  2.Scanner
 */
public class TestOtherStream {
	/*
	 * �Ӽ��������ַ�����Ҫ�󽫶�ȡ���������ַ���ת�ɴ�д�����
	 * Ȼ������������������ֱ�������롰e�����ߡ�exit��ʱ���˳�����
	 * 
	 * 
	 * ������
	 *    1.�Ӽ���������Ҫ�õ�
	 *    2.��������ļ��ŵ�һ���ַ���
	 *    3.ͨ��bufferreader��ȡ����ַ���
	 *    4.����ѭ��while(true)ʵ�ּ��̵����롣
	 *    5.�ж�������Ƿ���e || exit
	 *    6.���ǵĴ�д��ӡ������̨
	 */
	@Test
	public void test2(){
		Scanner s=new Scanner(System.in);
		
		while(true){
			System.out.println("�����ַ���");
			String str=s.nextLine();
			if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
				break;
			}
			System.out.println(str.toUpperCase());
		}
	}
	@Test
	public void test(){
		//��ת�����ַ������󴫸�BufferedReader
		BufferedReader br =null;
		try {
			//����һ���ֽ���������
			InputStream in=System.in;
			//�ֽ���ת��Ϊ�ַ���
			InputStreamReader isr=new InputStreamReader(in);
			br = new BufferedReader(isr);
			String str;
			while(true){
				System.out.println("��������ַ���");
				str=br.readLine();
				if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
					break;
				}
				String str1=str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
}
