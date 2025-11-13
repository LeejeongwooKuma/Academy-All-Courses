package day1021;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.pstmt.dao.GetConnection;
import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.statement.dto.MemberDTO;
import oracle.jdbc.internal.OracleTypes;

/**
 * DAO(Data Access Object) : DBMS에 대한 작업만 정의. method명은 SQL문을 넣어서 정의
 * 10-13-2025 : Singleton Pattern을 적용
 */
public class CstmtMemberDAO {

	
private static CstmtMemberDAO pmDAO;
	
	private CstmtMemberDAO() {
		
	}
	
	public static CstmtMemberDAO getInstance() {
		if(pmDAO == null) {
			pmDAO = new CstmtMemberDAO();
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
		CallableStatement cstmt = null;
		GetConnection gc = GetConnection.getInsance();
		
		try {
		con = gc.getConn();
			// 3.쿼리문을 설정하여 생성 객체 얻기
			cstmt=con.prepareCall("{call insert_member(?,?,?,?,?,?)}");
			
			// 4.바인드변수에 값 설정
			//in parameter
			cstmt.setString(1, mDTO.getName());
			cstmt.setInt(2,  mDTO.getAge());
			cstmt.setString(3, mDTO.getGender());
			cstmt.setString(4, mDTO.getTel());
			
			//out parameter
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			
			//5.쿼리문 수행 후 결과 얻기
			
			cstmt.execute();
			
			//6.out parameter에 설정된 값 얻기
			rowCnt = cstmt.getInt(5);
			String msg = cstmt.getString(6);
			System.out.println(rowCnt+" / " + msg);
			//이건 try with resource라서 안 해도 되는데 굳이 해봄.
		} catch (IOException ie) {
			ie.printStackTrace();
		}finally {
			gc.dbClose(con, cstmt, null);
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
				CallableStatement cstmt = null;
				
				try {
					//1.드라이버로딩
					//2.커넥션얻기
					con = gc.getConn();
					//회원번호를 사용하여 나이, 전화번호를 변경
					// 3.쿼리문 생성 객체 얻기
					cstmt = con.prepareCall("{call update_member(?,?,?,?,?)}");
					
					// 4. 바인드변수에 값 설정
					//in parameter
					cstmt.setInt(1, mDTO.getAge());
					cstmt.setString(2, mDTO.getTel());
					cstmt.setInt(3, mDTO.getNum());
					
					//out parameter
					cstmt.registerOutParameter(4, Types.NUMERIC);
					cstmt.registerOutParameter(5, Types.VARCHAR);
					
					// 5. 쿼리문 수행 후 결과 얻기
					
					cstmt.execute();//변경한 행의 수
					
					// 6.out parameter 저장된 값 얻기
					flag = cstmt.getInt(4);
					String msg = cstmt.getString(5);
					System.out.println(flag + "건 변경되었습니다.\n에러 메시지 : " + msg);
				} finally {
					// 5.연결 끊기
					gc.dbClose(con, cstmt, null);
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
		CallableStatement cstmt = null;
		
		GetConnection gc = GetConnection.getInsance();
		
		try {
			con=gc.getConn();
			//회원번호를 사용하여 레코드를 삭제
			// 3.쿼리문 생성 객체 얻기
			cstmt = con.prepareCall("{call delete_member (?,?,?)}");
			
			
			// 4. 바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, memberNum);
			
			
			//out parameter
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			
			// 4.쿼리문 수행 후 결과 얻기
			cstmt.executeUpdate();//변경한 행의 수
			
			//5. out parameter의 값 얻기
			flag = cstmt.getInt(2);
			String msg = cstmt.getString(3);
			System.out.println(flag + "건 삭제되었습니다.\n에러 메시지 : " + msg);
		} finally {
			// 5.연결 끊기
			gc.dbClose(con, cstmt, null);
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
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInsance();
		try {
			con = gc.getConn();
		//3.쿼리문 생성객체 얻기
//			String selectMember = 
//					"select num,name,age,gender,tel,input_date from member order by num desc";
			cstmt = con.prepareCall("{call select_all_member(?)}");
		//4. 바인드 변수에 값 설정
			cstmt.registerOutParameter(1, Types.REF_CURSOR);
		//5.쿼리문 수행 후 결과얻기(cursor의 제어권을 얻을 것)
			//조회결과를 움직일 수 있는 cursor의 제어권을 받음.
//			rs = pstmt.executeQuery();
			cstmt.execute();
			
			//6.out parameter의 값 받기.
			rs = (ResultSet)cstmt.getObject(1);
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
		gc.dbClose(con, cstmt, rs);
		}//end finally
		
		return list;
	}// selctAllMember
	
	public int removeMember(int memberNum) {
		int flag = 0;
		try {
			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			flag = pmDao.deleteMember(memberNum);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반활될 수 있고, 그 경우에는 1로 재설정한다.
		}catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			flag = 2;
			e.printStackTrace();
		}// end catch
		
		return flag;
	}//removeMember

	public MemberDTO selectOneMember(int memberNum) throws SQLException,IOException {
		MemberDTO mDTO = null;
		Connection con = null;
//		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		GetConnection gc = GetConnection.getInsance();
		
		try {
			con = gc.getConn();
//			StringBuilder selectOneMember = new StringBuilder();
//			selectOneMember
//			.append("	SELECT NAME, AGE, GENDER, TEL, INPUT_DATE	")
//			.append("	FROM MEMBER									")
//			.append("	WHERE NUM =?") ;
		//3.쿼리문 생성객체 얻기
			cstmt = con.prepareCall("{call select_one_member(?,?)}");
			
		//4.바인드변수에 값 설정
			//in parameter
			cstmt.setInt(1, memberNum);
			
			//outparameter
			cstmt.registerOutParameter(2, Types.REF_CURSOR);
		//5.쿼리문 수행 후 결과얻기
			
//			rs = pstmt.executeQuery();
			// 5.쿼리문 수행
			cstmt.execute();
			
			//6. out parameter에 저장된 값 받기
			rs=(ResultSet) cstmt.getObject(2);
			
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
			gc.dbClose(con, cstmt, rs);
		}//end finally
		return mDTO;
	}// selctOneMember

}// class
