import java.io.*;
public class random {
	public static void main(String argsp[]){
		RandomAccessFile inOut=null;
		long data[]={151,278,235,206,-170,32,43,21,83,47};
		try{
			inOut=new RandomAccessFile("img/longData.txt","rw");
			for(int i=0;i<data.length;i++){
				inOut.writeLong(data[i]);
			}
			for(int i=data.length-1;i>=0;i--){
				inOut.seek(i*8);
				System.out.println(" "+inOut.readLong()+((i==0)?"\n":","));
			}
			inOut.close();
		}catch(FileNotFoundException e1){
			System.out.println("File not Found. "+e1);
		}catch(IOException e2){
			System.out.println("Read Error. "+e2);	
		}
	}
}
