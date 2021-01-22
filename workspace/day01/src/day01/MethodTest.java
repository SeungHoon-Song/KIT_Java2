package day01;

//함수와 메소드의 차이
//함수 : 어떠한 영역에도 갇혀 있지 않다.
//메소드 : 어떠한 영역 내에서 선언 된다.

public class MethodTest {
	//메소드는 반드시 메소드 밖에서 선언하고
	//사용은 메소드 안에서 한다.
	
	//메소드는 저장공간이다.
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	//static
	//1. 가장 먼저 메모리에 할당된다.
	
	public static void main(String[] args) {	//args는 네트워크관련 파라미터를 받는다.
		//add메소드가 호출되었을 때 내부 과정(동작 원리)
		
		System.out.println(new MethodTest().add(5, 9));
	}
}
 