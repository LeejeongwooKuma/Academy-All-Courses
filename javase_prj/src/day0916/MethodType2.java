package day0916;

import day0901.StudentDTO;

@FunctionalInterface
public interface MethodType2 {

	/**
	 * 반환형 없고, 매개변수 있는 형
	 * @param sDTO 학생의 이름과 나이를 저장하는 DTO객체
	 * @param name 이름
	 */
	public void typeB(StudentDTO sDTO, String name);
	
}
