package day0916;

@FunctionalInterface//이 이노테이션을 주면 인터페이스가 추상메소드를 1개만 가지도록 만들 수 있음..
public interface Test {
	public void temp (int i);
//	public void temp2 (int i);//인터페이스에서 추상 method는 여러개 정의 가능. => but  Lambda식에서는 사용불가.
//	public void temp3 (int i);
}//Test
