package day06;

public class Zoo {
	public static void main(String[] args) {
		
		Animals dog = new Animals("멍멍");
		Animals cat = new Animals("야옹");
		Animals tiger = new Animals("어흥");
		
		Thread a1 = new Thread(dog);
		Thread a2 = new Thread(cat);
		Thread a3 = new Thread(tiger);
		
		a1.start();
		a2.start();
		try {
			a1.join();
			a2.join();
		} catch (InterruptedException e) {
			;
		}
		a3.start();
		
			
	}
}
