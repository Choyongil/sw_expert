package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M9 {
	
	static int n;
	static int m;
	static int[] numbers;
	static int[] tmp_numbers;
	static int[] input;
	static StringBuilder sb;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[m];
		tmp_numbers = new int[m];
		input = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		isSelected = new boolean[n];
		sb = new StringBuilder();
		func(0, 0);
		System.out.println(sb);
	}
	
	public static boolean check(int[] a, int[] b) {
		for(int i = 0 ; i < m ; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
	public static void func(int cnt, int idx) {
		
		if (cnt == m) {
			if(check(tmp_numbers,numbers)) {
				return;
			}
			else {
				for(int i : numbers) {
					sb.append(i + " ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
				for(int i = 0 ; i < m ; i++) {
					tmp_numbers[i] = numbers[i];
				}
				return;
			}
		}
		int tmp_num = -1;
		for(int i = idx ; i < n ; i++) {
			if(isSelected[i] || tmp_num == input[i]) continue;
			tmp_num = input[i];
			isSelected[i] = true;
			numbers[cnt] = input[i];
			func(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}
}
