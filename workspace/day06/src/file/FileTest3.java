package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTest3 {
	public static void main(String[] args) throws IOException {
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
//		
//		bw.write("기쁨\n");
//		bw.write("사랑\n");
//		bw.write("행복\n");
//		bw.write("희열\n");
//		bw.close();

		// 추가(이어쓰기)
		// "신남"
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt",true));
//		bw.write("신남");
//		bw.close();

//		// 수정(사랑 -> 슬픔)
//		BufferedReader br = null;
//		String temp = "";
//
//		try {
//			br = new BufferedReader(new FileReader("feeling.txt"));
//			String line = null;
//
//			while ((line = br.readLine()) != null) {
//				//contains() : 포함되어 있는 것 모두
//				//equals() : 정확히 일치하는 것만
//				if(line.equals("사랑")) {
//					temp += "슬픔\n";
//					continue;
//				}
//				temp += line+"\n";
//			}
//		} catch (Exception e) {
//			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//
//		} finally {
//			try {
//				if (br != null) {
//					br.close();
//				}
//			} catch (Exception e) {
//				throw new RuntimeException();
//			}
//		}
//		BufferedWriter bw = new BufferedWriter(new FileWriter("feeling.txt"));
//		
//		bw.write(temp);
//		bw.close();
	
//	//삭제(슬픔 삭제)
//	br = null;
//	temp = "";
//
//	try {
//		br = new BufferedReader(new FileReader("feeling.txt"));
//		String line = null;
//
//		while ((line = br.readLine()) != null) {
//			//contains() : 포함되어 있는 것 모두
//			//equals() : 정확히 일치하는 것만
//			if(line.equals("슬픔")) {
//				continue;
//			}
//			temp += line;
//		}
//	} catch (Exception e) {
//		System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//
//	} finally {
//		try {
//			if (br != null) {
//				br.close();
//			}
//		} catch (Exception e) {
//			throw new RuntimeException();
//		}
//	}
//	bw = new BufferedWriter(new FileWriter("feeling.txt"));
//	
//	bw.write(temp);
//	bw.close();
	
	//전체몰고(Ar<객체>)
		BufferedReader br = null;
		ArrayList<String> contents = null;
		
		try {
			br = new BufferedReader(new FileReader("feeling.txt"));
			contents = new ArrayList<>();
			String line = null;
			
			while((line = br.readLine())!=null) {
				contents.add(line);
			}
			contents.forEach(content -> System.out.println(content));
			
		} catch (Exception e) {
			System.out.println("파일없음");
		}finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		
		

	}

}
