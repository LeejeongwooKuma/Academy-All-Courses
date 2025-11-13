package day0827;

/**
 * 생성된 임시 비밀번호와 로또번호를 사용하는 일 
 */
public class RunWork0827 {

	private void printTempPassword() {
		Work0827 work = new Work0827();
		System.out.println(work.createTempPassword());
	}//pirntTempPassword

	private void printLotto() {
		Work0827 work = new Work0827();
		for(int num : work.createLotto()) {
			System.out.printf("%-3d", num);
		}
	}//pirntLotto
	
	public static void main(String[] args) {
		RunWork0827 rw0827 = new RunWork0827();
		rw0827.printTempPassword();
		rw0827.printLotto();
	}//main

}//class
