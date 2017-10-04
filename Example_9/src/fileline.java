import java.io.*;
public class fileline {
	public static void main(String argsp[]){
		try{
			RandomAccessFile file=new RandomAccessFile("img/a.txt","rw");
			long fileCurPos=0;
			long fileLength=file.length();
			int line=0;
			while(fileCurPos<fileLength){
				String s=file.readLine();
				
				System.out.println("Line"+line+":"+s);
				fileCurPos=file.getFilePointer();
				System.out.println(fileCurPos);//字符位置
				line+=1;
			}
			file.close();
		}catch(FileNotFoundException e1){
			System.out.println("File not Found. "+e1);
		}catch(IOException e2){
			System.out.println("Read Error. "+e2);	
		}
	}
}
