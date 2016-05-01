package JPanel;
import javax.swing.*;
import java.awt.*;
public class layout {
	public static void main(String args[]){
		JLabel label1,label2,label3,label4,label5;
		JFrame mw=new JFrame("I`m the first Window.");
		
		
		label1=new JLabel("东标签");//默认左
		label2= new JLabel("南标签",JLabel.CENTER);
		label3= new JLabel("西标签");
		label4= new JLabel("北标签",JLabel.CENTER);
		label5= new JLabel("中标签",JLabel.CENTER);
		
		Container con=mw.getContentPane();
		con.setLayout(new BorderLayout());
		
		con.add(label1, "East");
		con.add(label2, "South");
		con.add(label3, "West");
		con.add(label4, "North");
		con.add(label5, "Center");
		
		mw.setSize(250,250);
		mw.setVisible(true);
	}
}
