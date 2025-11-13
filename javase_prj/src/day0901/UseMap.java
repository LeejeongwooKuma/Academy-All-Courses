package day0901;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * KVP ( Key Value Pair ) 키와 값의 쌍으로 이루어진 자료구조
 */
public class UseMap {

	/**
	 * 동기화 x, 16개의 행 자동 생성
	 */
	public void useHashMap() {
		// 1.생성)
		Map<String, String> map = new HashMap<String, String>();

		// 2. 값 할당)- 입력되는 값은 순서대로 추가되지 않는다.
		// 키가 존재하지 않으면 추가되고, 키가 존재하면 덮어씌운다.
		map.put("java", "완벽한 OOP언어");
		map.put("Oracle", "대용량데이터를 처리하기 적합한 DBMS");
		map.put("JDBC", "Java와 DBMS를 연동하기 위한 저수준 API");
		map.put("HTML", "웹 프로그램에서 구조를 담당");

		// 키가 존재하면 기존의 key에 값을 덮어 쓴다.

		map.put("java", "WORA - 한번작성에 어떤 OS환경에서는 소스코드 수정없이 사용가능.");

		System.out.println("값얻기");
		String key = "java";
		System.out.println(key + "가 존재하니? " + map.containsKey(key));
		String value = map.get(key);
		System.out.println(key + "에 대한 값 : " + value);

		if (value != null) {// 키로 검색된 값이 존재하
			System.out.println(key + "에 대한 값 : " + value);
		}

		key = "Java";
		System.out.println(key + "가 존재하니? " + map.containsKey(key));

		if (map.containsKey(key)) {// 키가 존재하면 map에서 값을 얻는다.
			value = map.get(key);
			System.out.println(key + "에 대한 값 : " + value);
		} // end if

		System.out.println(map.size() + "/" + map);

		// 맵의 모든 키를 얻어서 모든 값을 얻을 수 있다.
		Set<String> keySet = map.keySet();
		System.out.println("키셋 : " + keySet);

		Iterator<String> ita = keySet.iterator();
		Iterator<String> ita2 = keySet.iterator();

		// 맵의 모든 키와 값을 콘솔에 출력해보세요. 키 / 값

		while (ita.hasNext()) {
			// pointer에 관련된 method는 한번 호출하면 다음으로 이동한다. 밑의 식은 한 번 실행에 2번 이동 시켜서 망했다.
//			System.out.println(ita.next() + " / " + map.get(ita.next()));
			key = ita.next();// 포인터는 한 번만 이동시키고
			System.out.println(key + " / " + map.get(key));// 값을 얻는다.
		} // end while

		// 맵의 값 삭제
		System.out.println("삭제 전 : " + map.size() + " / " + map);
		map.remove("java");
		System.out.println("삭제 후 : " + map.size() + " / " + map);
		map.clear();
		System.out.println("삭제 후 : " + map.size() + " / " + map);

	}// useHashMap

	/**
	 * 동기화 O, 11개의 행 자동 생성
	 */
	public void useHashTable() {
		// 1.생성)
		Map<String, String> map = new Hashtable<String, String>();

		// 2. 값 할당)- 입력되는 값은 순서대로 추가되지 않는다.
		// 키가 존재하지 않으면 추가되고, 키가 존재하면 덮어씌운다.
		map.put("java", "완벽한 OOP언어");
		map.put("Oracle", "대용량데이터를 처리하기 적합한 DBMS");
		map.put("JDBC", "Java와 DBMS를 연동하기 위한 저수준 API");
		map.put("HTML", "웹 프로그램에서 구조를 담당");

		System.out.println(map);
	}// useHashTable

	public static void main(String[] args) {

		UseMap um = new UseMap();
		um.useHashMap();
		System.out.println("----------------");
		um.useHashTable();

	}// main

}// clss
