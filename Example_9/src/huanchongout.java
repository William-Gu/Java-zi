import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class out extends JFrame implements ActionListener{
	JTextArea text;	JButton button;
	BufferedWriter out;
	FileWriter writefile;
	out(){
		super("缓冲");
		Container con=this.getContentPane();
		
		con.setSize(40,40);
		con.setLayout(new BorderLayout());
		button=new JButton("写文件");
		button.addActionListener(this);
		text=new JTextArea(20,30);
		text.setBackground(Color.cyan);
		con.add(text, "Center");
		con.add(button, "South");
		this.setVisible(true);
		this.pack();
		try{
			writefile=new FileWriter("img/c.txt");
			out=new BufferedWriter(writefile);
		}catch(IOException e){
			text.setText("Not find.");
			button.removeActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s;
		if(e.getSource()==button){
			try{
				out.write(text.getText(),0,(text.getText()).length());
				out.flush();
				text.setText(null);
				System.exit(0);
			}catch(IOException exp){
				text.setText("Error!\n");
				System.exit(-1);
			}
		}
	}
}
public class huanchongout{
	public static void main(String atgs[]){
		out my=new out();
	}
}