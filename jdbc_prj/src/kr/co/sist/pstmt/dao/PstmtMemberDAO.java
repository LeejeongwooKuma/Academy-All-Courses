package kr.co.sist.pstmt.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.statement.dto.MemberDTO;

/**
 * DAO(Data Access Object) : DBMS에 대한 작업만 정의. method명은 SQL문을 넣어서 정의
 * 10-13-2025 : Singleton Pattern을 적용
 */
public class PstmtMemberDAO {

	
private static PstmtMemberDAO pmDAO;
	
	private PstmtMemberDAO() {
		
	}
	
	public static PstmtMemberDAO getInstance() {
		if(pmDAO == null) {
			pmDAO = new PstmtMemberDAO();
		}
		return pmDAO;
	}//
	
	/**
	 * 회원정보를 memeber table에 추가하는 일
	 * @param mDTO추가할 회원정보
	 * @return 추가된 행의 수 1-성공, 0-실패
	 */
	public int insertMember(MemberDTO mDTO) throws SQLException{
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		GetConnection gc = GetConnection.getInsance();
		
		try {
		con = gc.getConn();
			// 3.쿼리문을 설정하여 생성 객체 얻기
			String inserMember = ("insert into member(num,name,age,gender,tel) values(seq_member.nextval,?,?,?,?)");
			pstmt = con.prepareStatement(inserMember);

			// 4.바인드변수에 값 설정
			pstmt.setString(1, mDTO.getName());
			pstmt.setInt(2,  mDTO.getAge());
			pstmt.setString(3, mDTO.getGender());
			pstmt.setString(4, mDTO.getTel());
			//5.쿼리문 수행 후 결과 얻기
			
			rowCnt = pstmt.executeUpdate();
			//이건 try with resource라서 안 해도 되는데 굳이 해봄.
		} catch (IOException ie) {
			ie.printStackTrace();
		}finally {
			gc.dbClose(con, pstmt, null);
		}//end finally
		return rowCnt;
	}// insertMember


	/**
	 * 회원정보를 변경하는 일
	 * 
	 * @param mDTO
	 * @return 0 - 회원번호 없음, 1 - 회원번호로 삭제
	 * @throws SQLException SQLException DBMS에서 문제 발생
	 */
	public int updateMember(MemberDTO mDTO) throws SQLException, IOException {
		int flag = 0;
		
				GetConnection gc = GetConnection.getInsance();
			
				Connection con = null;
				PreparedStatement pstmt = null;
				
				try {
					//1.드라이버로딩
					//2.커넥션얻기
					con = gc.getConn();
					//회원번호를 사용하여 나이, 전화번호를 변경
					StringBuilder updateMember = new StringBuilder();
					updateMember
					.append("	update member	")
					.append("	set age=?, tel=? ")
					.append("	where num=? ");
					// 3.쿼리문 생성 객체 얻기
					pstmt = con.prepareStatement(updateMember.toString());
					
					// 4. 바인드변수에 값 설정
					pstmt.setInt(1, mDTO.getAge());
					pstmt.setString(2, mDTO.getTel());
					pstmt.setInt(3, mDTO.getNum());
					
					// 5. 쿼리문 수행 후 결과 얻기
					
					flag = pstmt.executeUpdate();//변경한 행의 수
//					System.out.println(cnt + "건 변경되었습니다.");
				} finally {
					// 5.연결 끊기
					gc.dbClose(con, pstmt, null);
				} // end finally

		return flag;
	}// updateMember

	/**
	 * 회원정보를 삭제하는 일
	 * 
	 * @param memberNum 삭제할 회원번호
	 * @return 0 - 회원번호 없음, 1 - 회원번호로 삭제
	 * @throws SQLException DBMS에서 문제 발생
	 */
	public int deleteMember(int memberNum) throws SQLException,IOException {
		int flag = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		GetConnection gc = GetConnection.getInsance();
		
		try {
			con =gc.getConn();
			//회원번호를 사용하여 레코드를 삭제
			String deleteMember = "delete from member where num=?";
			// 3.쿼리문 생성 객체 얻기
			pstmt = con.prepareStatement(deleteMember.toString());
			
			// 4. 바인드 변수에 값 설정
			pstmt.setInt(1, memberNum);
			
			// 4.쿼리문 수행 후 결과 얻기
			flag = pstmt.executeUpdate();//변경한 행의 수
		} finally {
			// 5.연결 끊기
			gc.dbClose(con, pstmt, null);
		} // end finally
		return flag;
	}// deleteMember

	/**
	 * 모든 사원 정보를 검색
	 * 
	 * @return 모든 사원 정보
	 * @throws SQLException
	 */
	public List<MemberDTO> selctAllMember() throws SQLException,IOException {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
//		//1.드라이버로딩
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//end catch
//		
//		//2.커넥션얻기
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//		String id = "scott";
//		String pass = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInsance();
		
		try {
			con = gc.getConn();
		//3.쿼리문 생성객체 얻기
			String selectMember = 
					"select num,name,age,gender,tel,input_date from member order by num desc";
			pstmt = con.prepareStatement(selectMember);
		//4. 바인드 변수에 값 설정
		//5.쿼리문 수행 후 결과얻기(cursor의 제어권을 얻을 것)
			//조회결과를 움직일 수 있는 cursor의 제어권을 받음.
//			rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
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
		gc.dbClose(con, pstmt, rs);
		}//end finally
		
		return list;
	}// selctAllMember

	public MemberDTO selectOneMember(int memberNum) throws SQLException,IOException {
		MemberDTO mDTO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		GetConnection gc = GetConnection.getInsance();
		
		try {
			con = gc.getConn();
			StringBuilder selectOneMember = new StringBuilder();
			selectOneMember
			.append("	SELECT NAME, AGE, GENDER, TEL, INPUT_DATE	")
			.append("	FROM MEMBER									")
			.append("	WHERE NUM =?") ;
		//3.쿼리문 생성객체 얻기
			pstmt = con.prepareStatement(selectOneMember.toString());
			
		//4.바인드변수에 값 설정
			pstmt.setInt(1, memberNum);
		//5.쿼리문 수행 후 결과얻기
			
			rs = pstmt.executeQuery();
			
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
			gc.dbClose(con, pstmt, rs);
		}//end finally
		return mDTO;
	}// selctOneMember

}// class
