package jpanel;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class Panel1 extends JPanel{
	JTextField text1,text2,text3;
	Panel1(){
		text1=new JTextField(10);
		text2=new JTextField(10);
		text3=new JTextField(10);
		setLayout(new GridLayout(1,6));
		add(new JLabel("起始数"));
		add(text1);
		add(new JLabel("终止数"));
		add(text2);
		add(new JLabel("因子"));
		add(text3);
	}
}
class Panel2 extends JPanel{
	JTextArea text;JButton button;
	Panel2(){
		text=new JTextArea(4,10);
		text.setLineWrap(true);
		JScrollPane jsp=new JScrollPane(text);
		button=new JButton("开始计算");
		setLayout(new GridLayout(1,4));
		add(new JLabel("计算结果:",JLabel.RIGHT));
		add(jsp);
		add(new Label());
		add(button);
	}
}


public class cul extends Applet implements ActionListener{
	Panel1 panel1;
	Panel2 panel2;
	public void init(){
		setLayout(new GridLayout(3,1));
		setSize(400,200);
		panel1=new Panel1();
		panel2=new Panel2();
		add(new JLabel("计算从起始数到终止数是因子倍数的数."),JLabel.CENTER);
		add(panel1);add(panel2);
		(panel2.button).addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==(panel2.button)){
			long n1,n2,f;
			n1=Long.parseLong(panel1.text1.getText());
			n2=Long.parseLong(panel1.text2.getText());
			f=Long.parseLong(panel1.text3.getText());
			for(long i=n1;i<=n2;i++){
				if(i%f==0){
					panel2.text.append(String.valueOf(i)+" ");
				}
			}
		}
	}

}
