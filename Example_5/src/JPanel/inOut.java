package JPanel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class inOut extends Applet implements ActionListener{
	JTextArea textA;
	JTextField textF;
	JButton b1,b2;
	public void init(){
		setSize(250,150);
		textA=new JTextArea("",5,10);
		textA.setBackground(Color.cyan);
		textF=new JTextField("",10);
		textF.setBackground(Color.pink);
		b1=new JButton("求 和");
		b2=new JButton("restart.");
		textF.setEditable(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(textA);add(textF);add(b1);add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1){
			String s=textA.getText();
			StringTokenizer tokens=new StringTokenizer(s);
			int n=tokens.countTokens(),sum=0,i;
			for(i=0;i<=n-1;i++){
				String temp=tokens.nextToken();
				sum+=Integer.parseInt(temp);
			}
			textF.setText(""+sum);
		}else if(e.getSource()==b2){
			textA.setText(null);
			textF.setText(null);
		}
	}

}
