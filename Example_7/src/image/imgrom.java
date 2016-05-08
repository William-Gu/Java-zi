package image;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.*;
public class imgrom extends Applet{
	Image myPicture;
	public void init(){
		myPicture = getImage(getCodeBase(),"../img/b.jpg");
		Image offScreenImage=createImage(size().width,size().height);
		Graphics offScreenGc=offScreenImage.getGraphics();
		offScreenGc.drawImage(myPicture, 0, 0, this);
		new BufferedDemo(myPicture);
	}
	public boolean imageUpdate(Image img,int infoFlg,int x,int y,int w,int h){
		if(infoFlg==ALLBITS){repaint();		return false;
		}else{return true;	}
	}
}
class BufferedDemo extends JFrame{
	public BufferedDemo(Image img){
		this.getContentPane().add(new PicPanel(img));
		setTitle("缓冲");
		setSize(300,300);
		setVisible(true);
	}
}
class PicPanel extends JPanel implements MouseListener,MouseMotionListener{
	int x=0,y=0,dx=0,dy=0;
	BufferedImage bimg1,bimg2;
	boolean upState=true;
	public PicPanel(Image img){
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		bimg1=new BufferedImage(img.getWidth(this),img.getHeight(this),BufferedImage.TYPE_INT_ARGB);
		bimg2=new BufferedImage(img.getWidth(this),img.getHeight(this),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D1=bimg1.createGraphics();
		Graphics2D g2D2=bimg2.createGraphics();
		g2D1.drawImage(img, 0, 0, this);
		g2D2.drawImage(img, 0, 0, this);
		g2D2.drawRect(1, 1, img.getWidth(this)-3, img.getHeight(this)-3);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;
		if(upState){
			g2D.drawImage(bimg1, x, y, this);
		}else{			
			g2D.drawImage(bimg2, x, y, this);
		}
	}
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!upState){
			x=e.getX()-dx;
			y=e.getY()-dy;
			repaint();
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>=x&&e.getX()<x+bimg1.getWidth(this)&&e.getY()>=y&&e.getY()<y+bimg1.getHeight(this)){
			upState=false;
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			dx=e.getX()-x;
			dy=e.getY()-y;
			repaint();
		}
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		upState=true;
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}