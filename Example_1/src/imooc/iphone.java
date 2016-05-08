package imooc;

public class iphone{
	public static void main(String[] args){
		apple i6=new apple();
		i6.cpu=2.2f;
		i6.send();
		
		IGame ip1=new apple();
		ip1.playGame();
		IGame ip2=new PSP();
		ip2.playGame();
		
		//
		IGame ip3=new IGame(){
			@Override
			public void playGame(){
				System.out.println("匿名内部类 can play game.");	
			}
		};
		ip3.playGame();
		
		//
		new IGame(){
			@Override
			public void playGame(){
				System.out.println("匿名内部类 can play game2.");	
			}
		}.playGame();
	}
}
