package day0821;

/**
 * 이차원 배열 : 행과 열로 구성된 배열<br>
 * 행의 수 : 배열명.length<br>
 * 열의 수 : 배열명[행의번호].length
 */
public class UseArray2 {
	public void useArray2() {
//	1.선언) 데이터형[][] 배열명 = null;
		int[][] arr2 = null;// 권장
		int arr3[][] = null;
//	2. 생성) 배열명 = new 데이터형[행의수][열의수]; //모든 방의 값은 초기화(heap)
		arr2 = new int[3][4];
		arr3 = new int[5][6];

		System.out.println(arr2);
		System.out.println(arr3);
		System.out.printf("arr2배열의 행 %d개, 열 %d개\n", arr2.length, arr2[0].length);
		System.out.printf("arr3배열의 행 %d개, 열 %d개\n", arr3.length, arr3[0].length);
//	3. 값 할당) 배열명[행의번호][열의번호]  
		arr2[0][0] = 2025;
		arr2[0][1] = 8;
//	4. 값 사용)배열명[행의번호][열의번호]

//		System.out.println(arr2[0]); //이차원 배열 안에 있는 일차원 배열의 시작 주소

//	일괄처리)
		System.out.println(arr2[0][0] + " / " + arr2[2][3]);

		for (int i = 0; i < arr2.length; i++) {// 행
			for (int j = 0; j < arr2[i].length; j++) {// 행
				System.out.printf("arr2[%d][%d]=%-6d\t", i, j, arr2[i][j]);
			} // end for
			System.out.println();
		} // end for

		// 개선된 for)
		// 이차원 배열의 한행은 일차원 배열로 이루어져있다.
		for (int arr[] : arr2) {
			// 일차원 배열의 한 열은 단일형으로 이루어져있다.
			for (int element : arr) {
				System.out.printf("%-6d\t", element);
			} // end for
			System.out.println();
		} // end for
			// 일차원 배열의 한 열은 단일형으로 이루어져있다.
		System.out.println("--------매개변수로 행을 전달--------");
//		for (int i = 0; i < arr2.length; i++) {
//			//LIFO메모리 방식
//			//this.rowProcess(arr2[i]); //this쓰는 이유는 같은 UseArray2 클래스 위에 있고 서로 인스턴스 메소드라 이렇게 부름.
//			rowProcess(arr2[i]);// 근데 this 기본으로 깔려 있어서 안 써도 이용 가능.
//			System.out.println();
//		}
		for (int[] arr : arr2) {
			rowProcess(arr);
			System.out.println();
		} // end for
	}// useArray2

	/**
	 * 이차원 배열의 행을 받고 싶다. => 매개변수는 일차원배열로 선언. 주소는 유일 : method안에서 값을 변경하면 원래 대상의 값이
	 * 변경된다.
	 */
	public void rowProcess(int arr[]) {
		// 원래의 값을 아예 바꿔버림. 이유는 주소가 유일하기 때문.
//		arr[0] = 300;
//		arr[1] = 200;
//		for(int ele : arr) {
//			System.out.printf("d\t", ele); //이 안에서 배열안의 값을 바꾸면? 주소는 유일하기에 그 주소의 값은 유일하고, 해당 주소의 값을 바꾸면 값 자체가 바뀜
		// 그래서 여기서 배열 가지고 작업할 때 원본에 영향을 주기 싫으면 배열을 복사해서 써야함.
//		}//end for
	}// rowProcess

	public void useArray3() {
		// 1.선언) 데이터형[][] 배열명 = new 데이터형[][]{ {값...}, {값...} };
//		int[][] arr2 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12} };
		int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12} };
		System.out.printf("%d행 %d열\n", arr2.length, arr2[0].length);
		// 2.값 사용)
		for(int[] arr : arr2) {//행 - 이차원 배열의 한행은 일차원 배열로 이루어져 있다.
			for(int ele : arr) {//열 - 일차원 배열의 열은 단일형
				System.out.printf("%d\t",ele);
			}//end for
			System.out.println();
		}//end for
		
	}// useArray3


	
	public static void main(String[] args) {
//		new UseArray2().useArray2();;
		UseArray2 ua2 = new UseArray2();
		ua2.useArray2();
//		UseArray2 ua22 = new UseArray22();
		System.out.println("-------2차원 배열의 기본형 형식의 사용-------");
		ua2.useArray3();
	}// main

}// class
