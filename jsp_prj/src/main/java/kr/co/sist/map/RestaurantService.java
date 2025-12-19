package kr.co.sist.map;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;

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
	
	public String addRestaurant(RestaurantDTO rDTO) {
		JSONObject jsonObj = new JSONObject();
		//ajax의 json으로 값을 넘겨줄거기에 아예 jsonObj로 넘겨도 괜찮음.
		jsonObj.put("resultFlag", false);
		RestaurantDAO rDAO = RestaurantDAO.getInstance();
		try {
			rDAO.insertRestaurant(rDTO);
			jsonObj.put("resultFlag", true);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return jsonObj.toJSONString();
	}
	
}//class
