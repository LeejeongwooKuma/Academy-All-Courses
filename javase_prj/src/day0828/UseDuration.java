package day0828;

import java.time.Duration;
import java.time.LocalTime;

public class UseDuration {

	public UseDuration() {
		LocalTime lt = LocalTime.now();
		LocalTime lt2 = LocalTime.now();//of(시,분), of(시,분,초)
		//시간 정보 연산
		lt2 = lt2.plusHours(1);
		lt2 = lt2.plusMinutes(2);
		
		System.out.println(lt);
		System.out.println(lt2);

		//Duration객체를 LocalTime과 has a 관계를 설정하여 객체 얻기
		Duration d = Duration.between(lt, lt2);
		
		System.out.println(d);
		System.out.println("시간 차 : " + d.toHours());
		System.out.println("분 차  : " + d.toMinutes());
		System.out.println("나노초 차  : " + d.toNanos());
		
	}//UseDuration
	public static void main(String[] args) {
		new UseDuration();
	}//main

}//class
