package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest2 {
	public static void main(String[] args) throws IOException{
		//MAC(EUC-KR)
//		String contents = new String(Files.readAllBytes(Paths.get("test.txt")),"EUC-KR");
		String contents = new String(Files.readAllBytes(Paths.get("test.txt")));
		
		System.out.println(contents);
		System.out.println((contents.split("\r\n")[0]));
	}
}
