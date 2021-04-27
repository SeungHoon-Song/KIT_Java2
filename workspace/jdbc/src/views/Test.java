package views;

import dao.USER_TBL_DAO;
import vo.USER_TBL_VO;

public class Test {
	public static void main(String[] args) {
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_VO vo = new USER_TBL_VO();
		
		vo.setAge(30);
		vo.setId("hgd");
		vo.setName("홍길동");
		vo.setPhoneNumber("01012345678");
		vo.setPw("1234");
		
		if(dao.join(vo)){
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		
		
//		if(dao.login("ssh", "1234")){
//			System.out.println("로그인 성공");
//			System.out.println(USER_TBL_DAO.session_id+"님 환영합니다.");
//			
//			if(dao.changePw("1234", "1111")) {
//				System.out.println("비밀번호 변경 다시 로그인 해주세요.");
//				dao.logout();
//				
//				if(dao.login("ssh", "1234")){
//					System.out.println("로그인 성공");
//					System.out.println(USER_TBL_DAO.session_id+"님 환영합니다.");
//				}
//				else {
//					System.out.println("로그인 실패");
//				}
//			}else {
//				System.out.println("비밀번호가 잘못되었습니다.");
//			}
			
//			if(dao.delete("1234")) {
//				System.out.println("회원탈퇴 성공");
//				dao.logout();
//			}
//			if(dao.logout()) {
//				System.out.println("로그아웃 성공");
//			}
//			else {
//				System.out.println("로그인 후 이용 바람");
//			}
//		}else {
//			System.out.println("로그인 실패");
//		}
		
//		System.out.println(dao.findId("01050602039", "1111"));
		
//		dao.findPw("ssh", "0105060239");
			
	}
}
