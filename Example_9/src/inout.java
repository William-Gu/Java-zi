import java.io.*;
public class inout {
	public static void main(String arg[]){
		File inputFile=new File("img/a.txt");
		File outputFile=new File("img/b.txt");
		int ch;
		try{
			FileReader in=new FileReader(inputFile);
			FileWriter out=new FileWriter(outputFile);
			System.out.println("Start.");
			while((ch=in.read())!=-1){
				out.write(ch);
			}
			in.close();
			out.close();
			System.out.println("Over.");
		}catch(FileNotFoundException e1){
			System.out.println("Not Found."+e1);
		}catch(IOException e2){
			System.out.println("Read Error:."+e2);
		}
	}
}
