package jpanel;
import java.applet.*;//小应用程序
import java.awt.*;//创建用户界面和绘制图形图像的所有分类
import java.awt.event.*;//事件
import javax.swing.*;//应用程序用户界面的开发工具包1

class MyPanel extends JPanel{
	int x;
	JLabel label;
	MyPanel(int i){
		x=i;
		getSize();
		label=new JLabel("I`m the "+x+" label.");
		add(label);
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,50);
	}
}

public class card extends Applet implements ActionListener{
	CardLayout mycard;
	MyPanel myPanel[];
	JPanel p;
	private void addButton(JPanel pan,String butName,ActionListener listener){
		JButton aButton=new JButton(butName);
		aButton.setActionCommand(butName);
		aButton.addActionListener(listener);
		pan.add(aButton);
	}

	public void init(){
		setLayout(new BorderLayout());//小程序边界布局
		mycard=new CardLayout();
		this.setSize(400,150);		
		p=new JPanel();
		p.setLayout(mycard);
		
		myPanel=new MyPanel[10];
		for(int i=0;i<=10;i++){
			myPanel[i]=new MyPanel(i);
			p.add("A"+i,myPanel[i]);
		}
		
		JPanel p2=new JPanel();
		addButton(p2,"First",this);
		addButton(p2,"Last",this);
		addButton(p2,"Previous",this);
		addButton(p2,"Next",this);
		
		add(p,"Center");
		add(p2,"South");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("First")){
			mycard.first(p);
		}else if(e.getActionCommand().equals("Last")){
			mycard.last(p);
		}else if(e.getActionCommand().equals("Previous")){
			mycard.previous(p);
		}else if(e.getActionCommand().equals("Next")){
			mycard.next(p);
		}
	}
}
