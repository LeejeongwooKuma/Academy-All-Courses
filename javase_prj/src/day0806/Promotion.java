package day0806;
/**
자동 형 변환
*/
class Promotion{
	public static void main(String[] args){
		byte b = 10; // 4byte의 literal이 1byte로 축소되어 할당. demotion
		byte b2 = 20; // 4byte의 literal이 1byte로 축소되어 할당. demotion
		/**
		byte result = 0;
		result = b + b2; // 10 + 20 -> 30인데 강제형변환으로 int로 변함 -> result는 byte(1byte). 4->1이라 오류
		**/
		int result = 0; //강제형변환을 대비해서 받아줄 그릇을 int로 해줘야함
		result = b + b2; 
		System.out.println(b + " + " + b2 + " = " + result);
	}//main
}//class
