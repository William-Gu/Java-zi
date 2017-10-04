import java.io.*;
import java.net.*;
import java.util.*;

public class server {
	ServerSocket server = null;
	ServerThread thread;
	Socket client = null;while(true)
	{
		try {
			server = new ServerSocket(4331);
		} catch (IOException e1) {
			System.out.println("监听错误" + e1);
		}
		try {
			client = server.accept();
		} catch (IOException e1) {
			System.out.println("正在等待客户时，出错");
		}
		if (client != null) {
			new ServerThread(client).start();
		} else {
			continue;
		}
	}
}

class ServerThread extends Thread{
	Socket socket;String s=null;
	DataOutputStream out=null;
	DataInputStream in=null;
	ServerThread(Socket t){
		socket =t;
		try{
			in=new DataInputStream(t.getInputStream());
			out=new DataOutputStream(t.getOutputStream());
		}catch(IOException e1){}
	}
	public void run(){
		while(true){
			try{s=in.readUTF();
			}catch(IOException e1){System.out.println("Error:"+e1);}
			try{
				if(s.equals("结束")){
					out.writeUTF(s);
					socket.close();
				}else{
					try{out.writeUTF("我是服务器你对我说"+s);
					}catch(IOException e1){}
				}
			}catch(IOException e){}
		}
	}
}