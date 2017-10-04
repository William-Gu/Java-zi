package box;
import javax.swing.*;import java.awt.*;import java.awt.event.*;import java.applet.*;
class MyScrollBar extends JScrollBar{
	public MyScrollBar(int init,int len,int low,int high){
		super(JScrollBar.HORIZONTAL,init,len,low,high);
	}
	public Dimension getPreferredSize(){
		return Dimension(125,20);
	}
}

class MyWindowScroll extends JFrame implements ActionListener,AdjustmentListener{
	private JButton button;
	private JTextField text;
	private boolean barOpened;
	MyWindowScroll(String s){
		super(s);
		MyScrollBar tempBar=new MyScrollBar(10,10,0,255);
		Container con=this.getContentPane();
		con.setLayout(new GridLayout(2,1));
		this.setSize(200,100);
		this.setLocation(100,100);
		button=new JButton("开闭滚动条");
		button.addActionListener(this);
		barOpened=false;
		tempBar.addAdjustmentListener(this);//类接口
		text=new JTextField("滚动条关闭",20);
		con.add(button);con.add(text);con.add(tempBar);
		this.setVisible(true);this.pack();
	}
	public void adjustmentValueChanged(AdjustmentEvent e) {//接口方法
		if(barOpened){
			MyScrollBar myBar=(MyScrollBar)e.getAdjustable();
			text.setText("选择值的是:"+myBar.getValue());
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
			if(barOpened){
				text.setText("滚动条关闭");
				barOpened=false;
			}
			else{
				text.setText("滚动条打开");
				barOpened=true;
			}
		}
	}
}
public class scroll{
	public static void main(String[] args){
		MyWindowScroll myWindow=new MyWindowScroll("滚动条实例");		
	}
}
