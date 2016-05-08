package com.liba;
import javax.swing.*;
import java.awt.*;//颜色管理
import java.awt.event.*;
public class listener {
	public static void main(String[] args){
		ButtonDemo myButtonGUI=new ButtonDemo();
		myButtonGUI.setVisible(true);
	}
}
class ButtonDemo extends JFrame implements ActionListener{
	public static final int Width=250;
	public static final int Height=250;
	ButtonDemo(){
		setSize(Width,Height);
		setTitle("按钮事件");
		Container conPane=getContentPane();	//1.获取面板
		conPane.setBackground(Color.BLUE);	//设置面板颜色
		conPane.setLayout(new FlowLayout());//FlowLayout布局
		
		JButton redBut=new JButton("Red");	//2.新建按钮
		JButton greenBut=new JButton("Green");
		redBut.addActionListener(this);		//3.添加监听器，this指向myButtonGUI
		greenBut.addActionListener(this);
		conPane.add(redBut);				//4.面板上添加按钮
		conPane.add(greenBut);
	}
	public void actionPerformed(ActionEvent e){//接口处理事件
		Container conPane=getContentPane();
		if(e.getActionCommand().equals("Red")){//11.获取事件命令，Red按钮
			conPane.setBackground(Color.RED);  //12.设置面板为相应颜色
		}else if(e.getActionCommand().equals("Green")){
			conPane.setBackground(Color.GREEN);
		}
	}
}
