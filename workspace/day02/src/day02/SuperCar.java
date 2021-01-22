package day02;

public class SuperCar extends Car{
	String mode;
	
	public SuperCar(){
		super();
		
	}
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
		//자식에서 재정의된 소스코드로 바뀌기 전에
		//부모의 메소드를 호출하면 효율적으로 재정의를 구현할 수 있게 된다.
		//ex)
		//String data = "안녕";	//부모
		//data += "하세요";		//자식에서 부모의 기능을 그대로 유지한 후 추가한다.
		super.engineStart();
	}
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
		
	}

	void openRoof() {
		System.out.println("뚜껑 열림");
	}
	void closeRoof() {
		System.out.println("뚜껑 닫힘");
	}
}
