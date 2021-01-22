package bank;

public class Kookmin extends Bank{
	public Kookmin() {
	}
	//입금 시 수수료 50%
	@Override
	public void input(int money) {
		//입금한 금액의 50%가 수수료이기 때문에 수수료를 제외한 금액을 부모의 input에 전달
		money*=0.5;
		super.input(money);
	}
}
