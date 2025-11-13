package teamProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AnalizeProcess2 extends JFrame {
	private JLabel jlblInputName;
	private JPanel jlblStartNum;
	private JPanel jlblEndNum;
	private JLabel jlblStartName;
	private JLabel jlblEndName;
	private JTextField jtaStartNum;
	private JTextField jtaEndNum;
	private JButton Analize;
	private JButton makeFile;
	private JPanel jp;
	private JPanel jp2;
	private JTextArea jtaPrintResult;
	private JPanel button;

	private Map<String, Integer> mapResponseResult;// 맨 앞에 200,400 등 응답 결과
	private Map<String, Integer> mapBrowser; // 접속 브라우저
	private Map<String, Integer> mapKey; // key 값 : java, jsp, HTML등등
	private List<String> Filelist; // txt파일 저장할 리스트

	public AnalizeProcess2() {
		super("임시 작업용");
		setLayout(new BorderLayout());
		jp = new JPanel();
		jp2 = new JPanel();
		jlblStartNum = new JPanel(new FlowLayout());
		jlblEndNum = new JPanel(new FlowLayout());
		jlblStartName = new JLabel("시작");
		jlblEndName = new JLabel("끝");
		jp.setLayout(new GridLayout(2, 2));
		jlblInputName = new JLabel("범위 입력");
		jtaStartNum = new JTextField(10);
		jtaEndNum = new JTextField(10);
		Analize = new JButton("분석");
		makeFile = new JButton("파일 변환");
		jtaPrintResult = new JTextArea();
		button = new JPanel(new FlowLayout());

		jlblStartNum.add(jlblStartName);
		jlblStartNum.add(jtaStartNum);
		jlblEndNum.add(jlblEndName);
		jlblEndNum.add(jtaEndNum);
		jp.add(jlblInputName);
		jp.add(jp2);
		jp.add(jlblStartNum);
		jp.add(jlblEndNum);
		button.add(Analize);
		button.add(makeFile);

		add("North", jp);
		add("Center", jtaPrintResult);
		add("South", button);

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// AnalizeProcess

	// txt파일 가져오기
	public void loadTxt() {
		File file = new File("C:/dev/temp/sist_input_3.log");
		Path path = Path.of(file.getAbsolutePath());

		try {
			Filelist = Files.readAllLines(path);
			sortMap();
		} catch (IOException e) {
			e.printStackTrace();
		} // catch
	}// loadTxt

	// Map 분류하기
	public void sortMap() {
		mapKey = new HashMap<String, Integer>();
		mapBrowser = new HashMap<String, Integer>();
		mapResponseResult = new HashMap<String, Integer>();
		Pattern pattern = Pattern.compile("\\[([^\\]]+)\\]");// 여는 대괄호~닫는 대괄호 사이의 값 추출
		Pattern pattern2 = Pattern.compile("(?<=key=)[^&]+(?=&)"); // 키 값에 사용할 정규식
		Matcher matcher;
		Matcher matcher2;// 최다 사용 key값에 쓸 matcher

		int cnt = 0; // matcher.find로 몇 번째 []를 찾을것인지
		for (String line : Filelist) {// log파일의 데이터를 저장한 list값 하나씩 뽑아오기
			matcher = pattern.matcher(line);
			matcher2 = pattern2.matcher(line);

			if (matcher.find())
				mapResponseResult.put(matcher.group(1), mapResponseResult.getOrDefault(matcher.group(1), 0) + 1); // key값이
			if (matcher2.find())
				mapKey.put(matcher2.group(), mapKey.getOrDefault(matcher2.group(), 0) + 1);
			while (matcher.find()) {//
				cnt++;
				if (cnt == 2)
				mapBrowser.put(matcher.group(1), mapBrowser.getOrDefault(matcher.group(1), 0) + 1);
			} // end while
			cnt = 0;
		} // end for
	} // sortMap

//	 최다사용 키의 이름과 횟수 | java xx회
	public void KeyNameAcc() {

		int maxValue = 0;// 가장 큰 키의 벨류 값 저장
		String maxKey = "";// 가장 큰 키값 저장
		for (String str : mapKey.keySet()) {
			if (mapKey.get(str) > maxValue) {
				maxKey = str;
				System.out.println("키 : " + str + " 벨류 : " + mapKey.get(str));
				maxValue = mapKey.get(str);
			} // end if
		} // end for
		System.out.println("최다 사용 key : " + maxKey + " | 사용 횟수 : " + maxValue + "회");
		System.out.println("------------------------------------------");
	}// KeyNameAcc

	// 브라우저별 접속횟수, 비율
	public void BrowserPerc() {
		System.out.println("ie : " + mapBrowser.get("ie"));
		int sumConnetion = 0;// 총 접속 횟수
		for (String str : mapBrowser.keySet()) {// 총 접속 횟수 구하기
			sumConnetion += mapBrowser.get(str);
		} // end for
		for (String str : mapBrowser.keySet()) {// 값 출력하기
			System.out.printf("브라우저 : %-10s 접속횟수 : %d회 (%.2f%%)\n", str, mapBrowser.get(str),
					(((double) mapBrowser.get(str) / sumConnetion) * 100));
		} // end for
	}// BrowserPerc

	// 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수
	public void SuccessFailCnt() {
		System.out.println("------------------------------------------");
		System.out.printf("접속 성공(200) : %d회 | 실패(404) : %d회", mapResponseResult.get("200"),
				mapResponseResult.get("404"));
	}// SuccessFailCnt

	public static void main(String[] args) {
		AnalizeProcess2 ap = new AnalizeProcess2();
		ap.loadTxt();
		ap.KeyNameAcc();
		ap.BrowserPerc();
		ap.SuccessFailCnt();
	}// main

}// class
