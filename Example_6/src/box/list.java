package box;
import java.applet.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class MyWin extends JFrame implements ListSelectionListener{
	JList list1,list2;
	String news[]={"a","b","c","d"};
	String sports[]={"head","hand","body","foot"};
	JTextArea text;
	MyWin(String s){
		super(s);
		Container con=getContentPane();
		con.setBackground(Color.BLUE);
		con.setLayout(new GridLayout(2,2));
		con.setSize(200,500);
		list1=new JList(news);
		list1.setVisibleRowCount(3);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.addListSelectionListener(this);
		list2=new JList(sports);
		list2.setVisibleRowCount(2);
		list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list2.addListSelectionListener(this);
		con.add(list1);		con.add(list2);
		text=new JTextArea(10,20);
		con.add(text);this.setVisible(true);this.pack();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==list1){
			text.setText(null);
			Object listValue=((JList)e.getSource()).getSelectedValue();
			String selName=listValue.toString();
			for(int i=0;i<news.length;i++){
				if(news[i].equals(selName)){
					text.append(selName+"：被选中\n");
				}
			}
		}else if(e.getSource()==list2){
			text.setText(null);
			int tempList[]=list2.getSelectedIndices();//选中索引
			for(int i=0;i<tempList.length;i++){
				text.append(sports[tempList[i]]+"：被选中\n");
			}
		}
	}
}

public class list extends Applet{
	MyWin myWin=new MyWin("列表示");
}
