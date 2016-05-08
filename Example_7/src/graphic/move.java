package graphic;
import java.applet.*;
import java.awt.*;

public class move extends Applet {
	int i=1;
	public void init(){
		setBackground(Color.yellow);
	}
	public void paint(Graphics g){
		i=i+8;
		if(i>160){
			i=1;
		}
		g.setColor(Color.red);
		g.fillRect(i, 10, 20, 20);
		g.drawString("Goog", 100, 100);
		try {Thread.sleep(100);}
		catch(InterruptedException e){}
		repaint();
	}
	public void update(Graphics g){
		g.clearRect(i, 10, 200, 100);
		paint(g);
	}

}
