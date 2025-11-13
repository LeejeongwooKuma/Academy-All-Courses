package day0829;

import java.util.Stack;

/**
 * LIFO를 구현한 Stack 사용 
 */
public class UseStack {
	
	public UseStack() {
		//1.생성) - 자식은 부모의 자원 사용할 수 있다( 주의 : 사용하면 안됨)
		Stack<String> stack = new Stack<String>();//Vector를 활용
//		stack.add("헤헤");
//		stack.add("데헷");
		//값 할당)
		stack.push("되세요");//1
		stack.push("즐거운 주말");//2
		stack.push("오늘은 금요일");//3
		Stack<String> stk2 = new Stack<String>();
		String item = "";
		while(!stack.empty()) {//스택에 아이템이 존재하면..
			item = stack.pop();
			stk2.push(item);//history
			System.out.println(item);
		}//end while
		System.out.println(stack);
		System.out.println(stk2);
	}//UseStack

	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
