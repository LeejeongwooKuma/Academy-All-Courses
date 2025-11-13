package kr.co.sist.statement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.statement.dto.MemberDTO;

/**
 * DAO(Data Access Object) : DBMS에 대한 작업만 정의. method명은 SQL문을 넣어서 정의
 * 10-13-2025 : Singleton Pattern을 적용
 */
public class MemberDAO {

	
	
	/**
	 * 회원정보를 memeber table에 추가하는 일
	 * 
	 * @param mDTO 추가할 회원정보
	 */
	public void insertMember(MemberDTO mDTO) throws SQLException {
		// 1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2.로딩된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;
		try {
//		try {
			con = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
//			String insertMmember 
//			= "insert into member(num,name,age,gender,tel) values(seq_member.nextval,'"+ mDTO.getName()+"',"+
//			mDTO.getAge()+",'"+mDTO.getGender()+"','"+mDTO.getTel()+"')";
			StringBuilder inserMember = new StringBuilder();
			inserMember.append("insert into member(num,name,age,gender,tel) values(seq_member.nextval,'")
					.append(mDTO.getName()).append("',").append(mDTO.getAge()).append(",'").append(mDTO.getGender())
					.append("','").append(mDTO.getTel()).append("')");

			// 4.쿼리문 수행 후 결과 얻기
			int cnt = stmt.executeUpdate(inserMember.toString());
			System.out.println(cnt + "건 추가되었습니다.");
		} finally {
			// 5.연결 끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}//end catch

	}// insertMember


	/**
	 * 회원정보를 변경하는 일
	 * 
	 * @param mDTO
	 * @return 0 - 회원번호 없음, 1 - 회원번호로 삭제
	 * @throws SQLException SQLException DBMS에서 문제 발생
	 */
	public int updateMember(MemberDTO mDTO) throws SQLException {
		int flag = 0;
		
		// 1.드라이버로딩
				try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} // end catch

				// 2.로딩된 드라이버를 사용하여 커넥션 얻기
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				String id = "scott";
				String pass = "tiger";
				Connection con = null;
				Statement stmt = null;
				
				try {
					con = DriverManager.getConnection(url, id, pass);
					// 3.쿼리문 생성 객체 얻기
					stmt = con.createStatement();
					
					//회원번호를 사용하여 나이, 전화번호를 변경
					StringBuilder updateMember = new StringBuilder();
					updateMember
					.append("	update member	")
					.append("	set age=").append(mDTO.getAge()).append(",tel='")
					.append(mDTO.getTel()).append("'")
					.append("	where num=").append(mDTO.getNum());
					
					// 4.쿼리문 수행 후 결과 얻기
					flag = stmt.executeUpdate(updateMember.toString());//변경한 행의 수
//					System.out.println(cnt + "건 변경되었습니다.");
				} finally {
					// 5.연결 끊기
					if (stmt != null) {
						stmt.close();
					} // end if
					if (con != null) {
						con.close();
					} // end if
				} // end finally
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}//end catch


		return flag;
	}// updateMember

	/**
	 * 회원정보를 삭제하는 일
	 * 
	 * @param memberNum 삭제할 회원번호
	 * @return 0 - 회원번호 없음, 1 - 회원번호로 삭제
	 * @throws SQLException DBMS에서 문제 발생
	 */
	public int deleteMember(int memberNum) throws SQLException {
		int flag = 0;

		// 1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2.로딩된 드라이버를 사용하여 커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			
			//회원번호를 사용하여 레코드를 삭제
			StringBuilder deleteMember = new StringBuilder();
			deleteMember
			.append("	delete from member	")
			.append("	where num=").append(memberNum);
			
			// 4.쿼리문 수행 후 결과 얻기
			flag = stmt.executeUpdate(deleteMember.toString());//변경한 행의 수
			System.out.println(flag + "건 삭제되었습니다.");
		} finally {
			// 5.연결 끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally
		
		return flag;
	}// deleteMember

	/**
	 * 모든 사원 정보를 검색
	 * 
	 * @return 모든 사원 정보
	 * @throws SQLException
	 */
	public List<MemberDTO> selctAllMember() throws SQLException {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		//2.커넥션얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("셀올");
			con = DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.쿼리문 수행 후 결과얻기(cursor의 제어권을 얻을 것)
			String selectMember = 
					"select num,name,age,gender,tel,input_date from member order by num";
			//조회결과를 움직일 수 있는 cursor의 제어권을 받음.
			rs = stmt.executeQuery(selectMember);
			
			int num = 0;//회원번호
			String name = "";//회원명
			int age = 0;//회원 나이
			String gender = "";//성별
			String tel = "";// 전화번호
			Date inputDate = null;// 입력일
			MemberDTO mDTO = null;
			
			//db의 레코드 개수를 알 수 없음.
			while(rs.next()) {//조회결과에 다음 레코드가 존재하는지?
				num = rs.getInt("num");
				name = rs.getString("name");
				age = rs.getInt("age");
				gender = rs.getString("gender");
				tel = rs.getString("tel");
				inputDate = rs.getDate("input_date");
//				System.out.println(num + " / " + name + " / " + age + " / " + gender + " / " + tel + " / " + inputDate);
				//조회결과값을 하나로 묶어서 관리하기 DTO(VO. VO는 수정x.) 생성 저장. 
				mDTO = new MemberDTO(num, age, name, gender, tel, inputDate);
//				System.out.println(mDTO);//mDTO의 toString을 Overriding
				//같은 이름의 객체가 사라지지 않게 List에 추가
				list.add(mDTO);
			}//end while
		}finally {
		//5.연결 끊기
		if( rs != null ) { rs.close(); }//end if
		if( stmt != null ) { stmt.close(); }//end if
		if( con != null ) { con.close(); }//end if
		}//end finally
		
		return list;
	}// selctAllMember

	public MemberDTO selectOneMember(int memberNum) throws SQLException {
		MemberDTO mDTO = null;
		
		//1.드라이버 로딩
		try {
			System.out.println("셀원");
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.커넥션 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.쿼리문 수행 후 결과얻기
			StringBuilder selectOneMember = new StringBuilder();
			selectOneMember
			.append("	SELECT NAME, AGE, GENDER, TEL, INPUT_DATE	")
			.append("	FROM MEMBER									")
			.append("	WHERE NUM =").append(memberNum);
			
			rs = stmt.executeQuery(selectOneMember.toString());
			
			if( rs.next() ) {//쿼리로 인한 조회 결과가 존재.
				mDTO = new MemberDTO();
				mDTO.setNum(memberNum);
				mDTO.setName(rs.getString("name"));
				mDTO.setAge(rs.getInt("age"));
				mDTO.setGender(rs.getString("gender"));
				mDTO.setTel(rs.getString("tel"));
				mDTO.setInput_date(rs.getDate("input_date"));
			}
		//3.쿼리문 생성객체 얻기
		
		//4.쿼리문 수행 후 결과 얻기
		}finally {
		//5.연결 끊기
			if( rs != null ) { rs.close(); }//end if
			if( stmt != null ) { stmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally
		return mDTO;
	}// selctOneMember

}// class
