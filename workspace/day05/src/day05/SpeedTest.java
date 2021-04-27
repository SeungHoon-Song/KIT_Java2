package day05;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SpeedTest {
	public static void main(String[] args) {
		final int SIZE = 10_000_000;
		final List<Integer> arrayList = new ArrayList<Integer>(SIZE);
		final Set<Integer> hashSet = new HashSet<>(SIZE);
		final int data = 9_000_000;
		
		
		//순차 병렬 집계 연산
		IntStream.range(0, SIZE).forEach(value -> {
			arrayList.add(value);
			hashSet.add(value);
		});	
		
		Instant start = Instant.now();
		arrayList.contains(data);
		Instant end = Instant.now();
		long elapsedTime = Duration.between(start, end).toMillis();
//		System.out.println("arrayList search time : "+elapsedTime+"밀리초");
		System.out.println("arrayList search time : "+elapsedTime*0.001+"밀리초");
		
		start = Instant.now();
		hashSet.contains(data);
		end = Instant.now();
		elapsedTime = Duration.between(start, end).toMillis();
//		System.out.println("hashSet search time : "+elapsedTime+"밀리초");
		System.out.println("hashSet search time : "+elapsedTime*0.001+"밀리초");
		
	}
}
