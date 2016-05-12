package thread;

public class huchi {
	public static void main(String[] args){
		MyResourceClass mrc=new MyResourceClass();
		Thread[] aThreadArray=new Thread[20];
		System.out.println("刚开始是："+mrc.getInfo());
		System.out.println("刚预期是："+20*100*500);
		System.out.println("刚正在工作，请稍后");
		for(int i=0;i<20;i++){
			aThreadArray[i]=new Thread(new MyMultiThreadClass(mrc));
			aThreadArray[i].start();
		}
		WhileLoop:
			while(true){
				for(int i=0;i<20;i++){
					if(aThreadArray[i].isAlive()){
						continue WhileLoop;
					}
				}
				break;
			}
		System.out.println("最后结果:"+mrc.getInfo());
		
	}
}
class MyResourceClass{
	int IntegerResource;
	MyResourceClass(){IntegerResource=0;}
	public int getInfo(){return IntegerResource;}
	public void putInfo(int info){IntegerResource=info;}
	synchronized void sumResource(int q){
		int Local;
		Local=getInfo();
		Local+=q;
		putInfo(Local);
	}
}
class MyMultiThreadClass implements Runnable{
	MyResourceClass Use;
	MyMultiThreadClass(MyResourceClass mrc){
		Use=mrc;
	}
	public void run(){
		for(int i=0;i<1000;i++){
			Use.sumResource(50);
			try{Thread.sleep(10);}
			catch(InterruptedException e){}
		}
	}
}