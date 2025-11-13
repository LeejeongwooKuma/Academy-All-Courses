package day0911;

import java.io.Serializable;

/**
 * 사용자의 중요한 정보를 가진 클래스<br>
 * 객체는 stream을 타고 나갈 수 없다.<br>
 * 객체가 stream을 타고 나갈려면 java.io.Serializable인터페이스를 구현해야 한다. <br>
 * java.io.Serializable - 객체를 검증할 목적으로 사용하는 인터페이스.(이 인터페이스에는 상수, 추상메소드가 없다.. 암것도 없다. 단순히 검증 용도)
 */
public class UserData implements Serializable {
	/**
	 * serialVersionUID : 현재 JVM에서 내보낸 객체인지 검증할 때 사용하는 ID
	 */
	private static final long serialVersionUID = 838900987015238122L;
	/**
	 * 사용자의 중요한 정보를 가진 클래스
	 */
	//중요한 정보가 있다면 transient로 막는다.
	private String name;//직렬화가능. Serializable 구현
	private double heigth;//직렬화가능
	private transient double weight;//직렬화 불가능

	public UserData() {

	}

	public UserData(String name, double heigth, double weight) {
		this.name = name;
		this.heigth = heigth;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "UserData [name=" + name + ", heigth=" + heigth + ", weight=" + weight + "]";
	}

}
