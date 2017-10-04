package com.liba;
import javax.swing.*;
public class a1 {
	public static void main(String[] arge){
		JFrame mw=new JFrame("I`m the first window.");
		mw.setSize(250,200);
		JButton button=new JButton("I`m the first button.");
		button.setSize(100,100);
		mw.getContentPane().add(button);
		mw.setVisible(true);
	}
}