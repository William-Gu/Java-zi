package audio;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class mp3 extends Applet implements Runnable,ActionListener{
	AudioClip clip;
	TextField text;
	Thread thread;
	Button buttonPlay,buttonLoop,buttonStop;
	public void init(){
		thread=new Thread(this);
		thread.setPriority(Thread.MIN_PRIORITY);
		buttonPlay=new Button("Start");
		buttonLoop=new Button("Loop");
		buttonStop=new Button("Stop");
		text=new TextField(12);
		buttonPlay.addActionListener(this);
		buttonLoop.addActionListener(this);
		buttonStop.addActionListener(this);
		add(buttonPlay);
		add(buttonLoop);
		add(buttonStop);
		add(text);
	}
	public void start(){thread.start();}
	public void stop(){clip.stop();}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttonPlay){clip.play();
		}else if(e.getSource()==buttonLoop){clip.loop();}
		if(e.getSource()==buttonStop){clip.stop();}
	}
	public void run(){
		clip=getAudioClip(getCodeBase(),"../audio/a.mp3");
		text.setText("Wait..");
		if(clip!=null){
			buttonPlay.setBackground(Color.red);
			buttonLoop.setBackground(Color.green);
			text.setText("OK");
		}
	}
}
