package day0901;

public class ProgramScroeDTO {
	private int num;
	private String name;
	private int javaScore;
	private int oracleScore;

	public ProgramScroeDTO(int num ,String name, int javaScore, int oracleScore) {
		this.num = num;
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	public int getOracleScore() {
		return oracleScore;
	}

	public void setOracleScore(int oracleScore) {
		this.oracleScore = oracleScore;
	}

	

//	@Override
//	public String toString() {// 리스트의 값을 손쉽게 확인할 때 좋음.
//		return "StudentDTO [name=" + name + ",score=" + score + "]";
//	}
}
