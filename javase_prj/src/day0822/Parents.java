package day0822;

/**
 * Parent의 클래스는 Child, Child2만 자식으로 가질 수 있도록 봉인.
 * 자식클래스의 파일이 없으면 error가 발생한다.
 */
public sealed class Parents permits Child,Child2/*,Child4*/{
	public Parents() {
		System.out.println("부모의 기본생성자");
	}
}
