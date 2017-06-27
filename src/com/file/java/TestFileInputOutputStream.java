package com.file.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

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
public class TestFileInputOutputStream {
	
	@Test
	public void testCopyFile(){
		long start=System.currentTimeMillis();
		String from="d:/io/ytg.rmvb";
		String to="d:/io/ytg2.rmvg";
		copyFile(from,to);
		long end=System.currentTimeMillis();
		System.out.println("花费时长"+(end-start));
	}
	
	
	public void copyFile(String from,String to){
		
		//1.创建读入和写入的两个地址
		File file1=new File(from);
		File file2=new File(to);
		//2.创建两个流的对对象
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
		//1.创建读入和写入的两个地址
		File file1=new File("d:/io/test5.png");
		File file2=new File("d:/io/test6.png");
		//2.创建两个流的对对象
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
	 * 从一个文件读取后，写入到另个文件
	 */
	@Test
	public void testFileInputStreamFileOutputStream(){
		//1读取和写入的文件
		File file1=new File("d:/io/test5.png");
		File file2=new File("d:/io/test6.png");
		//2.创建响应的刘
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			fis=new FileInputStream(file1);
			fos=new FileOutputStream(file2);
			//3.实现文件的复制
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
	 * 输出
	 */
	@Test
	public void testout(){
		//1.创建一个存储数据的文件。
		//输出的这个物理文件可以不存在，当执行过程中如果不存在，可以自动创建。若存在会将原来的的文件覆盖。
		File file =new File("d:/io/HelloWord.txt");
		//2 创建一个outputStream流的对象，将File的对象已形参的形式传给它。
		FileOutputStream fos=null;
		try{
			fos=new FileOutputStream(file);
			//3.写入操作
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
			byte [] b=new byte[20];//读取到的数据要写入的数组
			int len; //每次读入到byte中的字节的长度
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
	
	
	
	
	
	
	
	
	
	
	
	// 从硬盘存在一个文件中，读取其内容到程序中
	@Test 
	public void test1() {
		// 2.创建一个FileInputStream类的对象。
		FileInputStream fis=null;
		try {
			// 1.创建File类的对象，指明文件路径
			// 要读取的文件一定要存在
			File file1 = new File("d:/io/HelloWord.txt");
			fis = new FileInputStream(file1);
			// 3.调用FileInputStream的方法实现输入
			/*
			 * read():读取一个字节。abcdefg
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
			// 4.关闭相应的流。
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
