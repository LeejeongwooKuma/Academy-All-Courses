package day0819;

/**
 * 학생의 복합적인 정보를 저장할 수 있는 데이터 형인 StudentInfo를 사용하는 클래스.
 */
public class UseStudentInfo {

	public static void main(String[] args) {
		StudentInfo leeJeongWoo = new StudentInfo(1, "이정우", 31, 180.1, 88.2);
		StudentInfo leewj = new StudentInfo(2, "이원준", 23, 185.1, 78.3);
		
		//생성된 객체의 값이 변경되어야 한다.
		leeJeongWoo.setAge(27);
		System.out.printf("번호 %-3d, 이름 : %-5s, 나이 : %-3d, 키 : %-8.1f, 몸무게 : %-8.1f\n", leeJeongWoo.getNum(),leeJeongWoo.getName(), leeJeongWoo.getAge(), leeJeongWoo.getHeight(), leeJeongWoo.getWeight());
		System.out.printf("번호 %-3d, 이름 : %-5s, 나이 : %-3d, 키 : %-8.1f, 몸무게 : %-8.1f\n", leewj.getNum(),leewj.getName(), leewj.getAge(), leewj.getHeight(), leewj.getWeight());
		
		
	}//main

}//class
