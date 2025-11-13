package day0828;

import javax.swing.JOptionPane;

public class RunWork0827 {
	private Work0827 work;
	public RunWork0827() {
		work = new Work0827(); //main 메소드에서 계속 객체화 할 필요 없어짐
	}//RunWork0827
	
	public void printDateFormat() {
		String nCode = JOptionPane.showInputDialog("국가코드를 입력\n0-1한국,1-독일,2-미국,3-일본","0");
		System.out.println(work.dateFormat(Integer.parseInt(nCode)));
	}//printDateFormat

	public void printbackUpFile() {
		System.out.println(work.backUpFile("c:/dev/env.bat"));
//		System.out.println(work.backUpFile("c:/dev/hosts"));
	}//printbackUpFile

	public static void main(String[] args) {

		RunWork0827 rw  = new RunWork0827();
		rw.printDateFormat();
		rw.printbackUpFile();
		
	}
}
