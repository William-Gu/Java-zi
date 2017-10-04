package box;
import java.awt.*;import java.awt.event.*;import javax.swing.*;

class mouseWindow extends JFrame{
	public mouseWindow(String s){
		super(s);
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		con.setLocation(100,100);
		JScrollBar x=new JScrollBar(JScrollBar.HORIZONTAL,50,1,0,100);
		JScrollBar y=new JScrollBar(JScrollBar.VERTICAL,50,1,0,100);
		MyListener listener=new MyListener(x,y,238,118);
		JPanel scrolledCanvas=new JPanel();
		scrolledCanvas.setLayout(new BorderLayout());
		scrolledCanvas.add(listener,BorderLayout.CENTER);
		scrolledCanvas.add(x,BorderLayout.SOUTH);
		scrolledCanvas.add(y,BorderLayout.EAST);
		con.add(scrolledCanvas, BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
	}
}
class MyListener extends JComponent implements MouseListener,MouseMotionListener,AdjustmentListener{
	private int x,y;
	private JScrollBar xBar;
	private JScrollBar yBar;
	private void updateBars(int x,int y){
		int d;
		d=(int)(((float)x/(float)getSize().width)*100.0);
		xBar.setValue(d);
		d=(int)(((float)x/(float)getSize().height)*100.0);
		yBar.setValue(d);
	}
	public MyListener(JScrollBar xa,JScrollBar ya,int x0,int y0){
		xBar=xa;
		yBar=ya;
		x=x0;y=y0;
		xBar.addAdjustmentListener(this);
		yBar.addAdjustmentListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	public void paint(Graphics g){
		g.setColor(getBackground());Dimension size=getSize();
		g.fillRect(0, 0, size.width, size.height);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==xBar){
			x=(int)((float)xBar.getValue()/100.0)*getSize().width;
		}else if(e.getSource()==yBar){
			y=(int)((float)yBar.getValue()/100.0)*getSize().height;
		}
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();y=getY();
		updateBars(x,y);
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		x=e.getX();y=getY();
		updateBars(x,y);
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {}
	
}
public class mouse {
	public static void main(String[] args){
		mouseWindow mouseW=new mouseWindow("滚动条程序");
	}
}
