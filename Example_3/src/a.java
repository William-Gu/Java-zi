import java.applet.*;import java.awt.*;
public class a extends Applet{
 public void paint(Graphics g){
	 g.setColor(Color.orange);
	 g.drawLine(10, 20, 20, 30);
	 g.drawArc(20, 20, 50, 50, 0, 360);
	 g.drawString("OK", 20, 50);
 }
}
