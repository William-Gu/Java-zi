package graphic;
import java.awt.*;
import java.applet.*;
public class color extends Applet{
	public void paint(Graphics g){
		setSize(600,200);
		for(int i=0;i<=10;i++){
			Color myRed=new Color(i*25+5,0,0);
			g.setColor(myRed);
			g.fillRect(i*32+5, 2, 28, 28);
		}
		for(int i=0;i<=10;i++){
			Color myGreen=new Color(0,i*25+5,0);
			g.setColor(myGreen);
			g.fillRect(i*32+5, 32, 28, 28);
		}
		for(int i=0;i<=10;i++){
			Color myBlue=new Color(0,0,i*25+5);
			g.setColor(myBlue);
			g.fillRect(i*32+5, 62, 28, 28);
		}
		g.drawLine(5, 100, 100, 110);
		g.drawLine(5, 120, 5, 120);
		g.drawRect(5, 125, 20, 20);
		g.fillRect(30, 125, 20, 20);
		g.drawRoundRect(60, 125, 40, 40, 30, 30);
		g.drawRoundRect(100, 125, 40, 40, 40, 40);
		g.draw3DRect(170, 125, 40, 40, true);
		g.fill3DRect(210, 125, 40, 40, true);
		g.drawOval(250, 125, 20, 50);
	}
}
