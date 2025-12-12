package day0929;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class TestConnection {

	public TestConnection() {
		// 1.드라이버로딩
		try {
//			OracleDriver od = new OracleDriver(); //객체생성해도 됨. 하지만 드라이버는 하나로 관리해야 하는데 객체로는 하나로 관리가 힘들어서 잘 안 함.
			//그리고 객체로 하면 예외도 필요 없음
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2.Connection 얻기
		String url = "jdbc:oracle:thin:@192.168.10.76:1521/orcl";
		String id = "scott";
		String pass = "tiger";
		
		
		try {
			Connection con = DriverManager.getConnection(url, id, pass);
			System.out.println("얻어낸 Connection : " + con);
			
			//db 맛보기로 값 가져와보기.
			PreparedStatement pstmt = con.prepareStatement("select empno from emp");
			ResultSet rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				System.out.println("☆" + rs.getInt("empno") + "☆");
				System.out.println("테스트1");
			}//end while
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
	}// TestConnection

	public static void main(String[] args) {
		new TestConnection();
	}// class

}// main
