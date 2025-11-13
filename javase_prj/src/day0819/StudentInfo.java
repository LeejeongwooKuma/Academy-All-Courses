package day0819;

/**
 * 학생의 정보(하나의 데이터 형으로 저장할 수 없는 복합적인 정보)를 저장하는 데이터 형.<br>
 * 학생의 정보는 번호, 이름, 나이, 키, 몸무게로 이루어져 있다
 */
public class StudentInfo {
	private int num;
	private String name;
	private int age;
	private double height;
	private double weight;
	// 여기서는 기본 생성자가 필요 없음. 차피 instance 변수라서 기본값이 주어지고 사람의 정보는
	// 모두 틀리니 따로 넣어줘야 함.

	/**
	 * 입력된 값으로 학생의 정보를 객체에 저장하는 생성자<br>
	 * 사용법) StudentInfo 객체명 = new StudentInfo(num, name, age, height, weight);
	 * 
	 * @param num    학생의 번호
	 * @param name   이름
	 * @param age    나이
	 * @param height 키
	 * @param weight 몸무게
	 */
	public StudentInfo(int num, String name, int age, double height, double weight) {
		this.num = num;
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}// StudentInfo

	/**
	 * 생성자에서 만들어진 학생의 번호를 변경하는 일
	 * @param num 변경할 번호
	 */
	public void setNum(int num) {
		this.num = num;
	}// setNum
	
	/**
	 * 학생의 번호를 얻는 일
	 * @return
	 */
	public int getNum() {
		return num;
	}//getNum

	/**
	 * 학생의 이름을 변경하는 일
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}//setName

	/**
	 * 학생의 이름을 얻는 일
	 * @return 이름
	 */
	public String getName() {
		return name;
	}//getName

	/**
	 * 학생의 나이를 변경하는 일
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}//setAge
	
	/**
	 * 학생의 나이를 반환하는 일
	 * @return 나이
	 */
	public int getAge() {
		return age;
	}//getAge
	
	/**
	 * 학생의 키를 변경하는 일
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}//setHeight
	
	/**
	 * 학생의 키를 반환하는 일
	 * @return 키
	 */
	public double getHeight() {
		return height;
	}//getHeight
	
	/**
	 * 학생의 몸무게를 변경하는 일
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}//setWeight
	
	/**
	 * 학생의 몸무게를 반환하는 일
	 * @return 몸무게
	 */
	public double getWeight() {
		return weight;
	}//getWegiht
	
}//class
