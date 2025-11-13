package day1016;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.pstmt.dao.GetConnection;

public class ZipcodeDAO {
	
	private static ZipcodeDAO zDAO;
	
	private ZipcodeDAO() {
		
	}//ZipcodeDAO
	
	public static ZipcodeDAO getInstance() {
		if(zDAO == null) {
			zDAO = new ZipcodeDAO();
		}//end if
		return zDAO;
	}//end ZipcodeDAO
	
	/**
	 * Statement의 사용
	 * @param dong
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<ZipcodeDTO> useStmtSelectZipcode(String dong) throws SQLException, IOException{
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		//1.드라이버로딩
		//2.커넥션 얻기
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInsance();
		
		try {
			con = gc.getConn();
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.쿼리문 수행후 결과얻기
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode
			.append("	select zipcode, zipcode, sido, gugun, dong, nvl(bunji,' ') bunji	")
			.append("	from  zipcode	")
			.append("	where dong like '").append( dong ).append("%' ");
//			.append("	where dong like '").append( injectionStrBlock(dong) ).append("%' ");
			
			System.out.println( selectZipcode );
			
			rs = stmt.executeQuery(selectZipcode.toString());
			
			ZipcodeDTO zDTO = null;
			while( rs.next() ) {
				zDTO = new ZipcodeDTO(rs.getString("zipcode"),
						rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				
				list.add(zDTO);
			}//end while
		}finally {
		//5.연결 끊기
			gc.dbClose(con, stmt, rs);
		}//end finally
		return list;
	}//useStmtSelectZipcode
	
	/**
	 * 쿼리문에 관련된 문자열을 치환
	 * @param dong
	 * @return
	 */
	public String injectionStrBlock (String dong) {
		String str = dong;
		
		if( !str.isEmpty() ) {
			str.replaceAll(" " , "").replaceAll("union", "").replaceAll("select", "");
		}//end
		
		return str;
	}//injectionStrBlock
	
	/**
	 * PreparedStatement의 사용
	 * @param dong
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<ZipcodeDTO> usePstmtSelectZipcode(String dong) throws SQLException, IOException{
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		//1.드라이버로딩
				//2.커넥션 얻기
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				GetConnection gc = GetConnection.getInsance();
				
				try {
					con = gc.getConn();
				//3.쿼리문 생성객체 얻기
					StringBuilder selectZipcode = new StringBuilder();
					selectZipcode
					.append("	select zipcode, zipcode, sido, gugun, dong, nvl(bunji,' ') bunji	")
					.append("	from  zipcode	")
					.append("	where dong like ?||'%' ");
//					.append("	where dong like '?%' "); //bind변수는 %문자열과 합쳐졌을 때 인식을 못하는 문제가 발생
					
					pstmt = con.prepareStatement(selectZipcode.toString());
					
					//4.바인드변수에 값 설정
					pstmt.setString(1, dong);
					
				//5.쿼리문 수행후 결과얻기
					
					rs = pstmt.executeQuery();
					
					ZipcodeDTO zDTO = null;
					while( rs.next() ) {
						zDTO = new ZipcodeDTO(rs.getString("zipcode"),
								rs.getString("sido"), rs.getString("gugun"),
								rs.getString("dong"), rs.getString("bunji"));
						
						list.add(zDTO);
					}//end while
				}finally {
				//6.연결 끊기
					gc.dbClose(con, pstmt, rs);
				}//end finally
		return list;
	}//usePStmtSelectZipcode
	
	
}//class
