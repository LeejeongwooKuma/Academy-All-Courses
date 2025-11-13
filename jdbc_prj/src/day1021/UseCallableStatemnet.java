package day1021;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.pstmt.dao.GetConnection;

public class UseCallableStatemnet {

	public void useCallable(int num, int num2) throws SQLException, IOException {
		//1.드라이버로딩
		//2.커넥션얻기
		Connection con = null;
		CallableStatement cstmt = null;
		
		GetConnection gc = GetConnection.getInsance();
		try {
			con = gc.getConn();
		//3.쿼리문 실행객체 얻기..plus는 sql에서 만들었던 프리시저.
			cstmt = con.prepareCall("{ call plus(?,?,?,?) }");
		//4.바인드변수 값 설정
			//in parameter
			cstmt.setInt(1, num);
			cstmt.setInt(2, num2);
			//out parameter 등록 (oracle bind변수 사용해야 하는데 자바에서는 쓸 수 없음)
			cstmt.registerOutParameter(3, Types.NUMERIC);
			cstmt.registerOutParameter(4, Types.VARCHAR);
		//5.쿼리문 수행
			cstmt.execute();
		//6.out parameter에 저장된 값 얻기
			int sum = cstmt.getInt(3);
			String msg = cstmt.getString(4);
			
			System.out.println("결과 값 : " + sum);
			System.out.println("메시지 " + msg);
		}finally {
		//7.연결 끊기
			gc.dbClose(con, cstmt, null);
		}//end finally
	}//useCallable
	
	public static void main(String[] args) {
		UseCallableStatemnet ucs = new UseCallableStatemnet();
		try {
			for(int i = 0; i < 1000; i++) {
			ucs.useCallable(10, 21);
			Thread.sleep(500);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//end catch
	}//main

}//class
