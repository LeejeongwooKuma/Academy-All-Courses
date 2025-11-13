package day0812;

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
public class Work0811 {
	public static final int TOWN_BUS = 1200;// 마을버스
	public static final int BUS = 1500; // 버스
	public static final int SUBWAY = 1550; // 지하철
	public static final int FLAG_MONTH = 20;// 한달 기준일

	public static void main(String[] args) {

		int distance = 0;

		distance = Integer.parseInt(args[1]);

		if (args[0].equals("마을버스") || args[0].equals("버스") || args[0].equals("지하철")) {
			int defaultCharge = 0;// 기본요금을 저장하는 변수
			int extraCharge = 0;// 초과요금을 저장하는 변수
			int excessDistance = 5;// 초과된 거리

			// 교통수단별 기본요금 구하기
			if (args[0].equals("마을버스")) { // 마을버스 기본 요금
				defaultCharge = TOWN_BUS;
			} else if (args[0].equals("버스")) { // 버스 기본 요금
				defaultCharge = BUS;
			} else {// 지하철 기본 요금
				defaultCharge = SUBWAY;
			} // end else

			// 기본거리를 초과했을 때 초과요금을 구하기
			if (distance > 10) {
				extraCharge = ((distance - 10 + excessDistance - 1) / excessDistance) * 100;
			} // end if

			System.out.println("입력하신 교통수단은 [" + args[0] + "] 이고, " + "이동거리는 [" + distance + "km] 입니다.");
			System.out.println("교통수단의 기본 요금 [" + defaultCharge + "] 원 입니다.");
			System.out.println("편도 요금 [" + (defaultCharge + extraCharge) + "] 원 입니다.");
			System.out.println("왕복 요금 [" + ((defaultCharge + extraCharge) * 2) + "] 원 입니다.");
			System.out.println("한달 [" + FLAG_MONTH + "일] 기준 총 교통요금 [" + (((defaultCharge + extraCharge) *2)*FLAG_MONTH) + "]원 입니다");
		} else {
			System.out.println("입력하신 교통 수단은 대중교통이 아닙니다.");
		} // end else

	}// main

}// class
