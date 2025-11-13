package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day1013.Singleton;
import kr.co.sist.pstmt.dao.GetConnection;
import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.pstmt.service.PstmtMemberService;
import kr.co.sist.statement.dto.MemberDTO;

class PstmtTest {
	@Disabled
	@DisplayName("DAO회원정보 추가테스트")
	@Test
	void testDAO() { 
		PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
		MemberDTO mDTO = new MemberDTO(0, 5, "민병조", "남자", "010-3662-3845", null);
		try {
			assertEquals(pmDao.insertMember(mDTO), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end testDao
	
	@Disabled
	@DisplayName("Service회원정보 전체 조회테스트")
	@Test
	void testSelectAllMember() { 
		PstmtMemberService pms = new PstmtMemberService();
		
		assertEquals(pms.searchAllMember().size(), 7);
		
		//DAO를 사용하여 테스트
		//		assertThrows(Extension.class, ()->pms.searchAllMember());
//		assertDoesNotThrow(()->pms.searchAllMember());//예외가 발생하면 테스트
	}//end testDao
	
	
	@DisplayName("Service회원번호 조회테스트")
	@Test
	void testSelectOneMember() { 
		PstmtMemberService pms = new PstmtMemberService();
		
		assertNotNull(pms.searchOneMember(13));//존재하는 회원
//		assertNull(pms.searchOneMember(100));//존재하지 않는 회원
		
		//DAO를 사용하여 테스트
		//		assertThrows(Extension.class, ()->pms.searchAllMember());
//		assertDoesNotThrow(()->pms.searchAllMember());//예외가 발생하면 테스트
	}//end testDao
	
	
	@Disabled
	@DisplayName("DAO회원정보 변경테스트")
	@Test
	void testUpdateMmember() { 
		PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
		MemberDTO mDTO = new MemberDTO(22, 99, null , null, "010-3662-1111", null);
		try {
			assertEquals(pmDao.updateMember(mDTO), 1);
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}//end testDao
	
	@Disabled
	@DisplayName("DAO회원정보 삭제테스트")
	@Test
	void testDeleteMember() { 
		PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
		try {
			assertEquals(pmDao.deleteMember(22), 1);
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}//end testDao

	@Disabled
	@DisplayName("DB Connection")
	@Test
	void getConnection() {
		GetConnection gc = GetConnection.getInsance();
		try {
			Connection con = gc.getConn();
			assertNotNull(con);
//			assertNull(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end testSingleton

	@Disabled
	@DisplayName("Service회원정보 추가테스트")
	@Test
	void testSingleton() {
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		//객체의 주소가 같은지? (사용연산자 ==을 해야하고 assert method로는 assertSame(객체,객체))
		assertSame(s,s2);
		
		//객체의 주소가 다른지?
//		assertNotSame(s,s2);
		
	}//end testSingleton
	@Disabled
	@DisplayName("Service회원정보 추가테스트")
	@Test
	void testService() {
		PstmtMemberService pms = new PstmtMemberService();
		MemberDTO mDTO = new MemberDTO(0, 6, "집가자", "남자", "010-3662-3845", null);
		assertTrue(pms.addMember(mDTO));
	}//end testService
}
