package day0902;

import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Work0902 extends JFrame {
	public Work0902(int month) {
		super(month + "월의 달력");
		//캘린더 객체 생성
		Calendar cal = Calendar.getInstance();
		
		//1일의 요일 및 마지막 날 찾기
		cal.set(Calendar.MONTH, month-1);//1일로 초기화
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		int startDay = cal.get(Calendar.DAY_OF_WEEK);//1일의 요일
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		int lastDay = cal.get(Calendar.DAY_OF_MONTH);
		
		//2.컴포넌트 생성
		JButton[] jbtnCal = new JButton[42]; 
		//요일 시작 전 빈 공간
		for(int i = 0; i < startDay-1; i++) {
			jbtnCal[i] = new JButton("");
		}//end for
		//요일에 숫자 넣기
		for(int i = 1; i < 42 - (startDay-2); i++) {
			if(i < lastDay+1) {
			jbtnCal[startDay-2 + i] = new JButton(String.valueOf(i));
			} else {
			jbtnCal[startDay-2 + i] = new JButton("");
			}//end if
		}//end for
		//3.배치관리자 설정
		setLayout(new GridLayout(6, 7));
		
		// 4.배치(L->R)
		for(int i = 0; i < 42; i++) {
			add(jbtnCal[i]);
		}//end for
		// 4.윈도우 크기 설정
		setSize(500, 500);
		// 5.가시화
		setVisible(true);
		// 6.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Work0902(9);
	}

}
