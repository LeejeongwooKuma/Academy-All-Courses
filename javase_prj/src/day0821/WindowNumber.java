package day0821;

public class WindowNumber {

	public static void main(String[] args) {
		int[][] arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 0 || i == 9 || j == 0 || j == 9) {
					arr[i][j] = 1;
				}
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
