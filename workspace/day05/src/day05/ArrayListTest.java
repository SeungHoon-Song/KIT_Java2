package day05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
		// 알고리즘 : 문제를 해결하기 위한 절차
		// 자료구조 : 여러 알고리즘이 모여 구조화가 되어있는 것
		// 의미없는 데이터가 자료구조를 통과하면 하나의 정보가 된다.
		// 10 : 의미 없는 값
		// int age = 10 : 자료구조

		ArrayList<Integer> datas = new ArrayList<>();

//		datas.add(10);
		datas.add(80);
		datas.add(90);
		datas.add(50);
		datas.add(60);
		datas.add(70);
		datas.add(20);
		datas.add(30);

		System.out.println(datas.size());
//		System.out.println(datas.get(7));

		Collections.sort(datas);
		System.out.println(datas);

		// CRUD
		// Create
		// Read
		// Update
		// Delete

		int idx = 0;
		String msg = null;
		
		// 추가 (40추가)
		datas.add(40);
		// 삽입 (10뒤에 15 삽입)
		idx = datas.indexOf(10);
		if (datas.contains(10)) {
			datas.add(idx+1, 15);
			msg = "추가 성공: "+datas.toString();
		}else {
			msg = "추가 실패 : 값을 찾지 못하였습니다.";
		}
		System.out.println(msg);
		// 수정 (20을 200으로 수정)
		idx = datas.indexOf(20);
		if (datas.contains(20)) {
			msg = (datas.set(idx, 200)+"이 변경 되었습니다.");
			msg +="수정 성공 : "+datas.toString();
		}else {
			msg = "수정 실패 : 찾는 값이 없습니다.";
		}
		System.out.println(msg);
		// 삭제 (50 삭제)
		if(datas.remove(new Integer(50))){
			msg = "삭제 성공 : "+datas.toString();
		}else {
			msg = "삭제 실패";
		}
		System.out.println(msg);
		
		ArrayList<Integer> datas2 = new ArrayList<>();
		datas2.add(10);
		datas2.add(30);
		datas2.add(40);
		datas2.add(50);
		datas2.add(10);
		datas2.add(20);
		datas2.add(10);
		
		//마지막 10을 삭제한다.
		System.out.println(datas2.lastIndexOf(10));
		
		//두번째 10을 삭제한다.
		//1. 정렬 후 10을 찾고 + 1번째 인덱스
		//2. 정렬하지 않고
		
		//값만 필요할때
//		for(int data:datas2) {
//			
//		}
		//찾는 값이 여러 개 있을 때 각 값의 인덱스 번호를 저장할 List
		ArrayList<Integer> idxs = new ArrayList<>();
		
		for(int i = 0; i<datas2.size(); i++) {
			//10이라는 값일 때 idxs에 인덱스 번호를 저장
			if(datas2.get(i) == 10) {
				idxs.add(i);
			}
		}
//		System.out.println(idxs);	
		
		try {
			//remove(int idx)를 사용하기 위해서는 Integer를 int로 unboixing 해야 한다.
			//따라서 idxs.get(1).intValue()를 통해 int타입으로 inboxing을 해주면,
			//remove(int idx)로 인식되어 해당 인덱스에 있는 값이 삭제된다.
			datas2.remove(idxs.get(1).intValue());
			System.out.println(datas2);
			
		} catch (Exception e) {
			//잘못된 인덱스 번호 전달 시
			System.out.println("존재하지 않는 인덱스입니다.");
		}
		

	}
}
