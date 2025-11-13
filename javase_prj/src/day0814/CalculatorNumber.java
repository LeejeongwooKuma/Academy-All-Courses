package day0814;


public class CalculatorNumber {
	private int num;
	private int table;
	private char startAlp;
	private char endAlp;

	public void setNum(int num) {
		this.num = num;
	}// setNum

	public void setTable(int table) {
		this.table = table;
	}// setTable

	public int getNum() {
		return num;
	}// getNum

	public int getTable() {
		return table;
	}// getTable

	public void printNum(int num) {
		int endNum = 0;
		if (num == 0) {
			startAlp = 48;
			endNum = 57;
		} else if (num == 1) {
			startAlp = 65;
			endNum = 90;
		} else if (num == 2) {
			startAlp = 97;
			endNum = 122;
		} else {
			startAlp = 48;
			endNum = 57;
		} // end else
		for (; startAlp < endNum + 1; startAlp++) {
			System.out.print(startAlp + " ");
		}
		System.out.println();
	}
	
	public void printTable(int num) { //입력받은 단 출력
		for (int i = 1; i < 10; i++) {
				System.out.println(num + " * " + i + " = " + num * i);
			}
		}
	
	
	
	public void printfullTable() { //전체 구구단 출력. 오버라이딩
		System.out.println("전체단 출력");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
	}
	
	public void reverseAlp() {
		for(char i = 122; i > 96; i--) {
			System.out.print(i + " ");
		}
	}

}// class
