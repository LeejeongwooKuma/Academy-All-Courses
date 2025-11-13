package teamProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 이정우
 * 
 * 작업 순서
 * lodaTxt메소드로 log파일을 불러온 다음 sortMap메소드로 Map별로 분류 <br>
 * 
 * (기본적으로 대괄호 기준으로 분류 했으며 KeyNameAcc의 경우는 key값을 찾기 위해 따로 정규식 사용<br>
 * 
 * 분류된 map값을 가지고 KeyNameAcc, BrowserPerc, SuccessFailCnt메소드로 출력
 */
public class AnalizeProcess {
	private Map<String, Integer> mapResponseResult;// 맨 앞에 200,400 등 응답 결과
	private Map<String, Integer> mapBrowser; // 접속 브라우저
	private Map<String, Integer> mapKey; // key 값 : java, jsp, HTML등등
	private List<String> Filelist; // txt파일 저장할 리스트
	
	private File file; 
	private Path path;
	private String str;
	//날짜 생
	public void makeTitle() {
		FileTime creationTime;
		try {
			creationTime = (FileTime) Files.getAttribute(path, "creationTime");
			ZonedDateTime zdt = creationTime.toInstant().atZone(ZoneId.systemDefault());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd EEEE a hh:mm:ss", Locale.US);
			str = "파일명 : " + file.getName() + " 생성된 날짜 : " +  zdt.format(formatter);
			System.out.println(str);
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	// txt파일 가져오기
	public void loadTxt() {
		
		file = new File("C:/dev/temp/sist_input_1.log");
		path = Path.of(file.getAbsolutePath());
		try {
			Filelist = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		makeTitle();
		sortMap();
	}// loadTxt

	// file에서 불러온 값들을 Map으로 분류하기
	public void sortMap() {
		mapKey = new HashMap<String, Integer>();
		mapBrowser = new HashMap<String, Integer>();
		mapResponseResult = new HashMap<String, Integer>();
		Pattern pattern = Pattern.compile("\\[([^\\]]+)\\]");// 여는 대괄호~닫는 대괄호 사이의 값 추출
		Pattern pattern2 = Pattern.compile("(?<=key=)[^&]+(?=&)"); // 최다 사용 key 값 문제에 사용할 정규식
		Matcher matcher;
		Matcher matcher2;// 최다 사용 key값에 쓸 matcher

		int cnt = 0; // matcher.find로 몇 번째 []를 찾을것인지
		for (String line : Filelist) {// log파일의 데이터를 저장한 arrayList값 하나씩 뽑아오기
			matcher = pattern.matcher(line);
			matcher2 = pattern2.matcher(line);

			if (matcher.find()) {
				mapResponseResult.put(matcher.group(1), mapResponseResult.getOrDefault(matcher.group(1), 0) + 1);
			} // end if
			if (matcher2.find()) {
				mapKey.put(matcher2.group(), mapKey.getOrDefault(matcher2.group(), 0) + 1);
			} // end if
			while (matcher.find()) {
				cnt++;
				if (cnt == 2) {
					mapBrowser.put(matcher.group(1), mapBrowser.getOrDefault(matcher.group(1), 0) + 1);
				} // end if
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
				maxValue = mapKey.get(str);
			} // end if
		} // end for
		System.out.printf("최다 사용 key : %s  | 사용 횟수 : %d회\n", maxKey ,maxValue);
		System.out.println("------------------------------------------");
		
	}// KeyNameAcc

	// 브라우저별 접속횟수, 비율
	public void BrowserPerc() {
		int sumConnetion = 0;// 총 접속 횟수
		for (String str : mapBrowser.keySet()) {// 총 접속 횟수 구하기
			sumConnetion += mapBrowser.get(str);
		} // end for
		for (String str : mapBrowser.keySet()) {// 값 출력하기
			System.out.printf("브라우저 : %-10s 접속횟수 : %d회 (%.2f%%)\n", str, mapBrowser.get(str),(((double) mapBrowser.get(str) / sumConnetion) * 100));
		} // end for
	}// BrowserPerc

	// 서비스를 성공적으로 수행한(200) 횟수,실패(404) 횟수
	public void SuccessFailCnt() {
		System.out.println("------------------------------------------");
		System.out.printf("접속 성공(200) : %d회 | 실패(404) : %d회", mapResponseResult.get("200"),mapResponseResult.get("404"));
	}// SuccessFailCnt

	public String getStr() {
		return str;
	}



	public static void main(String[] args) {
		AnalizeProcess ap = new AnalizeProcess();
		ap.loadTxt();
		ap.KeyNameAcc();
		ap.BrowserPerc();
		ap.SuccessFailCnt();
	}// main

}// class
