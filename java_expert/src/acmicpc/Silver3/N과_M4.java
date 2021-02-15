package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M4 {
	
	static int n;
	static int m;
	static int[] numbers;
	static int[] input;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		input = new int[n];
		for(int i = 1 ; i <= n ; i++) {
			input[i-1] = i;
		}
		sb = new StringBuilder();
		func(0, 0);
		System.out.println(sb);
	}
	
	public static void func(int cnt, int idx) {
		if (cnt == m) {
			for(int i : numbers) {
				sb.append(i + " ");
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			return;
		}
		
		for(int i = idx ; i < n ; i++) {
			numbers[cnt] = input[i];
			func(cnt+1, i);
		}
	}
}
