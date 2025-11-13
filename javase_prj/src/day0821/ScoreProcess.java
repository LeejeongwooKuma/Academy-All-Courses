package day0821;

import java.util.Arrays;

public class ScoreProcess {
	private String school;
	private String[] nameArr;
	private String[] subjectArr;
	private int[][] scoreArr;

	/**
	 * 성적처리할 학교명, 학생명, 과목, 학생점수를 입력
	 * 
	 * @param school     학교명
	 * @param nameArr    학생명
	 * @param subjectArr 과목명
	 * @param scoreArr   점수
	 */
	public ScoreProcess(String school, String[] nameArr, String[] subjectArr, int[][] scoreArr) {
		this.school = school;
		this.nameArr = nameArr;
		this.subjectArr = subjectArr;
		this.scoreArr = scoreArr;
	}// ScoreProcess

	public void scoreProcess() {
		int totalScore = 0;
		double subjectCnt = scoreArr[0].length;
		int[] sumArr = new int[4];
		int maxJava = 0;
		int[] bestScore = new int[2];
		int[] oracle = new int[4];
		int allTotalScore = 0;
		double allTotalavg = 0;
		System.out.printf("\t\t%s 성적처리\n", school);
		System.out.println("\n======================================================");
		for (String subject : subjectArr) {
			System.out.printf("%s\t", subject);
		} // end for
		System.out.println("\n======================================================");
		
		for(int i = 0; i < scoreArr.length; i++) { //행 : 번호, 학생의 정보
			System.out.printf("%d\t%s\t",i + 1, nameArr[i]);
			for (int j = 0; j < scoreArr[i].length; j++) {//열 : 점수들
				System.out.printf("%d\t", scoreArr[i][j]);
				totalScore += scoreArr[i][j];
				allTotalScore += scoreArr[i][j];
				sumArr[j] += scoreArr[i][j]; // 과목별 총점
				if (maxJava < scoreArr[i][0]) {//최고 자바 점수
					maxJava = scoreArr[i][0];
				}//end if
				if (totalScore  > bestScore[1]) {
					bestScore[0] = i;
					bestScore[1] = totalScore;
				}//end if
				oracle[i] = scoreArr[i][1];
			}//for
//			System.out.println("확인용"  + sumArr[0]);
			allTotalavg += totalScore/subjectCnt;
			System.out.printf("%d\t%.2f\n",totalScore,totalScore/subjectCnt); 
			totalScore = 0;
		}//end for
		sumArr[3] = allTotalScore;
		System.out.println("===="
				+ "==================================================");
		//문제1
		//각 과목의 총점을 구하고, 전체 총점과, 전체 평균을 보여주세요
		System.out.printf("\t총점\t");
			for (int ele : sumArr) {
				System.out.print(ele + "\t");
			}
		System.out.printf("%.2f",allTotalavg/nameArr.length);
		System.out.println();
		System.out.printf("\t자바과목의 최고점 [ " + maxJava + " ]");
		System.out.println();
		System.out.printf("\t1등학생의 번호[ " + (bestScore[0] + 1) + " ] 이름 [ " + nameArr[bestScore[0]] + " ]");
		System.out.println();
		System.out.printf("\t오라클점수의 오름차순 정렬 출력\t");//72 80 85 99
		Arrays.sort(oracle);
		for (int ele : oracle) {
			System.out.print(ele + "\t");
		}
		
	}// scroeProcess

}
