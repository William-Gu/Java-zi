import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class html {
	public static void main(String args[]){
		new DownNetFile();
	}
}
class DownNetFile extends JFrame implements ActionListener{
	JTextField inField=new JTextField(30);
	JTextArea showArea=new JTextArea();
	JButton b=new JButton("Download.");
	JPanel p=new JPanel();
	DownNetFile(){
		super("Load Programmer.");
		Container con=this.getContentPane();
		p.add(inField);p.add(b);
		JScrollPane jsp=new JScrollPane(showArea);
		b.addActionListener(this);
		con.add(p, "North");
		con.add(jsp,"Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		readByURL(inField.getText());
	}
	public void readByURL(String urlName){
		try{
			URL url=new URL(urlName);
			URLConnection tc=url.openConnection();
			tc.connect();
			InputStreamReader in=new InputStreamReader(tc.getInputStream());
			BufferedReader dis=new BufferedReader(in);
			String inLine;
			while((inLine=dis.readLine())!=null){
				showArea.append(inLine+"\n");
			}
			dis.close();
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}