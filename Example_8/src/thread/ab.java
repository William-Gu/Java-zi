package thread;
import java.util.Date;
public class ab {
	static Athread threadA;
	static Bthread threadB;
	public static void main(String[] args){
		threadA=new Athread();
		threadB=new Bthread();
		threadA.start();
		threadB.start();
	}
}
class Athread extends Thread{
	public void run(){
		Date timeNow;
		for(int i=0;i<=5;i++){
			timeNow=new Date();
			System.out.println("A"+timeNow.toString());
			try{
				sleep(2000);
			}catch(InterruptedException e){}
		}
	}
}
class Bthread extends Thread{
	public void run(){
		Date timeNow;
		for(int i=0;i<=5;i++){
			timeNow=new Date();
			System.out.println("B"+timeNow.toString());
			try{
				sleep(1000);
			}catch(InterruptedException e){}
		}
	}
}