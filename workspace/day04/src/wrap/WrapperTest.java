package wrap;

public class WrapperTest {
	public static void main(String[] args) {
		//1. 5.6,'a',"ABC",false
		//위의 5개의 값을 하나의 배열에 넣고 출력하기
		
		//각 요소들은 일반타입이다. 하지만 클래스타입에 들어가기 위해서는
		//클래스타입으로 변환되어야 하고 auto boxing이 된다.
		//각 요소가 클래스 타입을 변환 뒤 모든 클래스의 부모인 Object타입으로
		//up casting되어 들어간다.
		Object[] arObj = {5.6,'a',"ABC",false};
		
	}
}
