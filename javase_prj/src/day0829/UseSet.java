package day0829;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색기능 x, 중복값 저장x, 값은 순서대로 입력되지 않음. ->유일한 값 저장이 필요할 때
 */
public class UseSet {
	public UseSet() {
		//1.생성
		Set<String> set = new HashSet<String>();
		//2.값 할당 - 순서대로 입력되지 않는다.
		set.add("Java");
		set.add("Oracle");
		set.add("JDBC");
		set.add("HTML");
		set.add("CSS");
		set.add("Java"); //중복값은 덮어씌우지 저장하지는 않는다.
		
		//3.값 얻기) - 향상된 for 쓰면 itarator안쓰고도 가능.
//		System.out.println(set.get(0));//검색의 기능이 없다.
		Iterator<String> ita = set.iterator();
		String element="";
		while(ita.hasNext()) { //안에 내용물이 있는지 없는지 모르니 다음 값 있니?로 구별.가변길이라 모를수박에.
			element = ita.next();
			System.out.println(element);
		}//end while
		
		System.out.println("--개선된 for");
		for( String temp : set ) {
			System.out.println(temp);
		}
		
		
		//배열로 복사
		String[] strArr = new String [set.size()];
		set.toArray(strArr);

		//삭제
		set.remove("JDBC");
		set.clear();
		
		System.out.println(set.size() + " / " + set);
		System.out.println(Arrays.toString(strArr));
	}//UseSet
	public static void main(String[] args) {
		new UseSet();
	}//main

}//class
