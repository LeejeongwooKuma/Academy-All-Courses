package day0811;

/**
 * 문제1<br>
 * -제시된 요금표를 사용하여 콘솔에 출력하는 코드를 작성<br>
 * -대중교통수단과 이동거리를 main method arguments로 입력받아 처리하는 프로그램 제작<br>
 * 교통수단 : 기본요금<br>
 * 마을버스 : 1200, 버스 : 1500, 지하철 : 1550<br>
 * 기본요금은 10km까지 무료이며, 초과 시 5km마다 100원씩 추가 요금이 발생<br>
 * 11km~15km : 100원, 16km~20km :200원, 21km~25km : 300원 - 제약사항 : 입력한 대중 교통수단이
 * "마을버스", "버스", "지하철"인 경우에만<br>
 * 아래의 출력 형식으로 출력하고, 그렇지 않다면 "대중교통수단이 아닙니다."를 출력<br>
 * 출력형식 : 입력하신 교통수단은 [XX]이고, 이동거리는 [XX]km 입니다. 해당 교통수단의<br>
 * 기본요금 : [XX]원<br>
 * 편도요금 : [XX]원<br>
 * 왕복요금 : [XX]원<br>
 * 한달 20일 기준 총 교통 요금 [XX]원 입니다.
 */
public class Exam0811 {
	public static final String VILLAGE_BUS = "마을버스";
	public static final String BUS = "버스";
	public static final String SUBWAY = "지하철";
	public static final int MONTH = 20;

	public static void main(String[] args) {
		if(args.length < 1 || args.length > 2) {
			System.out.println("입력값 확인 필요");
			return;
		}
		String checkTransportation = args[0];
		int moveKm = Integer.parseInt(args[1]);
		int baseFee = 0;

		switch (checkTransportation) {
		case VILLAGE_BUS:
			baseFee = 1200;
			break;
		case BUS:
			baseFee = 1500;
			break;
		case SUBWAY:
			baseFee = 1550;
			break;
		default:
			notTransportaion();
			return;
		}// end switch
		calculatorFee(checkTransportation, moveKm, baseFee);
	}// main

	public static void calculatorFee(String transport, int km, int baseFee) {
		int additionalFee = 0;
		if (km > 10) {
			if (km % 5 == 0) {
				additionalFee = ((km - 10) / 5 * 100);
			} else {
				additionalFee = ((km - 10) / 5 * 100) + 100;
			} // end else
		} // end if

		int oneWayFee = baseFee + additionalFee;
		int roundFee = oneWayFee * 2;
		int monthFee = roundFee * MONTH;

		System.out.println("입력하신 교통수단은 " + transport + "이고, 이동 거리는 " + km + "km 입니다. 해당 교통수단 상세내역은 아래와 같습니다.");
		System.out.println("기본요금 : " + baseFee + "원");
		System.out.println("편도요금 : " + oneWayFee + "원");
		System.out.println("왕복요금 : " + roundFee + "원");
		System.out.println("한달 20일 기준 총 교통 요금 : " + monthFee + "원 입니다.");
	}// end calculatorFee

	public static void notTransportaion() {
		System.out.println("대중교통수단이 아닙니다.");
	}// end notTransportaion
}// class
