package day06;

public class Animals implements Runnable{
	
	private String sound;
	
	public Animals() {
		// TODO Auto-generated constructor stub
	}
	
	public Animals(String sound) {
		super();
		this.sound=sound;
	}
	
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(sound);
		}
		
	}
}
