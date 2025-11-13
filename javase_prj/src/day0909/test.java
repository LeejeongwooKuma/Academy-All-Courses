package day0909;

public class test {

	public static void main(String[] args) {
		String format = "";
		format = String.format("%-15s", "안녕하세");
		System.out.println(format.length());
		
		int fixedLength = 15;
		String format2 = "%-" + fixedLength + "s"; // 결과: "%-15s"
		System.out.println(format2);
		
	}

}
