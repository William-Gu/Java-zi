package com.liba;
import java.awt.Color;
import javax.swing.*;

public class a1 {
	public static void main(String[] arge){
		JFrame mw=new JFrame("I`m thr first window.");
		mw.setBounds(50, 200,300,100);
		mw.setBackground(Color.red);
		mw.setForeground(Color.green);
//		mw.setSize(250,200);
		mw.setResizable(false);
		JButton button=new JButton("I`m the first button.");
		button.setSize(100,100);
		mw.getContentPane().add(button);
		mw.setVisible(true);
	}
}
