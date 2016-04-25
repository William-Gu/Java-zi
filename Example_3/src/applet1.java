import java.applet.*;import java.awt.*;
public class applet1 extends Applet{
	int pos=0;
	public void init(){pos=5;}
	public void start(){repaint();}
	public void stop(){}
	public void paint(Graphics g){
		g.drawString("World", 20, pos+20);	
		pos+=5;
		System.out.println(pos);
	}
	
}


	
