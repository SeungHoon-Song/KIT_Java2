package day05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		int total = 0;

		fruitMap.put("사과", 3500);
		fruitMap.put("배", 4000);
		fruitMap.put("자두", 1500);
		fruitMap.put("수박", 8000);

		System.out.println(fruitMap);
		System.out.println(fruitMap.get("수박"));

		// KEY 분리 : keySet()
		Iterator<String> fruitNames = fruitMap.keySet().iterator();

		while (fruitNames.hasNext()) {
			System.out.println(fruitNames.next());
		}
		// Value 분리 : values()

		// 과일 평균 가격 출력
		fruitMap.values().forEach(price -> {
			// 다른 영역의 변수에 연산을 할 수 없다.
			System.out.println(price);
		});

		for (Integer value : fruitMap.values()) {
			total += value;
		}

		double avg = Double.parseDouble(String.format("%.2f", (double) total / fruitMap.size()));

		System.out.println("과일 평균 : " + avg + " 원");

//		int sum = 0;
//		Iterator<Integer> fruitPrices = fruitMap.values().iterator();
//		while(fruitPrices.hasNext()) {
//			sum+=fruitPrices.next();
//		}
//		System.out.println("과일 가격 합:"+sum);
//		int avg = sum/fruitMap.size();
//		System.out.println("과일 "+fruitMap.size()+"개의 평균 값:"+avg);

		// 메뉴판
		// 한 쌍씩 분리(entrySet())

		Iterator<Entry<String, Integer>> iter = fruitMap.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ":" + entry.getValue() + "원");
		}

	}
}
