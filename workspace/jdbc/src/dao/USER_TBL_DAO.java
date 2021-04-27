package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.USER_TBL_VO;

public class USER_TBL_DAO {
	public static String session_id;
	// String id = "hds";

	// [Statement]
	// String query = "SELECT * FROM USER_TBL WHERE ID = \'" + id +"\'";

	// [PreparedStatement]
	// String query = "SELECT * FROM USER_TBL WHERE ID = ?";
	// pstm.setString(1,id);

	// 암호화 키 ex) 300개 키값을 바꿔 -> 모든 DAO객체에서 키값 하나를 써라(공유)
	private static final int KEY = 3;

	Connection conn; // 접속에 성공한 DB의 연결 객체
	PreparedStatement pstm; // JAVA에서 문자열로 작성한 쿼리문을 저장하고,
							// ?에 필요한 값을 채운 후 쿼리를 실행시켜 준다.
	ResultSet rs; // 조회 결과값을 담을 수 있는 객체

	// 아이디 검사
	public boolean checkId(String id) {
		// COUNT(컬럼명)
		// COUNT(* ): 결과 행의 개수
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE ID = ?";
		boolean check = false;
		try {
			// 커넥션 객체 가져오기
			conn = DBConnector.getConnection();
			// 가져온 커넥션 객체를 통해 prepareStatement 실행 후 pstm객체에 넣기
			pstm = conn.prepareStatement(query);
			// ?에 들어갈 값 설정
			pstm.setString(1, id);
			// 완성된 쿼리문을 실행, 결과가 있다면 rs객체에 넣기
			rs = pstm.executeQuery();

			// 결과 행 1개 불러오기
			rs.next();
			// 첫번째 결과 열 가저오기
			if (rs.getInt(1) == 1) {
				// 아이디 검사 후 존재한다면 1, 존재하지 않으면 0
				check = true;
			}

		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}

		}
		return check;
	}

	// 회원가입(암호화 후 DB추가)
	public boolean join(USER_TBL_VO user) {
		// INSERT
		// 회원 번호는 SEQ 사용
		// USER_SEQ.NEXTVAL : 시퀀스 가져오기
		String query = "INSERT INTO USER_TBL VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)";
		boolean check = false;
		// 사용자가 입력한 아이디를 DB에서 검사한다.

		// view에서 사용
//		if(checkId(user.getId())) {
//			//true일 때 중복이 있다는 뜻
//			return check;
//		}

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			// SELECT외의 INSERT, UPDATE, DELETE 쿼리문은 결과 건수를 가져와 확인하면 된다.
			// executeQuery() : SELECT의 결과를 리턴해주는 메소드(ResultSet)
			// executeUpdat() : UPDATE, INSERT, DELETE의 결과 건수를 리턴해주는 메소드(int)
			int idx = 0;

			pstm.setString(++idx, user.getId());
			pstm.setString(++idx, encrypt(user.getPw()));
			pstm.setString(++idx, user.getName());
			pstm.setInt(++idx, user.getAge());
			pstm.setString(++idx, user.getPhoneNumber());

			if (pstm.executeUpdate() == 1) {
				check = true;

			}
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("join() 알 수 없는 오류");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}

	// 로그인
	public boolean login(String id, String pw) {
		// SELECT COUNT(*) FROM USER_TBL WHERE id = ? AND pw = ?
		String query = "SELECT COUNT(*) FROM USER_TBL WHERE id = ? AND pw = ?";
		boolean check = false;

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();

			// 행
			rs.next();

			// 열
			if (rs.getInt(1) == 1) {
				check = true;
				// 로그인된 회원의 id를 저장
				session_id = id;
			}

		} catch (SQLException e) {
			System.out.println("login() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("login() 알 수 없는 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}

		}
		return check;

	}

	// 로그아웃
	public boolean logout() {
		// 원래 세션 장기간 유지시 끊김
		if (session_id != null) {
			session_id = null;
			return true;
		}
		return false;
	}

	// 마이페이지
	public USER_TBL_VO select(String pw) {

		// view에서 처리할 것
//		if(session_id == null) {
//			return null;
//		}

		USER_TBL_VO user = null;
		String query = "SELECT * FROM USER_TBL WHERE ID = ? AND PW = ?";

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();

			if (rs.next()) {
				user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));
			}

		} catch (SQLException e) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("select() 알 수 없는 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}

		}
		return user;

	}

	// 목록(회원 전체 목록)
	public ArrayList<USER_TBL_VO> selectAll() {
		String query = "SELECT * FROM USER_TBL";
		ArrayList<USER_TBL_VO> userList = new ArrayList<>();
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {
				USER_TBL_VO user = new USER_TBL_VO();
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setAge(rs.getInt("AGE"));
				user.setPhoneNumber(rs.getString("PHONENUMBER"));

				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("selectAll() 알 수 없는 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}

		}
		return userList;
	}

	// 삭제(회원 탈퇴)
	public boolean delete(String pw) {
		String query = "DELETE FROM USER_TBL WHERE ID = ? AND PW = ?";
		boolean check = false;

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			if (pstm.executeUpdate() == 1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("delete() 알 수 없는 오류");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return check;
	}

	// 아이디 찾기
	// 핸드폰 번호와 비밀번호로 아이디 조회
	public String findId(String phoneNumber, String pw) {
		String query = "SELECT ID FROM USER_TBL WHERE PHONENUMBER = ? AND PW = ?";
		String id = "";

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phoneNumber);
			pstm.setString(2, encrypt(pw));

			rs = pstm.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("findId() 알 수 없는 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return id;
	}

	// 수정(비밀번호 변경 : 로그인 된 상태에서)
	// 현재 비밀번호, 새로운 비밀번호
	public boolean changePw(String pw, String new_pw) {
		String query = "UPDATE USER_TBL SET PW = ? WHERE ID = ? AND PW = ?";
		boolean check = false;

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));

			if (pstm.executeUpdate() == 1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("changePw(String, String) 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("changePw(String, String) 알 수 없는 오류");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}

	// 수정(비밀번호 변경 : 임시비밀번호로 변경)
	// 회원번호를 통해 임시비밀번호로 비밀번호 변경
	private void changePw(int user_number, String temp_pw) {
		String query = "UPDATE USER_TBL SET PW = ? WHERE USER_NUMBER = ?";

		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(temp_pw));
			pstm.setInt(2, user_number);

			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("changePw(int, String) 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("changePw(int, String) 알 수 없는 오류");
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	// 비번 찾기(아이디와 핸드폰 번호를 전달 받는다.)
	// 임시비밀번호 6자리 생성(Random)
	// SMS API를 사용하여 JSON으로 데이터 (수신번호, 발신번호, 내용 등)전송
	// 전송된 임시 비밀번호로 UPDATE
	// 본인 핸드폰에 온 문자 확인 후 임시비밀번호 확인
	public void findPw(String id, String phoneNumber) {
		String query = "SELECT USER_NUMBER FROM USER_TBL WHERE ID = ? AND PHONENUMBER = ?";
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, phoneNumber);

			rs = pstm.executeQuery();

			if (rs.next()) {
				// 임시 비밀번호 생성
				Random r = new Random();
				String temp = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_++[] {};:/?";
				String temp_pw = "";

				final int TEMP_PW_LENGTH = 6;
				for (int i = 0; i < TEMP_PW_LENGTH; i++) {
					temp_pw += temp.charAt(r.nextInt(temp.length()));
				}
				// 비밀번호 변경
				changePw(rs.getInt(1), temp_pw);
				System.out.println("test");

				// SMS 문자 전송	ctrl+shift+o 자동 임포트
				String api_key = "NCSYCKSLFGXD4X7E";
				String api_secret = "XGP9JKUCLPFX4AJDFYJVAKFCYILTMFSD";
				Message coolsms = new Message(api_key, api_secret);

				// 4 params(to, from, type, text) are mandatory. must be filled
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("to", "01050602039");
				params.put("from", "01050602039");
				params.put("type", "SMS");
				params.put("text", "[테스트]\n임시 비밀번호:"+temp_pw+"\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
				params.put("app_version", "JAVA SDK v2.2"); // application name and version

				try {
					JSONObject obj = (JSONObject) coolsms.send(params);
					System.out.println(obj.toString());
				} catch (CoolsmsException e) {
					System.out.println(e.getMessage());
					System.out.println(e.getCode());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char) (pw.charAt(i) * KEY);
		}
		return en_pw;
	}
}
