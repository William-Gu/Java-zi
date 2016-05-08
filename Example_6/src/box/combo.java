package box;
import javax.swing.*;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

class ComBoxDemo extends JFrame implements ActionListener,ItemListener{
	public static final int Width=350;
	public static final int Height=150;
	String List[]={"foot","head","hand"};
	JTextField text;JComboBox combo;
	public ComBoxDemo(){
		setSize(Width,Height);
		setTitle("组合框");
		Container con=getContentPane();
		con.setBackground(Color.BLUE);
		con.setLayout(new FlowLayout());
		combo=new JComboBox(List);
		combo.addActionListener(this);
		combo.addItemListener(this);
		combo.setEditable(true);
		text=new JTextField(10);
		con.add(combo);
		con.add(text);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==combo){
			text.setText(combo.getSelectedItem().toString());
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==combo){
			text.setText(combo.getSelectedItem().toString());
		}
	}

	
	
}
public class combo extends Applet{
	ComBoxDemo myComboBoxGUI=new ComBoxDemo();
}
