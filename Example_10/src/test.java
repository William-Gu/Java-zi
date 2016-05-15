import java.io.IOException;
import java.net.*;
public class test {
public static void main(String args[]) throws IOException{
	try{
		InetAddress addr=InetAddress.getByName("www.qq.com");
		String domain=addr.getHostName();
		String IPName=addr.getHostAddress();
		System.out.println(domain);
		System.out.println(IPName);
	}catch(UnknownHostException e){
		System.out.println(e);
		e.printStackTrace();
	}
	
	URL mu=new URL("http://www.liba.com");
	System.out.println(mu);
	URLConnection muc=mu.openConnection();
	System.out.println(muc);
}
}
