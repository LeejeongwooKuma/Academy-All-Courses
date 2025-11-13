package day0827;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exam0827 {
//	0,1,2,3을 입력받는 메소드를 작성하고, 문자열로 날짜형식을 반환하는 method 작성. 
//	반환되는 날짜형식은 :  “월-일-년 오전|오후 요일 시:분:초”의 형식을 가짐.
//	입력값 0 → 한국, 1→독일, 2→ 미국, 3→일본 날짜형식이 반환되어야 한다.
//	입력값이 0,1,2,3이 아니면 한국의 날짜형식으로 반환.
	public String returnDate(int input) {
		String nation;
		String k = "KOREA";
		Locale l; //Locale[] loc = {Locale.KOREA, Locale.GERMAN....};
		switch(input) {
		case 0 : l = Locale.KOREA; break;
		case 1 : l = Locale.GERMAN; break;
		case 2 : l = Locale.US; break;
		case 3 : l = Locale.JAPAN; break;
		default : l = Locale.KOREA;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a EEEE k:mm:ss", l);
		
		return sdf.format(date);
	}//returnDate

	
//	파일명을 매개변수로 받는 method 만들고 입력된 파일명에 **백업파일명**을 반환하는 일을 하는 method 작성.
//	예) “Abc.java”가 입력되면 반환되는 백업파일명은 “Abc_back.java”의 형식으로 리턴.
	public StringBuilder makeBackUp(String fileName) {
		StringBuilder sb = new StringBuilder(fileName);

		int lastDotIndex = sb.lastIndexOf("."); 
		if(lastDotIndex != -1) {
	         sb.insert(lastDotIndex, "_bak");
	      } else {
	         sb.append("_bak");
	      }
		
		return sb;
	}//makeBackUp
	
	public String printDate(String sdf) {
		return sdf;
	}//printDate
	public String printBackUp(StringBuilder sb) {
		return sb.toString();
	}//printBackUp

	public static void main(String[] args) {
		Exam0827 ex0827 = new Exam0827();
		System.out.println(ex0827.printDate(ex0827.returnDate(3)));
		System.out.println(ex0827.printBackUp(ex0827.makeBackUp("Abc.java")));
	}//main
}//class
