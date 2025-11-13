package day0821;

/**
 * 가변배열 : 행마다 열의 수가 다른 배열
 */
public class VariableArray {
	public VariableArray() {
		// 1. 선언) 데이터형[][] 배열명 = null;
		int[][] arr2 = null;
		// 2. 생성) 배열명 = new 데이터형[행의수][]; 열의 개수를 설정하지 않는다.
		arr2 = new int [5][]; //행은 만들었는데 행은 무슨형인지 몰라! 없어!
		// 3. 행마다 열 생성) 배열명[행의번호] = new 데이터형 [열의갯수] => 빈배열생성
		//초기화(값이 있는 배열 생성) : 배일명[행의번호] = new 데이터형[]{값,,,,};
		arr2[0] = new int[5];
		arr2[1] = new int [2];
		arr2[2] = new int[] {1,2,3,4,5,6,7};
		arr2[3] = new int[] {1,2,3};
		arr2[4] = new int[1]; 
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.printf("arr2[%d]의 열의 수 %d\n", i, arr2[i].length);
		}
		// 4. 값 할당
		arr2[0][0] = 2025;
		// 5. 값 사용
		for( int[] arr : arr2) { //행
			for( int ele : arr) { //열
				System.out.printf("%d\t", ele);
			}//end for
			System.out.println();
		}//end for
	}// VariableArray

	public static void main(String[] args) {
		new VariableArray();

	}// main

}// class
