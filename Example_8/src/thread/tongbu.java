package thread;
import java.applet.*;
public class tongbu extends Applet{
	static SalesLady salesLady=new SalesLady(14,0,0);
	public void start(){
		int moneies[]={10,10,5,10,5,10,5,5,10,5,10,5,5,10,5};
		Thread[] aThreadArray=new Thread[20];
		System.out.println("Start");
		for(int i=0;i<moneies.length;i++){
			aThreadArray[i]=new Thread(new CustomerClass(i+1,moneies[i]));
			aThreadArray[i].start();
		}
		WhileLoop:
			while(true){
				for(int i=0;i<moneies.length;i++){
					if(aThreadArray[i].isAlive()){
						continue WhileLoop;
					}
				}
				break;
			}
		System.out.println("Over.");
	}
}
class CustomerClass{
	int num,money;
	public void run(){
		try{Thread.sleep(100);}
		catch(InterruptedException e){}
		System.out.println("我是"+num+"号顾客，用"+money+"元购物，售货员说"+tongbu.salesLady.ruleForSale(num,money));
		
	}
	CustomerClass(int n,int m){num=n;money=m;}
}
class SalesLady{
	int mem,five,ten;
	public synchronized String ruleForSale(int num,int money){
		String s=null;
		if(mem==0){
			return "Sorry,sale out.";
		}
		if(money==5){
			mem--;five++;
			s="给你一个，钱正好";
		}else if(money==10){
			while(five<1){
				try{
					System.out.println(""+num+"号顾客用10元购票，等待！");
					wait();
				}catch(InterruptedException e){}
			}
			mem--;five-=1;ten++;
			s="给你一个，给了10元，找你5元。";
		}
		notify();
		return s;
	}
	SalesLady(int m,int f,int t){
		mem=m;five=f;ten=t;
	}
}