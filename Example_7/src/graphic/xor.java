package graphic;
import java.awt.*;
import javax.swing.*;


public class xor extends JFrame{
	public static void main(String args[]){
		GraphicsDemo myGraphics=new GraphicsDemo();
	}
}
class ShapesPanel extends JPanel{
	ShapesPanel(){
		setBackground(Color.white);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.yellow);
		g.setXORMode(Color.red);
		g.setColor(Color.green);
		g.fillRect(20, 20, 80, 40);
		g.setColor(Color.yellow);
		g.fillRect(60,20,80,40);
		g.setColor(Color.green);
		g.fillRect(20, 70, 80, 40);
		g.fillRect(60,70,80, 40);
		g.setColor(Color.green);
		g.drawLine(80, 100, 180, 200);
		g.drawLine(100,100,200,200);
		g.drawLine(140, 140, 220, 220);
		g.setColor(Color.yellow);
		g.drawRect(20, 30, 160, 30);
		g.drawRect(20, 75, 160, 75);
	}
}
class GraphicsDemo extends JFrame{
	public GraphicsDemo(){
		this.getContentPane().add(new ShapesPanel());
		setTitle("基本绘图");
		setSize(300,300);
		setVisible(true);
	}
}