package day0825;

/**
 * 홍길동 클래스와 클락 클래스를 사용하는 일을 하는 클래스
 */
public class RunPerson {

	public void usePerson() {
		// 객체 생성
		HongGilDong hgd = new HongGilDong();
		// 부모 method 호출 : 코드의 재 사용성
		hgd.setName("홍길동");
		System.out.printf("%s은 눈 %d, 코 %d 입 %d개를 가진 객체 입니다.\n", hgd.getName(), hgd.getEye(), hgd.getNose(),
				hgd.getMouth());
		System.out.println(hgd.eat());
		System.out.println(hgd.eat("국밥", 10)); // 국밥 한그릇을 10문 => 안맞음.주막인데 식당이라 뜸. 부모꺼를 그대로 쓰면 안될듯.
		// 자신 method 호출
		System.out.printf("%s의 싸움 결과는 %s이고 싸움레벨 %d 입니다. \n", hgd.getName(), hgd.fight(5), hgd.getLevel()); // 6->7
		System.out.printf("%s의 싸움 결과는 %s이고 싸움레벨 %d 입니다. \n", hgd.getName(), hgd.fight(6), hgd.getLevel()); // 7->8
		System.out.printf("%s의 싸움 결과는 %s이고 싸움레벨 %d 입니다. \n", hgd.getName(), hgd.fight(8), hgd.getLevel()); // 8->8
		System.out.printf("%s의 싸움 결과는 %s이고 싸움레벨 %d 입니다. \n", hgd.getName(), hgd.fight(9), hgd.getLevel()); // 8->7

		Clark superman = new Clark();
		// 부모 클래스의 method 사용
		superman.setName("클락 켄트");
		System.out.printf("%s은 눈 %d, 코 %d 입 %d개를 가진 객체 입니다.\n", superman.getName(), superman.getEye(),
				superman.getNose(), superman.getMouth());
		System.out.println(superman.eat()); // 집에서 빵 먹어야 하는데 부모꺼를 쓰니 밥 먹는다고 뜸. 새로 만들어야 겠다->안맞는다.
		System.out.println(superman.eat("스테이크", 10)); // 스테이크를 식당이 아니라 레스토랑에서 먹어야함.가격도 10불인데 10원.->자식클래스 상황과 안 맞는다.
		// 자신 method 호출
		System.out.printf("%s의 돌을 던진 결과는 %s이고 힘레벨 %d 입니다. \n", 
				superman.getName(), superman.power("짱돌"), superman.power); 

		System.out.printf("%s의 돌을 던진 결과는 %s이고 힘레벨 %d 입니다. \n", 
				superman.getName(), superman.power("다이아몬드"), superman.power);
		
		System.out.printf("%s의 돌을 던진 결과는 %s이고 힘레벨 %d 입니다. \n", 
				superman.getName(), superman.power("크립톤나이트"), superman.power);
		
		//MyPower mp = new MyPower();
//		mp.setName("이정우");
//		System.out.printf("%s은 눈 %d, 코 %d 입 %d개를 가진 객체 입니다.\n", mp.getName(), mp.getEye(),
//				mp.getNose(), mp.getMouth());
//		System.out.printf("%s의 상태는 %s이고, 열정 점수는 %d점 입니다.\n",mp.getName(), mp.Study("의욕적"), mp.passion);
//		System.out.printf("%s의 상태는 %s이고, 열정 점수는 %d점 입니다.\n",mp.getName(), mp.Study("의욕적"), mp.passion);
//		System.out.printf("%s의 상태는 %s이고, 열정 점수는 %d점 입니다.\n",mp.getName(), mp.Study("의욕적"), mp.passion);
//		System.out.printf("%s의 상태는 %s이고, 열정 점수는 %d점 입니다.\n",mp.getName(), mp.Study("졸림"), mp.passion);
//		System.out.println("결과 : " + mp.checkStudy());

		System.out.println("--------------------------------");
		String[] hongLang = hgd.language();
		String[] clarkLang = superman.language();
		
		for(int i = 0; i < hongLang.length; i++) {
			System.out.println(hongLang[i]);
		}//end for
		System.out.println("-------------");
		
		//개선된 for로 clark이 구사할 수 있는 언어를 모두 출력해보세요.
		for(String lang : clarkLang) {
			System.out.println(lang);
		}
		
		System.out.println("------interface를 구현한 metho 호출------");
		System.out.println(superman.getName() + "은 양력을 " + superman.lift() +
				"로 얻고, 날기위한 추진력을 " + superman.thrust() + "로 얻는다.");
		
		
	}// usePerson

	public static void main(String[] args) {
		new RunPerson().usePerson();
	}// main

}// class
