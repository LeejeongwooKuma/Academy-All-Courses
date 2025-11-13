package day0807;
/**
	논리연산자
	일반논리 : 여러개의 관계연산자를 묶어서 비교할 때 사용
	&&(AND) : 전항과 후항이 모두 true일 때만 true 반환
	||(OR) : 전항과 후항이 모두 false일 때만 false 반환
	
	-비트논리 : 비트연산
	&(AND) : 상위비트와 하위비트 모두 1인경우 1내림
	|(OR) : 상위비트와 하위 비트 모두 0인 경우 내림
	^(XOR) : 상위 비트와 하위 비트 둘 중 하나만 1인 경우 1내림.
*/
class Operator5{
	public static void main(String[] args){
		System.out.println( 8 > 7 && 7 < 8 );

		boolean flag = true, flag2 = false, flag3 = true, flag4 = false;
		
		System.out.println(" -----&&( AND )------------------------ ");
		System.out.println(flag + " && " + flag3 + " = " + (flag && flag3));//true
		System.out.println(flag + " && " + flag2 + " = " + (flag && flag2));//false
		System.out.println(flag2 + " && " + flag + " = " + (flag2 && flag));//false
		System.out.println(flag2 + " && " + flag4 + " = " + (flag2 && flag4));//false
		
		System.out.println(" -----||( OR )------------------------ ");
		System.out.println(flag + " || " + flag3 + " = " + (flag || flag3));//true
		System.out.println(flag + " || " + flag2 + " = " + (flag || flag2));//true
		System.out.println(flag2 + " || " + flag + " = " + (flag2 || flag));//true
		System.out.println(flag2 + " || " + flag4 + " = " + (flag2 || flag4));//false
		
		//&&는 전항이 false면 후항을 연산하지 않는다(처리속도 향상)
		flag = false;
		flag2 = false;
		boolean result = false;

		result = (flag= 3<2) && (flag2= 4 < 5); //앞이 틀리니 false. 뒤는 계산 안 함. 뒤를 했으면 flag2는 true인데 안 했으니 위 값 false.
		
		System.out.println( flag + " && " + flag2 + " = " + result);
		
		
		System.out.println(" -------------비트논리---------------- ");
		
		int i = 19, j = 15;
	
		System.out.println( i + " & " + j + " = " + (i & j)); //3
		
		i = 16;
		j = 19;

		System.out.println( i + " | " + j + " = " + (i | j));
		
		System.out.println( i + " ^ " + j + " = " + (i ^ j));
	}//main
}//class
