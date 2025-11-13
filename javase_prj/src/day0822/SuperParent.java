package day0822;

/**
 * 부모클래스와 자식클래스에 같은 이름에 변수나 method가 존재할 때 구분해서 사용하는 방법
 */
public class SuperParent {
	int i;
	int j;
	
	public void printVariable() {
		System.out.println("부모 : i = " + i + " , j = " + j);
	}
}
