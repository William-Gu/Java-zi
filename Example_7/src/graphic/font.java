package graphic;
import java.awt.*;
import java.applet.*;
public class font extends Applet{
	Font f1=new Font("Helvetica",Font.PLAIN,26);
	Font f2=new Font("宋体",Font.BOLD,24);
	Font f3=new Font("黑体",Font.ITALIC,22);
	Font f4=new Font("PingFang SC",Font.BOLD+Font.ITALIC,20);
	Font f5=new Font("sans-serif",Font.PLAIN,18);
	Font f6=new Font("sans-serif",Font.PLAIN,16);
	public void paint(Graphics g){
		setSize(300,300);
		g.setFont(f1);
		g.drawString("F1哈哈abcdefg",5,30);
		g.setFont(f2);
		g.drawString("F2哈哈abcdefg",5,60);
		g.setFont(f3);
		g.setColor(Color.BLUE);
		g.drawString("F3哈哈abcdefg",5,90);
		g.setFont(f4);
		g.drawString("F4哈哈abcdefg",5,110);
		g.setFont(f5);
		g.drawString("F5哈哈abcdefg",5,130);
		g.setFont(f6);
		g.drawString("F6哈哈abcdefg",5,150);
	}
}
