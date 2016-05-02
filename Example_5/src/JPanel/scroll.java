
package jpanel;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

class MyPanel extends JPanel{
	JButton button1,button2;
	JLabel label;
	MyPanel(String s1,String s2,String s3,Color c){
		button1=new JButton(s1);
		button2=new JButton(s2);
		label=new JLabel(s3);
		setBackground(c);
		add(button1);add(button2);add(label);
	}
}

public class scroll extends Applet{
	MyPanel panel1,panel2;
	JButton button;
	public void init(){
		panel1=new MyPanel("sure?","cancel","In Panel 1.",Color.blue);
		panel2=new MyPanel("sure?","cancel","In Panel 2.",Color.red);
		button=new JButton("I`m not in Panel.");
		add(panel1);add(panel2);add(button);
		setSize(300,200);
	}
}
