package imooc;
class A{
	  A(){System.out.println("我是父类不带参数的构造方法");}
	  A(int i){System.out.println("我是父类带参数i的构造方法");}
}
class B extends A{
	B(){
//		super(10);
		System.out.println("我是子类B");}
}
public class i5{
	public static void main(String  args[]){
		   B b=new B();
	}
}
