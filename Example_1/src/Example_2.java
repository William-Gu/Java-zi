import java.applet.*;import java.awt.*;
public class Example_2 extends Applet{
	public void paint(Graphics g){
		g.setColor(Color.blue);
		g.drawString("Hello", 30, 20);
		g.setColor(Color.red);
		g.drawString("World", 30, 50);	
	}
		
}
