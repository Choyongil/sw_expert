package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 계산기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#" + tc + " ");
			
			int T = Integer.parseInt(br.readLine());
			
			char[] str = br.readLine().toCharArray();
			char[] str2 = new char[T];
			
			Stack<Character> s = new Stack<>();
			int idx = 0;
			
			for(char c : str) {
				if (c != '+' && c!= '*') {
					str2[idx++] = c;
				}
				else if(c == '+') {
					while( s.size() != 0) {
						str2[idx++] = s.pop();
					}
					s.add(c);
				}
				else if(c == '*') {
					while( s.size() != 0 && s.peek() == '*') {
						str2[idx++] = s.pop();
						}
					s.add(c);
				}
			}
			while(s.size() != 0) {
				str2[idx++] = s.pop();
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
					else d = a*b;
					ans.add(d);
				}
			}
			
			sb.append(ans.pop());
			
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
