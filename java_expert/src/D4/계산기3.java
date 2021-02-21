package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 계산기3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#" + tc + " ");
			
			int T = Integer.parseInt(br.readLine());
			
			char[] str = br.readLine().toCharArray();
			ArrayList<Character> str2 = new ArrayList<Character>();
			Stack<Character> s = new Stack<>();
			
			for(char c : str) {
				if (c != '+' && c!= '*' && c != '(' && c != ')') {
					str2.add(c);
				}
				else if(c == '+') {
					while( s.size() != 0 && s.peek() != '(') {
						str2.add(s.pop());
					}
					s.add(c);
				}
				else if(c == '*') {
					while( s.size() != 0 && s.peek() == '*') {
						str2.add(s.pop());
						}
					s.add(c);
				}
				else if(c == '(') {
					s.add(c);
				}
				else if(c == ')') {
					while(s.peek() != '(') {
						str2.add(s.pop());
					}
					s.pop();
				}
			}
			while(s.size() != 0) {
				str2.add(s.pop());
			}
			Stack<Integer> ans = new Stack<>();
			
			for(char c : str2) {
				if (c != '+' && c!= '*') {
					ans.add(c - '0');
				}
				else {
					int a = ans.pop();
					int b = ans.pop();
					int d;
					if( c == '+' ) d = a + b;
					else d = a * b;
					ans.add(d);
				}
			}
			sb.append(ans.pop() + "\n");
		}
		System.out.println(sb);
		sb.setLength(0);
	}
}
