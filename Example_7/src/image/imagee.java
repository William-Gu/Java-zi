package image;
import java.applet.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
public class imagee extends Applet{
	Image myImg;
	URL url = null;
	public void start(){
		myImg=getImage(getCodeBase(),"../img/b.jpg");
	}
	public void paint(Graphics g){
		g.drawImage(myImg, 2, 2, this);
		
		try {
			url = new URL("http://www.libaclub.com/public/images/logo.gif");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image img=Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(img, 2, 100, this);
	}
	
}
