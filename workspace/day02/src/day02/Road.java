package day02;

import java.util.Random;

public class Road {
//	null은 아직 어떤 주소값을 할당할 지 모를때 쓰는 주소 초기값이다.
//	선언 후 누적연결 사용 시 초기화 방법	
//	String data = "";
//	선언 후 대입 사용 시 초기화 방법	
//	String data1 = null;
//	
//	data1 = "10";
//	data1 += "안녕";
	public static void main(String[] args) {
		//[casting]
		Car matiz = new Car();
		SuperCar ferrari = new SuperCar();
		
		//up casting
		Car noOptionFerrari = new SuperCar();
		
		//down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
//		fullOptionFerrari.openRoof();
		
		//SuperCar brokenFerrari = (SuperCar)new Car();	//오류(casting exception)
		
		System.out.println(matiz instanceof Car);
		System.out.println(matiz instanceof SuperCar);
		System.out.println(ferrari instanceof Car);
		System.out.println(ferrari instanceof SuperCar);
		
		System.out.println(noOptionFerrari instanceof Car);
		System.out.println(noOptionFerrari instanceof SuperCar);
		
		System.out.println(fullOptionFerrari instanceof Car);
		System.out.println(fullOptionFerrari instanceof SuperCar);
		
		
//		SuperCar ferrari = new SuperCar();
//		ferrari.brand = "FERRAI";
//		ferrari.color = "RED";
//		ferrari.price = 30000;
//		
//		ferrari.engineStart();
//		ferrari.engineStop();
		
//		Car myCar = new Car("벤틀리","white",30000);
//		Car dadyCar = new Car("벤츠","black",15000);
//		Car momCar = new Car("yellow",50000);
		
	}
}
