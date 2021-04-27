package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Library {
	private WebDriver driver;
	private String url;

	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\chromedriver.exe";

	public Library() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		driver = new ChromeDriver(options);
		driver = new ChromeDriver();

		url = "https://www.nl.go.kr/";
	}
	
	
	public void operate() {
	      searchBook();
	      //드라이버 종료
	      try {
	         if(driver != null) {
	            driver.close();
	            driver.quit();
	         }
	      } catch (Exception e) {
	         throw new RuntimeException(e.getMessage());
	      }
	   }
	
	
	public void searchBook() {
		Scanner sc = new Scanner(System.in);
		
		WebElement element = null;
		driver.get(url);
		try {   Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		//제목입력 "input-text"
		element = driver.findElement(By.id("main_input-text"));
		
		System.out.print("책 제목 : ");
		element.sendKeys(sc.nextLine());
		element.sendKeys(Keys.RETURN);
		
		try {   Thread.sleep(1000);} catch (InterruptedException e) {;}
		
		
		try {
			//더보기 버튼 존재시
			driver.findElement(By.className("cont_more")).click();
			
			//목록 list_type
			element = driver.findElement(By.className("list_type"));
			//책 번호 row_txt_num
			List<WebElement> listNum = element.findElements(By.className("row_txt_num"));
			
			//책 제목 가져오기 searching_txt
			List<WebElement> titleList = element.findElements(By.className("searching_txt"));
			
			//각종 정보 다 같은 이름의 클래스여서 By.xpath 사용
			List<WebElement> authorList = element.findElements(By.xpath("//span[@class='mr txt_grey']"));
			
			//출력
			int j=0;
			boolean flag;
			for (int i = 0; i < titleList.size(); i++) {
				flag=true;
				System.out.println(listNum.get(i).getText() + ". 제목 : "+titleList.get(i).getText());
				while(flag) {
					System.out.println(authorList.get(j).getText());
					j++;
					if(j%5==4) {
						System.out.println();
						flag=false;
					}
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}
	
		
		
	}
	
	public static void main(String[] args) {
		Library library = new Library();
		library.operate();
	}
}
