import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class in extends JFrame implements ActionListener{
	JTextArea text;BufferedReader in;JButton button;
	FileReader file;
	in(){
		super("缓冲");
		Container con=this.getContentPane();
		con.setSize(100,400);
		con.setLayout(new BorderLayout());
		button=new JButton("读取文件");
		button.addActionListener(this);
		text=new JTextArea(20,30);
		text.setBackground(Color.cyan);
		JScrollPane jsp=new JScrollPane(text);
		con.add(jsp, BorderLayout.CENTER);
		con.add(button, "South");
		this.setVisible(true);
		this.pack();
		try{
			File f=new File("img/a.txt");
			file=new FileReader(f);
			in=new BufferedReader(file);
		}catch(FileNotFoundException e){
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
				while((s=in.readLine())!=null){
					text.append(s+'\n');
				}
			}catch(IOException exp){
				System.out.println(exp);
			}
		}
	}
}
public class huanchong{
	public static void main(String atgs[]){
		in my=new in();
	}
}