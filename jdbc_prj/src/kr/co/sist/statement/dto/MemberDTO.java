package kr.co.sist.statement.dto;

import java.sql.Date;
//VO로 만들거면 setter를 빼면 됨. VO랑 DTO차이가 내용을 바꿀 수 있냐 없냐 차이.
public class MemberDTO {
	private int num,age;
	private String name, gender,tel;
	private Date input_date;
	
	public MemberDTO() {
		super();
	}// MemberDTO

	public MemberDTO(int num, int age, String name, String gender, String tel, Date input_date) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
		this.input_date = input_date;
	}// MemberDTO	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [num=" + num + ", age=" + age + ", name=" + name + ", gender=" + gender + ", tel=" + tel
				+ ", input_date=" + input_date + "]";
	}
	
	
	

}// MemberDTO
