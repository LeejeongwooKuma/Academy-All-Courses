package day0901;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class Work0901 {
	private List<ProgramScroeDTO> listStu; // 학생정보를 저장하는 리스트
	private HashMap<Integer, ArrayList<String>> stuMap; 
	private static final String ADD_STUDENT = "1";
	private static final String SEARCH_STUDENT = "2";
	private static final String DELETE_INFORMATION = "3";
	private static final String EXIT_PROGRAM = "4";

	private static final int NUM = 0;
	private static final int NAME = 1;
	private static final int JAVA_SCORE = 3;
	private static final int ORACLE_SCORE = 4;
	

	public Work0901() {
		listStu = new ArrayList<ProgramScroeDTO>();
		stuMap = new HashMap<Integer, ArrayList<String>>();
	}// Work0829

	/**
	 * 사용자에게 제공하는 업무의 메뉴
	 */
	public void menu() {
		boolean exitFlag = false;
		String inputMenu = "";
		do {
			inputMenu = JOptionPane.showInputDialog("\"아래의 메뉴를 입력해주세요.\n1.입력, 2.출력, 3.삭제 4.종료\"");
			// 취소나, x, 아무것도 입력하지 않고 "확인"을 누르면 일을 하지 않는다.
			if (inputMenu != null && !"".equals(inputMenu)) {
				switch (inputMenu) {
				case ADD_STUDENT:
					addStudent();
					break;
				case SEARCH_STUDENT:
					printSearchStudent(searchAllStudent());
					break;
				case DELETE_INFORMATION:
					printSearchStudent(searchAllStudent());
					break;
				case EXIT_PROGRAM:
					System.out.println("사용해주셔서 감사합니다.");
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "입력은 1,2,3으로만 해주세요.");
				}// end switch
			} // end if
		} while (!exitFlag);
	}// menu

	/**
	 * 학생의 정보를 List에 추가 ( 이름, 자바 점수, 오라클 점수, 총점으로 구성)
	 */
	public void addStudent() {
		String inputData = JOptionPane.showInputDialog("번호,이름,자바점수,오라클점수, 총점을 입력해주세요.\n입력 예)1,루피,50,60");
		if (inputData != null && !"".equals(inputData)) {
			String[] dataArr = inputData.split(",");
			if (dataArr.length == 4) {// 입력이 CSV형식이라면 업무 처리
				// 이름과 나이를 DTO에 저장
//				StudentDTO stuDTO = new StudentDTO(dataArr[NAME].trim(), Integer.parseInt(dataArr[AGE].trim()));
				ProgramScroeDTO proScoDTO = new ProgramScroeDTO(Integer.parseInt(dataArr[NUM]), dataArr[NAME], Integer.parseInt(dataArr[JAVA_SCORE]), Integer.parseInt(dataArr[ORACLE_SCORE]));
				// 입력된 여러 학생의 데이터를 관리하기 위해서 List 추가
//				listStu.add(stuDTO);
//				listStu.add(dataArr[NAME], Integer.parseInt(dataArr[JAVA_SCORE]), Integer.parseInt(dataArr[ORACLE_SCORE]));
//				stuMap.put(Integer.parseInt(dataArr[NUM]) , (dataArr[NAME], Integer.parseInt(dataArr[JAVA_SCORE]));
				JOptionPane.showMessageDialog(null, "학생의 정보가 추가되었습니다.");
				System.out.println(listStu);
				

			} else {
				JOptionPane.showMessageDialog(null, "이름과 나이를 ,로 구분하여 입력해주세요.");
			} // end if
		} // end if
	}// addStudent

	public String searchAllStudent() {
		StringBuilder outData = new StringBuilder();

		outData.append("번호\t이름\t나이\n").append("=============================\n");

		if (!listStu.isEmpty()) {

			StudentDTO sDTO = null;
			int totalAge = 0;
			for (int i = 0; i < listStu.size(); i++) {

//				sDTO = listStu.get(i);
				totalAge += sDTO.getAge();

				outData.append(i + 1).append("\t").append(sDTO.getName()).append("\t").append(sDTO.getAge())
						.append("\n");

			} // end for
			outData.append("=============================\n");
			outData.append("평균나이\t").append(totalAge / listStu.size()).append("살");
		} else {// 리스트가 비어있니?
			outData.append("학생의 정보가 없습니다.\n");
		} // end else

		return outData.toString();
	}// searchAllStudent

	/**
	 * 입력되는 데이터를 받아서 콘솔에 출력하는 일
	 * 
	 * @param outData
	 */
	private void printSearchStudent(String outData) {
		System.out.println(outData);
	}// printSearchStudent

}// class
