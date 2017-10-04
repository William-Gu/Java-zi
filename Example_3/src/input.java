import java.util.Scanner;
public class input{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("input!");
		int score=input.nextInt();
		System.out.println("input is: " + score);
		Scanner input1=new Scanner(System.in);
		int s=input.nextInt();
		System.out.println("inputs are: " + (score+s));
	}
}
