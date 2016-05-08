package imooc;

public class apple implements IGame{
	float cpu;
	void send(){
		System.out.println("apple can tel.Cpu: "+cpu);
	}
	@Override
	public void playGame(){
		System.out.println("apple can play game.");
	}
}
