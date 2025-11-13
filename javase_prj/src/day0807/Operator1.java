package day0807;
/**
	단항연산자 : unary operator
	~, !, +, -, ++, --
*/
class Operator1{
	
	public static final int NOW_YEAR = 2025;
	
	public static void main(String[] args){
		//~ : tilde : 1의 보수 연산
		int i = 8, j = -7;
		System.out.println("~" + i + " = " + ~i); //~양수 : 부호변경 1증가
		System.out.println("~" + j + " = " + ~j); //~음수 : 부호변경 1감소
		
		// ! : not : true <-> false 변경 연산
		i = 8;
		j = -7;
		boolean result = !(i > j); //true -> false : 연산자의 우선순위 생각하면서 사용
		System.out.println( result ); //false
		
		//+ : 형식적인 제공 : 연산에 영향을 주지 않는다.
		System.out.println( "+" + i + " = " + +i); //i앞의 +가 형식적 제공인데 띄어쓰기 해줘야함. 띄어쓰기 안 하면 에러
		System.out.println( "+" + j + " = " + +j);
		
		// - : 2의 보수 연산, 부호 바꿈 연산
		System.out.println( "-" + i + " = " + -i);
		System.out.println( "-" + j + " = " + -j);
		//~를 사용하여 i를 -8로 만들어서 출력하고, ~를 사용하여 j를 7로 만들어서 출력
		System.out.println("~를 사용한 i : " + ~(i-1) + "\n~를 사용한 j : " + ~(j-1));
		
		++i;//전위연산
		System.out.println("전위연산 후 i : " + i);//8->9
		i++;//후위연산 
		System.out.println("후위연산 후 i : " + i); //++,--은 값을 아예 바꿈. 다른 애들은 일시적. 9->10
		// i = i+1;이랑 같은 거.
		i = i+1; 
		System.out.println("연산결과를 저장 후 i : " + i);//10 ->11
		
		--i; //값 1 감소
		System.out.println("전위연산 후 i : " + i); //11 -> 10
		i--; //값 1 감소
		System.out.println("전위연산 후 i : " + i); //10 -> 9
		//++,--는 상수나 constant에서는 사용할 수 없다. error
		//NOW_YEAR++; //constant는 값이 안 변하는 상수. 오류.
		
		//전위 : 내것 먼저 : 단항 연산 이후 결과 값을 대입
		int result2 = 0;
		//i == 9
		result2 = ++i;
		System.out.println("result2 : " + result2 + ", i : " + i);
		
		//후위 : 남의 것 먼저 : 대입 먼저 수행 후 단항 연산
		//i == 10
		result2 = 0; 
		result2 = i++;
		System.out.println("result2 : " + result2 + ", i : " + i);
		
		//i == 11
		j = 7;
		temp(++i, j++);//다른 method에 대입 할 때에도 전위와 후위는 다른 값을 대입한다. 들어가는 값 arguments
	}//main
	
	public static void temp(int param, int param2) { //int param 매개변수
		//param 12, param2 7
		System.out.println("temp method에서 받은 i 값 : " + param +", j값" + param2);
	}//temp method
}//class
