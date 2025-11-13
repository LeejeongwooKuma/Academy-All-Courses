package day0807;
/**
	코딩창에서 다양한 진수를 사용
*/
class Radix{
	public static void main(String[] args){
		int binary = 0b00001010; //2진수는 0b를 붙여서 작성
		int octal = 012; //8진수는 0을 붙여서 작성
		int decimal = 10; // 10진수는 그냥 숫자 작성
		int hex = 0xa; //16진수는 0x붙여서 작성. a == A. 둘 다 10 나옴
		System.out.println(binary);
		System.out.println(octal);
		System.out.println(decimal);
		System.out.println(hex);
		
		//System.out.println이 2진수를 받아서 10진수로 변환하여 console에 출력함
		System.out.println(binary + octal + decimal +hex); //정상적으로 됨. 이유는 코딩시 전부 지가 알아서 2진수로(계산 전부터) 인식함.
		
		//int tel = 012345678; //error. 앞이 0이라 8진수로 인식하는데 8진수에 8은 없음.그래서 번호는 숫자 말고 문자열로 저장해야함.
		//String tel = "012345678";
		
		decimal =300;
		System.out.println(decimal + "을 2진수로 만들면 " + Integer.toBinaryString(decimal));
	}//main
}//class
