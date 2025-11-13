package day0822;

public class ObjectPolymorphism {

	/**
	 * 매개변수로 Person 객체를 받는 method
	 * @param args
	 */

	public void usePerson(Person person) {
		//같은 이름의 객체(person)을 다르게 사용한다 => 객체 다형성
		System.out.println(person.eat()); //집.밥, 집.빵
	}//usePerson
	
	public static void main(String[] args) {
		ObjectPolymorphism op = new ObjectPolymorphism();
		//앞의 Person은 뒤의 자식클래스명을 써줘도 됨. 자식은 부모다. 치환 가능하다는 소리.
		Person p = new HongGilDong();
		Person p2 = new Clark();

		op.usePerson(p);
		op.usePerson(p2);
		
	}//class

}//main
