import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
public class filechoose {
	public static void main(String args[]){
		FrameFileDialog f=new FrameFileDialog();
	}
}
class FrameFileDialog extends JFrame implements ActionListener{
	JFileChooser filedialog=null;
	JLabel label=new JLabel(",JLAbel.CENTER");
	JButton b1,b2;
	JTextArea text;
	FrameFileDialog(){
		super("对话框");
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout());
		con.setSize(40,50);
		JPanel p=new JPanel();
		b1=new JButton("open");
		b2=new JButton("save");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p.add(b1);p.add(b2);
		text=new JTextArea(20,30);
		JScrollPane jsp=new JScrollPane(text);
		filedialog=new JFileChooser("../test");
		filedialog.setControlButtonsAreShown(true);
		filedialog.addChoosableFileFilter(new MyFileFilter("text"));
		filedialog.addChoosableFileFilter(new MyFileFilter("java"));
		text.setBackground(Color.cyan);
		con.add(jsp, BorderLayout.CENTER);
		con.add(label, BorderLayout.NORTH);
		con.add(p, BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();
	}
	public void actionPerformed(ActionEvent e) {
		File file=null;
		int result;
		if(e.getSource()==b1){
			filedialog.setDialogTitle("OPEN FILE");
			result=filedialog.showOpenDialog(this);
			text.setText("");
			if(result==JFileChooser.APPROVE_OPTION){
				file=filedialog.getSelectedFile();
				label.setText("you choosen file:"+file.getName());
			}else if(result==JFileChooser.CANCEL_OPTION){
				label.setText("you do not choosen file.");
			}
			FileInputStream fileStream=null;
			if(file!=null){
				try{
					fileStream=new FileInputStream(file);
				}catch(FileNotFoundException nfe){
					label.setText("File was not Found.");
					return;
				}
				int readByte;
				try{
					while((readByte=fileStream.read())!=-1){
						text.append(String.valueOf((char)readByte));
					}
					fileStream.close();
				}catch(IOException ie){
					label.setText("Error");
				}
			}
		}else if(e.getSource()==b2){
			filedialog.setDialogTitle("SAVE FILE");
			result=filedialog.showSaveDialog(this);
			file=null;String fileName;
			if(result==JFileChooser.APPROVE_OPTION){
				file=filedialog.getSelectedFile();
				label.setText("you choosen file:"+file.getName());
			}else if(result==JFileChooser.CANCEL_OPTION){
				label.setText("you do not choosen file.");
			}
			FileOutputStream fileStream=null;
			if(file!=null){
				try{
					fileStream=new FileOutputStream(file);
				}catch(FileNotFoundException nfe){
					label.setText("File was not Found.");
					return;
				}
				String content=text.getText();
				try{
					fileStream.write(content.getBytes());
					fileStream.close();
				}catch(IOException ie){
					label.setText("Error");
				}
			}
		}
		
	}
}
class MyFileFilter extends FileFilter{
	String ext;
	MyFileFilter(String t){ext=t;}
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory()){return true;}
		String fn=file.getName();
		int index=fn.lastIndexOf(". ");
		if(index>0&&index<fn.length()-1){
			String extension=fn.substring(index+1).toLowerCase();
			if(extension.equals(ext)){return true;}
		}
		return false;
	}
	public String getDescription(){
		if(ext.equals("java")){return "JAVA Source File(*.java)";}
		if(ext.equals("txt")){return "Txt File(*.txt)";}
		return "";
	}
}