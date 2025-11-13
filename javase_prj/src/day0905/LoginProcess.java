package day0905;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginProcess {
	private static Map<String, String> mapLoginData; //static 안 붙히면 로그인 프로세스 클래스가 만들어질때마다 맵 인스턴스 변수가 생길거임. 스테틱 붙히면 로그인프로세스가 여러번 만들어져도 변수는 1번만 생성되고 그걸 계속 씀.
	private LoginForm lf;
	
	public LoginProcess(LoginForm lf) {
		this.lf = lf;
		mapLoginData = new HashMap<String, String>();
		mapLoginData.put("kim", "1234");
		mapLoginData.put("kim2", "Lee1234");
		mapLoginData.put("park", "q1w2e3r4");
	}//LoginProcess
	
	public void chkNull() {
		JTextField jtfId = lf.getJtfId();
		String id = jtfId.getText().trim();
		JPasswordField jpfPass = lf.getJtPassword();
		JLabel jlbResult = lf.getJlblResult();
		
		
		//early return
		if( "".equals(id) ) {//아이디가 없다면
			jtfId.requestFocus();//커서를 아이디에 위치시키고
			return;//호출한 곳으로 돌아가
		}//end if
		
		jpfPass.requestFocus();
		
		String pass = new String(jpfPass.getPassword()).trim();
//		String pass = String.valueOf(jpfPass.getPassword()).trim();//위에랑 똑같은 거
		
		if("".equals(pass)) {
			jpfPass.requestFocus();
			return;
		}//end if
		
		//아이디와 비밀번호가 있는 경우
		String resulMsg = "<html>로그인 실패 -<br> 아이디나 비번을 확인하세요.</html>";
		if (login(id, pass)) {
			resulMsg = "로그인 성공!!!";
		}//end if
		
		jlbResult.setText(resulMsg);
		
	}//chkNull
	
	
	private boolean login(String id, String pass) {
		boolean flag = false;
		
		if(	mapLoginData.containsKey(id)) {//아이디가 있음
			flag = mapLoginData.get(id).equals(pass); //비밀번호가 맞으면 true, 틀리면 false
		}
		
		return flag;
	}//login
}
