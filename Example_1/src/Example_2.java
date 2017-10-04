import java.applet.*;import java.awt.*;
public class Example_2 extends Applet{
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawString("Hello",20,50);
		g.setColor(Color.yellow);
		g.drawString("World",20,100);
	}
}
