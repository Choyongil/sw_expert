package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 후위_표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		for(char c : str.toCharArray()) {
			if(c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else if(c == '(') {
				stack.add(c);
			} else if(c == ')') {
				
				while(!stack.isEmpty()) {
					char tmp = stack.pop();
					if(tmp == '(') break;
					sb.append(tmp);
				}
			
			} else {
				
				while(!stack.isEmpty() && checkPrior(c) <= checkPrior(stack.peek())) {
					sb.append(stack.pop());
				}
				stack.add(c);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
		
	}
	
	public static int checkPrior(char c) {
		if(c == '*' || c == '/') return 2;
		else if(c == '+' || c == '-') return 1;
		else return 0;
	}
}
