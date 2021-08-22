package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 {

	static String str, bomb;
	static int n, bombSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		// 폭발물은 같은 문자를 두개 이상 포함하지 않는다.
		bomb = br.readLine();
		
		n = str.length();
		bombSize = bomb.length();

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i < n ; i++) {
			stack.push(str.charAt(i));
			
			// 스택에 들어온 문자열의 길이가 폭발 문자열의 길이보다 크거나 같다면 실행
			if(stack.size() >= bomb.length()) {				
				boolean flag = true;
				for(int j = bombSize - 1 ; j >= 0; j--) {
					if(stack.get(stack.size() - (bombSize - j)) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					for(int j = 0 ; j < bombSize ; j++) {
						stack.pop();
					}
				}
			}
		}
		
		// 스택에 저장된 문자가 없다면 FRULA
		if(stack.size() == 0) System.out.println("FRULA");
		else {
			for(char x : stack) sb.append(x);
			System.out.println(sb);
		}
	}
}
