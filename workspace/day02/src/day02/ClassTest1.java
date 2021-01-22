package day02;

class A{
	int data1;
	double data2;
	
	void setData1(int data1) {
//		104.data1 = data1;
//		204.data1 = data1;
		
		this.data1 = data1;
		System.out.println("this: "+this);
	}
}

public class ClassTest1 {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		

//		System.out.println(a.data1);
//		System.out.println(b.data1);
		
		System.out.println("a객체: "+a);
		System.out.println("b객체: "+b);
		
		a.setData1(10);	//104번지
		b.setData1(100);//204번지
		
	}
}
