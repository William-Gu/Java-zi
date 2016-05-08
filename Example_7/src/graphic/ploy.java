package graphic;
import java.awt.*;
import java.applet.*;
public class ploy extends Applet{
	public void paint(Graphics g){
		setSize(400,500);
//		g.clipRect(0, 0, 200, 50);//限定区域
		int x[]={140,180,170,180,140,100,110,110};
		int y[]={5,25,35,45,65,45,35,25};
		
		Polygon polygon1=new Polygon();
		polygon1.addPoint(50,10);
		polygon1.addPoint(90,50);
		polygon1.addPoint(10,50);
		g.drawPolygon(polygon1);
		g.setColor(Color.yellow);
		Polygon polygon2=new Polygon(x,y,8);
		g.fillPolygon(polygon2);
		
		g.setColor(Color.blue);
		g.fillOval(50,50,100,100);
		g.clearRect(70, 70, 40, 55);//擦除
		
		g.drawRect(10, 160, 60,90);
		g.fillRect(90, 160, 60, 90);
		g.copyArea(10, 160, 90, 70, 5, 90);
	}
}

