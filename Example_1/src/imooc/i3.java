package imooc;
import java.applet.*; 
import javax.swing.*;
import java.awt.event.*;
public class i3 extends Applet implements ActionListener{
    JTextField text1,text2;
    JButton button1,button2;  JLabel label1;
    public void init(){
      text1=new JTextField(12);text2=new JTextField(12);
      button1=new JButton("比较");button2=new JButton("重置");
      label1=new JLabel("此处显示比较结果");
      add(text1);add(text2);add(button1);add(button2);add(label1);
      text1.requestFocus();//将光标自动定位到第一个文本框
      button1.addActionListener(this);button2.addActionListener(this);
   }
   public void actionPerformed(ActionEvent e){
   //请在以下位置编写代码
		if(e.getSource()==button1){
			 if(text1.getText().equals(text2.getText())){
			    label1.setText("两个字符串相同");
			 }else{
				 label1.setText("两个字符串不同");
			 }
		}else if(e.getSource()==button2){
		   text1.setText(null);
		   text2.setText(null);
		}
   }  
 }
