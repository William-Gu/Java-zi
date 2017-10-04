package JPanel;
import javax.swing.*;
import java.applet.*;
import java.awt.*;

class MyWindow extends JFrame{
	public MyWindow(int w,int h){
		setTitle("滚动面板");
		Container con=getContentPane();
		con.setPreferredSize(new Dimension(w,h));
		con.setLayout(new BorderLayout());
		JPanel1 p=new JPanel1();
		p.setLayout(new GridLayout(6,6));
		for(int i=0;i<6;i++){
		p.add(new JLabel());
			for(int j=1;j<=2;j++){
				p.add(new JButton("按钮"+(2*i+j)));
				p.add(new JLabel("标签"+(2*i+j)));
			}
			p.add(new JLabel());//空白标签，相当于换行
		}
		p.setBackground(Color.blue);
		p.setPreferredSize(new Dimension(w+260,h+160));
		JScrollPane scrollPane=new JScrollPane(p);
		scrollPane.setPreferredSize(new Dimension(w-60,h-60));
		add(scrollPane,BorderLayout.CENTER);
		setVisible(true);
		pack();
	}
}
class ScrollPane extends JScrollPane{
	public ScrollPane(Component p){
		super(p);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
public class grid extends Applet{
	MyWindow myWindow;
	public void init(){
		myWindow=new MyWindow(400,350);
	}
}