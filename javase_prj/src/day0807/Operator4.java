package day0807;
/**
	관계연산자
	>, <, >=, <=, ==, !=
*/
class Operator4{
	public static void main(String[] args)	{
		int i=8, j=7, k=8;
		
		System.out.println(i + " == " + k + " = " + (i == k));//true 우선순위가 +인 산술이 더 높아서 앞이 문자열인 상태로 ==할려니 터짐.
		System.out.println(i + " == " + j + " = " + (i == j));//false
		
		System.out.println(i + " != " + k + " = " + (i != k));//false
		System.out.println(i + " != " + j + " = " + (i != j));//ture
	}
}
