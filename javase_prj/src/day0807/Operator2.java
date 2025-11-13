package day0807;
/**
	산술연산자 : +, -, *, /, %(나눈 나머지)
*/
class Operator2{
	public static void main(String[] args){
		
		int i = 9;
		System.out.println(i + "를 2로 나눈 나머지 : " + i % 2); //0아니면 1이 나옴. 몇 가지 수중에 하나만 고를 때 사용. -> 0이면 짝 1이면 홀. 홀짝 구하기

		int birthYear = 1995;		
		System.out.println( birthYear + "년은 "+ birthYear % 12);
		// 생년을 12가지의 수로 만들겠다는 의미. 0, 1, 2, 3, 4, 5,6 ,7, 8, 9,10, 11
		// 0 - 원숭이, 1-닭, 2-개, 3-돼지, 4-쥐, 5-소, 6-호랑이, 7-토끼, 8-용, 9-뱀, 10-말, 11-양
	}
}
