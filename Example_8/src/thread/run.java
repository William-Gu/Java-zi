package thread;
import java.applet.*;
import java.awt.*;
import javax.swing.*;
public class run extends Applet implements Runnable{
	Thread myThread=null;
	JTextArea t;int k;
	public void start(){
		t=new JTextArea(20,20);
		add(t);
		k=0;
		setSize(500,400);
		if(myThread==null){
			myThread=new Thread(this);
			myThread.start();
		}
	}
	@Override
	public void run() {
		while(myThread!=null){
			try{myThread.sleep(1000);k++;}
			catch(InterruptedException e){}
			repaint();
		}
	}
	public void paint(Graphics g){
		double i=Math.random();
		if(i<0.5){
			g.setColor(Color.yellow);
		}else{
			g.setColor(Color.blue);
		}
		g.fillOval(10, 10, (int)(100*i), (int)(100*i));
		t.append("我在工作，已经休息了"+k+"次");
	}
	public void stop(){
		if(myThread!=null){
			myThread.stop();
			myThread=null;
		}
	}

}
