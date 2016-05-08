package image;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class huan1 extends Applet implements Runnable {
	final int number=8;
	int count=0;
	Thread mythread;
	Image[] pic=new Image[number];
	public void init(){
		setSize(300,200);
		for(int i=1;i<=number;i++){
			pic[i-1]=getImage(getCodeBase(),"../img/a"+i+".jpg");
		}
	}
	public void start(){
		mythread=new Thread(this);
		mythread.start();
	}
	public void stop(){
		mythread=null;
	}
	
	public void run() {
		while(true){
			repaint();
			count=(count+1)%number;
			try{mythread.sleep(200);}
			catch(InterruptedException e){}
		}
	}
	public void paint(Graphics g){
		if((pic[count])!=null){
			g.drawImage(pic[count], 10, 10, pic[count].getWidth(this),pic[count].getHeight(this),this);
		}
	}
}
