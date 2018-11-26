package Immutable;

//标准API中的几种immutable模式的关键类 不可变的
//String 类  
//大数字的BigInteger 和 BigDecimal
//所有基本类的包装类 Integer Byte...
//在Java中表示正则表达式的java.util.regex.Pattern类 
//表示颜色的Color类
//note:StringBuffer是可变的，可以用StringBuffer作为对象传入String的构造器中
//StringBuffer也同时接收String作为形式参数传入构造器
public class Immuable {

	
	final private int count;
     public Immuable(int count) {
    	 this.count=count;
    	 //blank final 用法
     }
     
     public int get() {
    	 return this.count;
     }
     //当一个类创建完毕之后，如果其状态不再发生变化。这时，该类的方法便可以支持多线程访问，无需声明synchronized关键字
     //类中所有的值在赋值之后便不再改变 final关键字的使用。以及方法中提供了访问字段所需要的get方法，而没有提供修改字段需要的set方法
     
}
