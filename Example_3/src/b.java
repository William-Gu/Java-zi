abstract class Shape{
	int x,y;
	void MoveTo(int newx, int newy){x=newx;y=newy;}
	Shape(int newx,int newy){x=newx;y=newy;}
	abstract void Draw();
}
class Square extends Shape{
	int len;
	Square(int px,int py,int l){	super(px,py);	len=l;}
	void Draw(){
		System.out.println("正方形");
		System.out.println("x:"+x+",y:"+y);
		System.out.println("l:"+len);
	}
}
class Circle extends Shape{
	int radius;
	Circle(int px,int py,int r){	super(px,py);		radius=r;}
	void Draw(){
		System.out.println("圆形");
		System.out.println("x:"+x+",y:"+y);
		System.out.println("radius:"+radius);
	}
}
class ShapeDraw{
	void draw(Shape obj){	obj.Draw();	}
}
public class b{
	public static void main(String[]args){
		ShapeDraw sd=new ShapeDraw();
		Square s=new Square(10,10,10);
		Circle c=new Circle(30,30,5);
		sd.draw(s);
		sd.draw(c);
	}		
}
