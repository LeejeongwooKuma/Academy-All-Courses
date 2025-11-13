package day0829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * java.util.List의 사용 
 * 검색의 기능이 있으며, 입력되는 값은 순차적으로 처리된다. 중복값 저장 가능.
 */
public class UseList {

	public void useArrayList() {
		//1.생성)List<E> list = new ArrayList<E>();
		List<String> list = new ArrayList<String>();//동시 사용 가능
		//2.값 할당) list.add(값);
		list.add("안녕하세요?");
		list.add("오늘은");
		list.add("금요일");
		list.add("내일도");
		list.add("금요일"); //중복값 저장 가능
		System.out.println(list.size() + " / " + list);
		
		//리스트의 모든 방의 값 얻기
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}//end for
		
		//Iterator를 사용한 list
		System.out.println("--- Iterator 사용");
		Iterator<String> ita = list.iterator();
		while (ita.hasNext()) {
			System.out.println(ita.next());
		}//end for
		System.out.println("--- Iterator 사용 2시작");//iterator은 pointer기에 1번 쓰면 또 못 씀.
		while (ita.hasNext()) {
			System.out.println(ita.next());
		}//end for
		System.out.println("--- Iterator 사용 2끝");
			
		//개선된 for
		for(String ele : list) {
			System.out.println(ele);
		}//end for
		
		//배열로 복사
		//1.Generic과 동일한 데이터형으로 배열 생성
		String[] strArr = new String[list.size()];
		//2.복사
		list.toArray(strArr);
		
		//리스트의 방의 값 삭제) 삭제되면 방의 크기가 줄어든다.
		//리스트의 인덱스로 삭제
		list.remove(1);
		//방의 값으로 삭제) 중복값이 있다면 L -> R 처음 일치하는 값만 삭제.
		list.remove("금요일");
		//리스트의 모든 방을 삭제
		list.clear();
		
		System.out.println(list.size() + " / " + list);
		System.out.println(strArr + " / " + Arrays.toString(strArr));
		//generic에는 기본형 데이터형을 사용할 수 없다
//		List<int> list2 = new ArrayList<int>();//error
		List<Integer> list2 = new ArrayList<Integer>();
		// int(기본형 - 값), Integer(참조형 - 주소)
		Integer i = Integer.valueOf(2025); //valueof쓰는 걸 추천.
		System.out.println(i.hashCode());//i는 주소인데 값이 나옴.hashco()도 값 나옴. 이유는 toString() 및 hashcode() override해서
		int j = 8;
//		System.out.println(j.hashCode());//기본형은 method를 호출할 수 없다
		list2.add(i);//Integer 매개변수 선언 => Integer
		list2.add(j);//Integer 매개변수 선언 => int?? ->원래 안됐는데 autoboxing을 해줌.
		list2.add(Integer.valueOf(j));// 원래는 변수를 객체로 만들어서 넣어줘야 했음. 오토박싱 개꿀
		
		Integer i2 = list2.get(0);//객체가 입력되었으니 객체가 나와야한다.
		int j2 = list2.get(0);//객체가 나왔는데 기본형에 할당이 됨.->unboxing
		//unboxing 객체가 리스트에 반환되어 wrapper class가 가지고 있는
		//기본형을 반환하는 method를 호출하여 기본형 데이터형에 할당 하는 것.
		int j3 = list2.get(0).intValue();//Generic을 사용한 경우. unboxing에서 이 작업을 해줌.
		int j4 = ((Integer)list2.get(0)).intValue();//Generic을 사용하지 않은 경우
		
		System.out.println(list2);
		System.out.println(i2 + " / " + j2 + " / " + j3);//Generic을 사용한 경우
		
		
		
	}//useArrayList

	public void useVector() {//ArrayList는 동시작업의 유무를 통한 속도 차이뿐. 나머진 똑같다.
		//1.생성)List<E> list = new Vector<E>();
		List<String> list = new Vector<String>();//동시 사용 차단
		//2.값 할당) list.add(값);
		list.add("Java");
		list.add("Oracle");
		list.add("JDBC");
		list.add("HTML");
		list.add(1,"CSS"); //기존의 데이터 사이에 값을 추가하는 일.
		System.out.println(list.size() + " / " + list);
		
		//리스트의 모든 방의 값 얻기
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}//end for
		//개선된 for
		for(String ele : list) {
			System.out.println(ele);
		}//end for
		
		//배열로 복사
		//1.Generic과 동일한 데이터형으로 배열 생성
		String[] strArr = new String[list.size()];
		//2.복사
		list.toArray(strArr);
		
		//리스트의 방의 값 삭제) 삭제되면 방의 크기가 줄어든다.
		//리스트의 인덱스로 삭제
		list.remove(1);
		//방의 값으로 삭제) 중복값이 있다면 L -> R 처음 일치하는 값만 삭제.
		list.remove("금요일");
		//리스트의 모든 방을 삭제
		list.clear();
		
		System.out.println(list.size() + " / " + list);
		System.out.println(strArr + " / " + Arrays.toString(strArr));
	}//useVertor

	public void useLinkedList() {//얘도 사용법은 똑같음. 생성자쪽 선언만 다름.
		//1.생성)List<E> list = new LinkedList<E>();
				List<String> list = new LinkedList<String>();
				//추가되는 데이터가 기존에 데이터 사이에 추가되는 일이 빈번하게 발생할 때.add처럼 하나씩 말고 특정 위치에 넣는다는 소리
				//2.값 할당) list.add(값);
				list.add("안녕하세요?");
				list.add("오늘은");
				list.add("금요일");
				list.add("내일도");
				list.add("금요일"); //중복값 저장 가능
				System.out.println(list.size() + " / " + list);
				
				//리스트의 모든 방의 값 얻기
//				for(int i = 0; i < list.size(); i++) {
//					System.out.println(list.get(i));
//				}//end for
				//개선된 for
				for(String ele : list) {
					System.out.println(ele);
				}//end for
				
				//배열로 복사
				//1.Generic과 동일한 데이터형으로 배열 생성
				String[] strArr = new String[list.size()];
				//2.복사
				list.toArray(strArr);
				
				//리스트의 방의 값 삭제) 삭제되면 방의 크기가 줄어든다.
				//리스트의 인덱스로 삭제
				list.remove(1);
				//방의 값으로 삭제) 중복값이 있다면 L -> R 처음 일치하는 값만 삭제.
				list.remove("금요일");
				//리스트의 모든 방을 삭제
				list.clear();
				
				System.out.println(list.size() + " / " + list);
				System.out.println(strArr + " / " + Arrays.toString(strArr));
	}//useLinkedList
	
	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("--ArrayList");
		ul.useArrayList();
		System.out.println("--Vector");
		ul.useVector();
		System.out.println("--LinkedList");
		ul.useLinkedList();
	}//main

}//class
