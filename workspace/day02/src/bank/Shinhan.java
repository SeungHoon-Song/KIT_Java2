package bank;

public class Shinhan extends Bank{
	public Shinhan() {
	}
	//출금 시 수수료 50%
	@Override
	boolean output(int money) {
		//출금 수수료가 50%이기 때문에출금할 금액에 1.5배를 부모의 
				money*=1.5;
		return super.output(money);
	}
	
}
