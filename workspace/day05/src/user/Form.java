package user;

public class Form {
	public static void main(String[] args) {
		UserField uf = new UserField();
		
		User user = new User();
		String msg= null;
		
		user.id = "hds1234";
		user.pw = "4321";
		
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
		msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
//		if(uf.join(user)) {
//			System.out.println("회원가입 성공");
//		}
//		else {
//			System.out.println("회원가입 실패");
//		}
		
		msg = uf.login("hds1234", "4321") ? "로그인 성공" : "로그인 실패";	
		System.out.println(msg);
		
		
		
	}
}
