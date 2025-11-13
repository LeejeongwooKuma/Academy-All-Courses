package day0901;

public class StudentDTO {
	private String name;
	private int age;
	
	public StudentDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {//리스트의 값을 손쉽게 확인할 때 좋음.
		return "StudentDTO [name="+name+",age="+age+"]";
	}
}
