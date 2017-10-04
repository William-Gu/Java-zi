package imooc;import java.util.Scanner;

class Student{
	int sno;
	String name;
	int age;
	String department;
	void display(){
		System.out.println("学号:"+sno+",姓名:"+name+",年龄："+age+",专业:"+department);
	}
	void setValue(int sno,String name,int age,String department){
		this.sno=sno;
		this.name=name;
		this.age=age;
		this.department=department;
	}
}
public class i4 {
  public static void main(String args[]){
      int sno;
      String name;
      int age;
      String department;
      
      Scanner s=new Scanner(System.in);
      sno=s.nextInt();
      name=s.next();
      age=s.nextInt();
      department=s.next();
      
	  Student stu1=new Student();
      stu1.setValue(sno, name, age, department);
      stu1.display();
  }
}