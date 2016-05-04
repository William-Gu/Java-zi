package box;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

class MenuWindow extends JFrame implements ActionListener{
	public static JTextField text;
	private void addItem(JMenu menu,String menuName,ActionListener listener){
		JMenuItem aItem=new JMenuItem(menuName);
		aItem.setActionCommand(menuName);
		aItem.addActionListener(listener);
		menu.add(aItem);
	}
	public MenuWindow(String s,int w,int h){
		setTitle(s);
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout());
		this.setLocation(100,100);
		this.setSize(w, h);
		JMenu menu1=new JMenu("体育");
		addItem(menu1,"跑步",this);
		addItem(menu1,"器械",this);
		addItem(menu1,"游泳",this);
		JMenu menu2=new JMenu("娱乐");
		addItem(menu2,"唱歌",this);
		addItem(menu2,"跳舞",this);
		addItem(menu2,"游戏",this);
		JMenuBar mBar=new JMenuBar();
		text=new JTextField();
		mBar.add(menu1);
		mBar.add(menu2);
		setJMenuBar(mBar);//向窗口增设惨淡条
		con.add(text, BorderLayout.NORTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text.setText(e.getActionCommand()+"被选中");
	}
	
}

public class menu extends Applet implements ActionListener{
	MenuWindow window;JButton button;boolean bool;
	public void init(){
		button=new JButton("打开我的窗口");
		bool=true;
		window=new MenuWindow("窗口",100,100);
		button.addActionListener(this);
		add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button){
			if(bool){
				window.setVisible(true);
				bool=false;
			}else{
				window.setVisible(false);
				bool=true;
				button.setLabel("打开");
			}
		}
	}

}
