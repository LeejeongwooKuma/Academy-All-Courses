package day0821;

/**
 * 학생의 정보와 시험 정보를 저장하고 전달하기 위한 객체 
 */
public class StudentScoreDTO {

	private int num;
	private String name;
	private int java;
	private int oracle;
	private int jdbc;
	
	public StudentScoreDTO() {
		
	}//StudentScoreDTO
	
	public StudentScoreDTO(int num, String name, int java, int oracle, int jdbc) {
		this.num = num;
		this.name = name;
		this.java = java;
		this.oracle = oracle;
		this.jdbc = jdbc;
	}//StudentScoreDTO
	
	public void setNum(int num) {
		this.num = num;
	}//setNum
	
	public int getNum() {
		return num;
	}//getNum
	
	public void setName(String name) {
		this.name = name;
	}//setName
	
	public String getname() {
		return name;
	}//getname
	
	public void setJava(int java) {
		this.java = java;
	}//setJava
	
	public int getJava() {
		return java;
	}//getJava
	
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}//setOracle
	
	public int getOracle() {
		return oracle;
	}//getOracle
	
	public void setJdbc(int jdbc) {
		this.jdbc = jdbc;
	}//setJdbc
	
	public int getJdbc() {
		return jdbc;
	}//getJdbc
	
}//class