package com.liba;
import javax.swing.*;
import java.awt.*;//颜色管理
import java.awt.event.*;

public class button {
	public static MyWindowDemo mw1;
	public static MyWindowDemo mw2;
	public static void main(String[] arge){
			JButton butt1=new JButton("I`m the first button.");
			String name1="I`m the first Window.";
			mw1=new MyWindowDemo(name1,butt1,Color.blue,100,200);
			mw1.setVisible(true);
			String name2="I`m the second Window.";
			JButton butt2=new JButton("I`m the second button.");
			mw2=new MyWindowDemo(name2,butt2,Color.magenta,200,100);
			mw2.setVisible(true);
		}
}
class MyWindowDemo extends JFrame{
	public MyWindowDemo(String name,JButton button,Color c,int w,int h){
		super();
		setTitle(name);
		setSize(w,h);
		Container contentPane=getContentPane();
		contentPane.add(button);
		contentPane.setBackground(c);
	}
}