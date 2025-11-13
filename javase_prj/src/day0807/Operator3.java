package day0807;
/**
	쉬프트 연산자 : 비트밀기 연산
	<< (left shift) : 비트를 왼쪽으로 밀고, 밀어서 빈칸을 항상 0으로 채운다
	>> (right shift) : 비트를 오른쪽으로 밀고, 밀어서 빈칸을 최상위 부호비트에 따라 양수면 0, 음수면 1을 채운다.
	>>> (unsigned right shift) : 비트를 오른쪽으로 밀고, 밀어서 빈칸을 항상 0으로 채운다.
*/	
class Operator3{
	public static void main(String[] args){
	
		int i = 25;
		
		System.out.println(i + " << 3 = " + (i << 3));  // 뒤에 ()없으면 <<전까지의 내용이 문자로 나옴. 문자 << 3이라 오류.
		
		i = 40;
		System.out.println(i + " >> 2 = " + (i >> 2));
		
		i = 50;
		System.out.println(i + " >>> 2 = " + (i >>> 2));
		//0011 0010 -> 0000 1100 
		
		i = 1; // 0000 0000 0000 0000 0000 0000 0000 0001
		System.out.println( i << 31 ); //32칸 밀면 <<끝까지 갔다가 >>맨앞으로 다시 감.
		i=-1;// 1111 1111 1111 1111 1111 1111 1111 1111
		System.out.println( i >> 100); //밀어도 전부 -로 채우니 -1 그대로
		System.out.println( i >>> 1); // 0111 1111 1111 1111 1111 1111 1111 1111 int 양수중 가장 큰 수
		System.out.print((i >>> 24)); //255
	}//main
}//class
