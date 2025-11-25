package day1124;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UseURLEncoder {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String name ="홍길동";
		System.out.println(name);
		
		//방법1. 문자열을 Web parameter 형식으로 변환일
		String enName=URLEncoder.encode(name, "UTF-8");
		System.out.println(enName);
		String deName=URLDecoder.decode(enName, "UTF-8");
		System.out.println(deName);
		
		
		
		//방법2. String 사용. ->잘 안 쓰고 오류도 막 뜨고 비추.
		//String str=new String(URLDecoder(enName,"8859_1").getBytes("8859_1"), "UTF-8");
		//System.out.println(str);
		
	}//main

}//class
