package day0821;

/**
 * 삼차원배열 : 면, 행, 열로 구성된 배열.<br>
 * 면의 수 : 배열명.length<br>
 * 행의 수 : 배열명[면의번호].length<br>
 * 열의 수 : 배열명[면의번호][행의번호].length
 */
public class UseArray3 {
	public UseArray3() {
		// 1.기본형 형식) 데이터형[][][] 배열명 = new 데이터형[][][] {{{값,}},{{,}}};
		int[][][] arr3 = new int[][][] { { { 1, 2, 3 }, { 4, 5, 6 } }, { { 7, 8, 9 }, { 10, 11, 12 } } };
		System.out.printf("%d면 %d행 %d열\n", arr3.length, arr3[0].length, arr3[0][0].length);
		// 2.값 사용)
		// 면-index, 행-index, 열-index
		for (int i = 0; i < arr3.length; i++) {// 면
			System.out.println(i + "면 시작");
			for (int j = 0; j < arr3[i].length; j++) {// 행
				System.out.println(j + "행 시작");
				for (int k = 0; k < arr3[i][j].length; k++) {
					System.out.printf("arr[%d][%d][%d]=%d\t", i, j, k, arr3[i][j][k]);
				}
				System.out.println("\n" + j + "행 끝");
			}
			System.out.println(i + "면 끝");
		} // end for

		// 향상된 for
		// 삼차원 배열의 한면은 이차원 배열
		for (int[][] arr2 : arr3) {
			// 이차원 배열의 한 행은 일차원 배열
			for (int[] arr : arr2) {
				// 일차원배열의 열은 단일 형
				for (int ele : arr) {
					System.out.printf("%d\t", ele);
				} // end for
				System.out.println();
			} // end for
			System.out.println();
		} // end for
	}// UseArray3

	public static void main(String[] args) {
		new UseArray3();
	}
}
