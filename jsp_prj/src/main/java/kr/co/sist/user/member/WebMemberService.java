package kr.co.sist.user.member;

import java.sql.SQLException;

public class WebMemberService {
	private static WebMemberService wmService;
	
	private WebMemberService() {
		
	}
	
	public static WebMemberService getInstance() {
		if(wmService==null) {
			wmService=new WebMemberService();
		}//end if
		return wmService;
	}
	
	
	public boolean searchId(String id) {
		boolean flag = false;
		
		WebMemberDAO wmDAO = WebMemberDAO.getInstance();
		try {
			flag=wmDAO.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//searchId
}
