package day0828;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Generic을 사용하지 않는 List( 권장하지 않는다. )
 */
public class UseList {
	public UseList() {
		//1.생성) Generic을 사용하지 않고 객체화
		List list = new ArrayList();
		//2.값 할당) - 모든 값이 추가될 수 있다. (add 할때마다 방의 크기가 증가 -> 가변길이형)
		list.add(2025);//0
		list.add('A');//1
		list.add("안녕하세요?");//2
		list.add(2025.08);//3
		list.add(true);//4
		list.add(new Date());//5
		System.out.println("리스트의 크기 : " + list.size());
		//3.값 사용 - 지금은 뭐 들어갔는지 보여서 대처 가능이지만 보통은 저 값은 딴곳에서 들고와서 뭐가 들어있는지 모름
		//제네릭을 사용하지 않으면 값을 꺼내서 사용하는데 error가 발생 할 수 있다.
//		int i = (int) list.get(0);//원래는 ((Integer) list.get(0)).intValue()해야하는데 언박싱 해줘서 (int)로 가능		
//		System.out.println(i);
//		int j = (int) list.get(1); //바로 오류. 		
//		System.out.println(j);
		
		//일괄처리
		//값이 전부 출력되는 이유는 Overloading된 method이므로 에러가 발생하지 않았음. 알
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}//UseList
	
	public static void main(String[] args) {
		new UseList();
	}//main

}//class
