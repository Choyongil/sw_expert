package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 괄호_추가하기 {

	static int ans;
	static List<Integer> num;
	static List<Character> op;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		num = new ArrayList<>();
		op = new ArrayList<>();
		for(char c : input) {
			if(c <= '9' && c >= '0') num.add(c - '0');
			else op.add(c);
		}

		ans = -987654321;
		dfs(0, num.get(0));
		System.out.println(ans);
		
	}
	
	public static void dfs(int idx, int sum) {
		
		if(idx >= op.size()) {
			ans = Math.max(ans, sum);
			return;
		}
		
		// 괄호 없이
		dfs(idx + 1, calc(sum, num.get(idx + 1), op.get(idx)));
		
		// 괄호 있이
		// 연산자가 최소 하나 더 있어야한다.
		if(idx + 1 < op.size()) {
			int tmp = calc(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1));
			dfs(idx + 2, calc(sum, tmp, op.get(idx)));
		}
	}
	
	public static int calc(int n, int x, char op) {
		
		if(op == '+') {
			return n + x;
		} else if(op == '-') {
			return n - x;
		} else if(op == '*'){
			return n * x;
		}

		return 1;
	}
}
