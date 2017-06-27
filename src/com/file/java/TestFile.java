package com.file.java;
/*
 * java.io.File
 *  1.���������ص��࣬��������java.io.File����
 *  2.File��Ķ�����ƽ̨�޹ء�·����ʶ��/б��
 *  3.File��ķ���ֻ�ܲ����ļ������޸ġ���ȡ�������޸ľ����ļ����ݡ�File�޷��޸��ļ������ݣ�������io�����.
 *  4.File�е÷������漰��������ɾ������������
 *  5.File��Ķ�����Ϊ��ΪIO��������Ĺ������βΡ�
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestFile {
	/*
	 * File getName()
		getPath() //����Ŀ¼
		getAbsoluteFile() //����·��
		getAbsolutePath() //����·��
		getParent() //�ϲ�Ŀ¼
		renameTo(File newName) //������ file1����Ϊfile2,Ҫ��file1���ڣ�file2������  file1.reanmeTo(file2)

	 */
	
	@Test
	public void test1(){
		File file=new File("d:/IO/HelloWorld.txt");
		File file2=new File("hello1");
		File file4=new File("test4");
		File file3=new File("d:/IO/TestIO");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getParent());
		
		System.out.println();
		System.out.println("Path"+file3.getPath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getParent());
		
		System.out.println();
		System.out.println("path: "+file2.getPath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getAbsoluteFile());
		System.out.println(file2.getParent());
		
		//rename(File newName):
		//file1.renameTo(file2):Ҫ���file1����Ϊfile2,Ҫ��file1���ڣ�file2������
		System.out.println(file);
		boolean b=file.renameTo(file4);
		System.out.println(b);
		
	}
	/*
	 * 	exists()   //�Ƿ����
		canWrite() //�Ƿ�ɶ�
		canRead() //�Ƿ��д
		isFile()  //�Ƿ����ļ�
		isDirectory()  //�Ƿ����ļ���
		lastModified //�����޸�ʱ��
		length() //�ı�����
	 */
	@Test
	public void test2(){
		
		File file1=new File("d:/IO/HelloWord.txt");
		File file2=new File("hello1");
		File file3=new File("d:/IO/TestIO");
		
		System.out.println(file1);
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
		
		System.out.println(file3.exists());
		System.out.println(file3.isDirectory());
		System.out.println(file3.isFile());
		System.out.println(file3.length());
		
	}
	/*
	 * �ļ����
	 * createNewFile()
		delete()

	 * �ļ������
	 *  mkDir()  //����ָ��Ŀ¼�µ�Ŀ¼��
		mkDirs()  //�ݹ鴴����Ŀ¼
		list()  //תΪString���͵�����
		listFiles()

	 */
	@Test
	public void test3() throws IOException{
		/*File file1=new File("d:/io/testCreat.txt");
		if(! file1.exists()){
			boolean b=file1.createNewFile();
			System.out.println(b+"�����ɹ�");
		}else{
			boolean b=file1.delete();
			System.out.println(b+"ɾ���ɹ�");
		}*/
		File file2=new File("d:/io/io2/io3");
		if(!file2.exists()){
			boolean b=file2.mkdirs();
			System.out.println(b+"�ļ��д����ɹ�");
		}else{
			boolean b=file2.delete();
			System.out.println(b+"�ļ���ɾ���ɹ�");
		
		}
		System.out.println();
		File file3=new File("d:/io");
		String [] str=file3.list();
		List <String>list=Arrays.asList(str);
		Iterator <String>itr=list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		File [] files=file3.listFiles();
		System.out.println();
		for(int i=0;i<files.length;i++){
			System.out.println(files[i].getName());
		}	
	}		
}
