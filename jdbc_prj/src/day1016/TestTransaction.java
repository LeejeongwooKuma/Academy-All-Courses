package day1016;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.pstmt.dao.GetConnection;

public class TestTransaction {
	
	private Connection con = null;
	private GetConnection gc;
	
	public int insertTransaction(String name, String address) throws SQLException, IOException{
		int totalCnt = 0;
		gc = GetConnection.getInsance();
		
		con = gc.getConn();
		//auto commit이 해제 되어야한다.
		con.setAutoCommit(false);
		
		//1. DB작업 수행
		String insertTransaction 
		= "insert into test_transaction(name,address)values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertTransaction);
		pstmt.setString(1, name);
		pstmt.setString(2, address);
		int rowCnt = pstmt.executeUpdate();
		
		//2. DB작업 수행
		String insertTransaction2 
		= "insert into test_transaction2(name,address)values(?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertTransaction2);
		pstmt2.setString(1, name);
		pstmt2.setString(2, address);
		int rowCnt2 = pstmt2.executeUpdate();
		
		totalCnt = rowCnt + rowCnt2;
		return totalCnt;
	}//insertTransaciton
	
	public void useInsertTransaction() {
		String name = "민병조2";
		String addr = "대치동에 살고싶어요!";
		
		try {
			int totalCnt = insertTransaction(name,addr);
			
			if(totalCnt == 2) {//목표한 행수라면
				System.out.println("회원 정보가 추가되었습니다.");
				con.commit();//트랜잭션을 정상적으로 완료
			}//end if
			
		} catch (SQLException e) {
			try {
				System.out.println("회원 정보가 취소되었습니다.");
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//end catch
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				gc.dbClose(con, null, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end finally
		
		
	}//useInsertTransaction
	
	public static void main(String[] args) {
		TestTransaction tt = new TestTransaction();
		tt.useInsertTransaction();
		
		
	}//main

}//class
