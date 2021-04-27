package day04;

//카페 등록시 반드시 구현해야하는 메소드가 매장별로 다를 수 있다.
//따라서 무료나눔 카페는 getMenu만 구현
//모든 메소드에 강제성을 없애준다.
public abstract class CafeAdapter implements Cafe{
	@Override
	public String[] getMenu() {
		return null;
	}
	@Override
	public int[] getPrice() {
		return null;
	}
	@Override
	public void sell(String menu) throws Exception {
	}
}
