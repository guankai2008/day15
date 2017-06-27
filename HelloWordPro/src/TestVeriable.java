/*
 * 1.定义格式   类型  变量名 = 初始化值
 */
public class TestVeriable {

	 public static void main (String[] args){
		 int myInt=10;
		 double doubNum=23.3;
		 System.out.println(myInt);
		 System.out.println(doubNum+myInt);
		 char c1 = '\ua234';
		 char c2 = 'a';
	     System.out.println(c1+c2);
	     String st1="我是一个中国人";
	     String str2="他是个狗";
	     System.out.println(st1+'\t'+str2);
	     System.out.println(st1+c2+myInt);
	     System.out.println(c2+myInt+st1);
	     System.out.println(myInt+st1+c2);
	
	 }
}
