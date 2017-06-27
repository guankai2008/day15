package com.file.java;
/*
 * java.io.File
 *  1.输入输出相关的类，都定义在java.io.File包下
 *  2.File类的对象于平台无关。路径标识用/斜杠
 *  3.File类的方法只能操作文件名的修改、获取，不能修改具体文件内容。File无法修改文件的内容，必须由io流完成.
 *  4.File中得方法，涉及到创建、删除、重命名等
 *  5.File类的对象创作为作为IO流具体类的构造器形参。
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
		getPath() //返回目录
		getAbsoluteFile() //绝对路径
		getAbsolutePath() //绝对路径
		getParent() //上层目录
		renameTo(File newName) //重命名 file1重名为file2,要求file1存在，file2不存在  file1.reanmeTo(file2)

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
		//file1.renameTo(file2):要求把file1重名为file2,要求file1存在，file2不存在
		System.out.println(file);
		boolean b=file.renameTo(file4);
		System.out.println(b);
		
	}
	/*
	 * 	exists()   //是否存在
		canWrite() //是否可读
		canRead() //是否可写
		isFile()  //是否是文件
		isDirectory()  //是否是文件夹
		lastModified //最后的修改时间
		length() //文本长度
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
	 * 文件相关
	 * createNewFile()
		delete()

	 * 文件夹相关
	 *  mkDir()  //创建指定目录下的目录。
		mkDirs()  //递归创建，目录
		list()  //转为String类型的数据
		listFiles()

	 */
	@Test
	public void test3() throws IOException{
		/*File file1=new File("d:/io/testCreat.txt");
		if(! file1.exists()){
			boolean b=file1.createNewFile();
			System.out.println(b+"创建成功");
		}else{
			boolean b=file1.delete();
			System.out.println(b+"删除成功");
		}*/
		File file2=new File("d:/io/io2/io3");
		if(!file2.exists()){
			boolean b=file2.mkdirs();
			System.out.println(b+"文件夹创建成功");
		}else{
			boolean b=file2.delete();
			System.out.println(b+"文件夹删除成功");
		
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
