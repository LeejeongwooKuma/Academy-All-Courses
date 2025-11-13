package day0828;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Work0827 {
	public String dateFormat(int num) {
		Locale[] loc = { Locale.KOREA, Locale.GERMAN, Locale.US, Locale.JAPAN };

		// num이 0,1,2,3,4가 아니면 0으로
		if (!(num > -1 && num < 5)) {
			num = 0;
		} // end if
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy a EEEE HH:mm:ss", loc[num]);
		LocalDateTime ldt = LocalDateTime.now();

		return ldt.format(dtf);
	}

	public String backUpFile(String fileName) {
		StringBuilder sb = new StringBuilder(fileName);

		int lastDotIndex = sb.lastIndexOf(".");

		if (lastDotIndex != -1) {// 확장자가 있는 파일
			sb.insert(lastDotIndex, "_bak");
		} else {// 확장자가 없는 파일
			sb.append("_bak");
		}

		return sb.toString();

	}
}
// class