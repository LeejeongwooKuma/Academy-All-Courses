package day0821;

public class ObjectArray {

	public void processScore(StudentScoreDTO[] ssArr) {
		//일괄처리
		StudentScoreDTO ssDTO = null;
		int totalScore = 0;
		for (int i = 0; i < ssArr.length; i++) {
			ssDTO = ssArr[i];
			totalScore = ssDTO.getJava() + ssDTO.getOracle() + ssDTO.getJdbc();
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\n", ssDTO.getNum(), ssDTO.getname(),
					ssDTO.getJava(), ssDTO.getOracle(), ssDTO.getJdbc(), totalScore, totalScore/3.0);
			totalScore = 0;
		}
	}
	public static void main(String[] args) {
		//1.배열생성
		StudentScoreDTO[] ssArr = new StudentScoreDTO[4];
		//2.값할당)
		ssArr[0] = new StudentScoreDTO(3,"루피",67, 75, 83);
		ssArr[1] = new StudentScoreDTO(4,"샹디",77, 85, 73);
		ssArr[2] = new StudentScoreDTO(25,"쵸파",98, 100, 100);
		ssArr[3] = new StudentScoreDTO(6,"나미",88, 89, 83);
		
		ObjectArray oa = new ObjectArray();
		oa.processScore(ssArr);
	}//main

}//class
