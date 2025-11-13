package day1014;

import java.io.IOException;
import java.sql.SQLException;

public class LobService {

	public boolean addFriends(LobDTO lDTO) {
		boolean flag = false;
		
		LobDAO lDAO = LobDAO.getInstance();
		try {
			lDAO.insertFriendsMgr(lDTO);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//addFriends
	
	public LobDTO searchFriend(int num) {
		LobDTO lDTO = null;
		LobDAO lDAO = LobDAO.getInstance();
		try {
			lDTO = lDAO.selectFriends(num);//이 값이 null이면 해당 번호에는 친구가 없다.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lDTO;
	}//searchFriend
	
}//class
