package image;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class huan extends Applet implements MouseListener{
	final int number=8;
	int count=0;
	Image[] card=new Image[number];
	public void init(){
		addMouseListener(this);
		for(int i=1;i<number;i++){
			card[i]=getImage(getCodeBase(),"../img/a"+i+".jpg");
		}
	}
	public void paint(Graphics g){
		if((card[count])!=null){
			g.drawImage(card[count], 10, 10, card[count].getWidth(this),card[count].getHeight(this),this);
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		count=(count+1)%number;
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
