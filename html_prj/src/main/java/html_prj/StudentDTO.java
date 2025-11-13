package html_prj;

public class StudentDTO {
	private int num, sScore, fScore;
	private String name;
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(int num, int sScore, int fScore, String name) {
		super();
		this.num = num;
		this.sScore = sScore;
		this.fScore = fScore;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	public int getfScore() {
		return fScore;
	}
	public void setfScore(int fScore) {
		this.fScore = fScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", sScore=" + sScore + ", fScore=" + fScore + ", name=" + name + "]";
	}
}
