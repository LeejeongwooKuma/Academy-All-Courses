package day0829;

import day0821.StudentScoreDTO;

public class RunUseGeneric {

	 public RunUseGeneric() {
		 //1.생성 : 클래스명<사용할데이터형> 객체명 = new 생성자<시용할 데이터형>();
		 UseGeneric<String> ug = new UseGeneric<String>();
		 ug.set("안녕하세요?");
		 System.out.println(ug.get());
//		 us.set(1); //문자열이 아니어서 에러
		 
		 UseGeneric<Integer> ug2 = new UseGeneric<Integer>();
		 ug2.set(2025);
		 System.out.println(ug2.get());
		 
		 UseGeneric<StudentScoreDTO> ug3 = new  UseGeneric<StudentScoreDTO>();
		 ug3.set(new StudentScoreDTO(1, "루피", 50, 52, 54));
		 ug3.set(new StudentScoreDTO(2, "쵸파", 90, 98, 96));
		 
		 //설정된 객체 사용
		 StudentScoreDTO ssDTD = ug3.get();
		 System.out.println(ssDTD.getNum() + ", " + ssDTD.getname());//나중에 넣은 쵸파가 덮어씌어버림.
	 }//RunUseGeneric
	public static void main(String[] args) {
		new RunUseGeneric();
	}//main

}//class
