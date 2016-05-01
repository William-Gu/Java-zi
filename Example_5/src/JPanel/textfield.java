package JPanel;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
public class textfield extends Applet{
	static JTextField text1,text2,text3;
	static JTextArea area1;
	Sqr s=new Sqr();
	public void init(){
		text1=new JTextField(10);
		text2=new JTextField(10);
		text3=new JPasswordField(10);
		
		add(text1);
		add(text2);
		add(text3);
		
		text1.addActionListener(s);
		text2.addActionListener(s);
		
		area1=new JTextArea("hh",10,3);
		area1.setLineWrap(true);
		add(area1);
	}
}
class Sqr implements ActionListener{
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==textfield.text1){
			long n=Long.parseLong(textfield.text1.getText());
			textfield.text2.setText(String.valueOf(n*n));
		}
	}
}
