package kr.co.sist.map;

import java.sql.SQLException;
import java.util.List;

public class RestaurantService {
	private static RestaurantService rs;
	
	private RestaurantService() {
		
	}
	
	public static RestaurantService getInstance() {
		if(rs == null) {
			rs=new RestaurantService();
		}//end if
		return rs;
	}//getInstance
	
	public List<RestaurantDTO> searchRestaurant(String id) {
		List<RestaurantDTO> list = null;
		
		RestaurantDAO rDAO = RestaurantDAO.getInstance();
		try {
			list = rDAO.selectAllRestaurant(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		
		return list;
	}//searchRestaurant
	
}//class
