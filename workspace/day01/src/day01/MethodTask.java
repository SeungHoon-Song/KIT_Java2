package day01;

public class MethodTask {
	/**
	 * 
	 * @param end
	 * @throws ArithmeticException
	 */
	// 1~n까지의 합을 println()으로 출력하는 메소드
	void printSumFrom1(int end) {
		if (end < 1) {
			throw new ArithmeticException();
		}
		int total = 0;
		for (int i = 0; i < end; i++) {
			total += i + 1;
		}
		System.out.println(total);
	}

	// 나눗셈을 구해주는 메소드
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 * @throws ArithmeticException
	 */
	public int divFor2Integers(int num1, int num2) {
		return num1 / num2;
	}

	public static void main(String[] args) {
		MethodTask task = new MethodTask();
		try {
			task.printSumFrom1(-1);
		} catch (ArithmeticException e) {
			System.out.println("1보다 큰 수를 입력해주세요.");
		}
		try {
			task.divFor2Integers(10, 0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
}
