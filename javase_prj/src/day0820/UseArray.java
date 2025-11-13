package day0820;

/**
 * 일차원 배열 : 행 하나에 열(요소,element,방)로만 구성된 배열
 */
public class UseArray {
	public UseArray() {
		// 1.선언) 데이터형[] 배열명 = null;
		// int[] arr방식을 권장하는 이유.
		int[] arr = null; // 이러면 arr, b 둘 다 배열
		int arr2[] = null; // 이렇게 하면 arr2만 배열이고 b2는 int형

		// 2.생성) 배열명 = new 데이터형[방의개수];
		// heap에 동일 데이터형으로 배열의 방이 생성되고 그 주소를 저장
		arr = new int[4];
		arr2 = new int[5];

		// 선언과 생성을 한 번에 하는 방법 > 데이터형[] 배열명 = new 데이터형[방의수]
		int[] arr3 = new int[6];

		System.out.println(arr + " / 방의 수 : " + arr.length);
		System.out.println(arr2 + " / 방의 수 : " + arr2.length);
		System.out.println(arr3 + " / 방의 수 : " + arr3.length);

		// 3.값 할당) 배열명[방의번호] = 값;
		arr[0] = 2025;
		arr[1] = 8;
		arr[2] = 20;
		arr[3] = 14;
//		arr[4] = 14; //배열에 4번째 인덱스가 존재하지 않으므로 error
		// 4.값 사용) 배열명[방의번호]
		System.out.println(arr[0] + " / " + arr[1] + " / " + arr[2] + " / " + arr[3]);

		// 일괄처리
		int sum2 = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			sum2 += arr[i];
		} // end for
		System.out.println(sum2);

		// 1번 학생 90, 2- 86, 3- 99, 4- 78, 5- 66
		// 각 학생의 점수를 저장해서, 각학생의 점수를 출력하고, 총합, 평균 구하기
		// 배열은 안 쓰면 변수만 5개 만들어야 하는데 배열은 변수명 1개. 벌써 이득.
//		int score = 90;
//		int score2 = 86;//....이렇게 5개는 너무 노가다.
		// 모든 학생의 점수를 저장하기 위한 배열 선언
		// 1.선언 + 2.생성)
		int[] score = new int[5];
		// 3.값 할당)
		score[0] = 90;
		score[1] = 86;
		score[2] = 99;
		score[3] = 78;
		score[4] = 66;
		// 4.값 사용)
		System.out.println("번호\t점수");
		System.out.println("-------------");
		
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d\t%d\n", i+1, score[i]);
			total += score[i];
		}//end for
		System.out.printf("총점[%d], 평균[%.2f]\n", total, (double)total/score.length);

		System.out.println("---------배열의 초기화----------");
		//문법) 데이터형[] 배열명 = {값,,,,};
//		int[] temp = {10, 20, 30, 40, 50, 60, 70, 80};
		int[] temp =new int[]{10, 20, 30, 40, 50, 60, 70, 80}; //위에랑 같은 방식. 생략이 가능한거. 뒤에 int[]는 무조건 빈공간.
		System.out.println(temp.length);
		
//		for(int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i]);
//		} temp배열의 방의 값을 마지막 방부터 처음 방까지 출력
		for(int i = temp.length-1; i > -1; i--) {
			System.out.println(temp[i]);
		}//end for
		
		//참조형 String으로 배열 생성
		String[] subject = new String[5];
		String[] subject2 = {"Java SE", "Oracle DBMS", "JDBC", "HTML", "CSS"};
//		String[] subject2 = new String[] {"Java SE", "Oracle DBMS", "JDBC", "HTML", "CSS"};
		subject[0] = "Java SE";
		subject[1] = "Oracle DBMS";
		subject[2] = "JDBC";
		subject[3] = "HTML";
		subject[4] = "CSS";
		System.out.println("시작");
		String tempSubject ="";
		for(int i = 0; i < subject.length; i++) {
//			System.out.printf("[%-12s][%-12s]\n", subject[i], subject2[i]);
			//모든 과목을 출력하는데 짝수번째 방의 과목은 소문자로 출력..다른 방식으론 tempSubject(String)만들고 짝수면 해당 값 뱉어줘도 됨.
			tempSubject = subject[i];
			if(i%2 == 0) {
//				System.out.printf("[%-12s][%-12s]\n", subject[i].toLowerCase(), subject[i].toLowerCase());
				tempSubject = tempSubject.toLowerCase();
			} 
//			System.out.printf("[%-12s][%-12s]\n", subject[i], subject2[i]);
			System.out.println(tempSubject + " / " + subject[i]);
			
		}
		System.out.println("개선된 for의 사용");
		for(int element : score) {
			System.out.print(element + " ");
		}//end for
		System.out.println("\n-------------------------");
		for( String element : subject2) {
			System.out.println(element + " ");
		}//end for
		System.out.println("다음");
		//split
		String data = "JAVA~.ㅋOracle~.ㅋJDBC~.ㅋHTML~.ㅋJavaScript";
//		String[] temp2 = data.split("~");
//		String[] temp2 = data.split("[.]"); //.은 RegEx(정규식)의 문자열 class로 만들어야 구분됨. []없으면 인식 못 함.
//		String[] temp2 = data.split("J");
		String[] temp2 = data.split("ㅋ");
		for(String element : temp2) {
			System.out.println(element);
		}
				
				
				
		
	}// UseArray

	public static void main(String[] args) {
		new UseArray();
	}// main

}// class
