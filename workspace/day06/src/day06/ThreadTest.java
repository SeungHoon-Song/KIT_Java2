package day06;

public class ThreadTest {
	public static void main(String[] args) {
		
		Runnable t1 = new Thread2("?");
		Thread2 t2 = new Thread2("!");
		
		//start()메소드로 스케줄링하기 위해서 Thread 타입 객체가 필요하다.
		//Thread생성자에 run메소드가 재정의된 객체를 전달해주면
		//스케줄링 시 해당 run메소드가 자원으로 할당된다.
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		
		
//		//ㅁ + 한자
//		//윈도우 + 마침표
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
//		
////		t1.run();
////		t2.run();
//		
//		t1.start();
//		t2.start();
//		
//		try {
//			//먼저 실행되어야 할 쓰레드에 join()메소드를 사용하면
//			//다른 쓰레드는 전부 대기상태로 전환되며, 해당 쓰레드가 모두 종료되어야
//			//다른 쓰레드가 실행된다.
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			;
//		}
//
//		System.out.println("메인쓰레드 종료");
	}
}
