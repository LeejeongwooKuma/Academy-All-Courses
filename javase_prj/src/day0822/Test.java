package day0822;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//@Override
//public class Test extends Clark{ //Clark은 자식클래스를 가질 수 없다.
//String class, Integer class는 final이라 상속x,  Object class는 상속 가능 -> final이 있으면 객체화해서 쓰던대로 쓰고 final이 없으면 객체화 하던가 상속해서 쓰던가
//public class Test extends HongGilDong{// HongGilDong은 자식클래스를 가질 수 있다.
public class Test {// HongGilDong은 자식클래스를 가질 수 있다.
	@Override
	public String toString() {
		return "나는 주소가 싫어요";
	} //이걸 오버라이딩 해두면 t가 주소가 아닌 리턴 값을 알려줌.
	
	/**
	 * work를 사용하시는 것보다 work2를 사용하는게 좋을 것 같아요. 
	 */
	@Deprecated
	public void work() {
		System.out.println("처음에는 잘 되었으나 추후 제대로 동작을 안할 수 도 있다.");
	}
	
	@SuppressWarnings({"unused","rawtypes"})
	public static void main(String[] args) throws FileNotFoundException {
		Thread t2 = new Thread();//Thread class는 final이 없기에 상속 or 객체화로 사용 가능.
//		@SuppressWarnings("unused")
		int i2;
//		@SuppressWarnings("unused")
		int i3;
//		@SuppressWarnings("rawtypes")
		List l = new ArrayList();
		
		//obj의 toString은 주소를 내줌.
		Test t = new Test();
		String s = new String("good to see you");
		Integer i = new Integer(22);
		FileInputStream fis = new FileInputStream("c:/dev/env.bat"); //얘 쓴 이유는 toString메소드를 오버라이딩 안 한 클래스 찾아서 아무거나 쓴 거.예시 보여줄려고
		//모든 객체가 toString매소드를 호출할 수 있는 이유는 Object의 자식이기 때문임.
		//s,i는 사전가서 보면 String, Integer은 toString을 오버라이딩 해서 값을 그대로 보여주게 오버라이딩 해둠.
		// 하지만 t랑 fis메소드는 toString을 오버라이딩 안 해서 저렇게 그대로 주소가 뜸.
		//t,s,i - 객체(heap주소) => 객체를 출력하면 heap의 주소가 출력되어야 함..
		System.out.println(t.toString()); //heap 주소 나옴. println 컨트롤 클릭해보면 object를 매개변수로 받음.
		System.out.println(s.toString()); //heap주소 안 나옴 
		System.out.println(i.toString()); //heap주소 안 나옴 t랑 마찬가지로 object매개변수
		System.out.println(fis.toString()); //얘도 주소가 나옴.
		//객체니깐 heap의 주소가 나와야 하는데 안 나옴. 
		//이유는 매개변수로 Object이 선언된 println method를 호출하면 println method 안에서
		//toString()를 호출하여 객체의 주소를 day0822.Test@5ca881b5 형태의 "문자열"로
		//콘솔에 출력을 해준다. 
		
		Object obj = new Test();//상속관계, 가능.
		System.out.println(obj.toString());//Object의 toString은 주소를 내줘야하는데 오버라이드 된 toString이 잇으니 그걸 불러와줌.
		
		Date date = new Date();
		System.out.println(date.getYear()); //125년;; 첨엔 잘 됐을건데 지금은 이상하게 뜸
		
		t.work();
	}//main

}//class
