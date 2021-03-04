package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이_탑_이동_순서 {
	static StringBuilder sb;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ans = 0;
		move(n, 1, 2, 3);
		System.out.println(ans);
		System.out.println(sb);
	}
	
	public static void move(int num, int from, int m, int to) {
		ans++;
		if(num == 1) {
			sb.append(from).append(" ").append(to).append("\n");
		} else {
			move(num-1, from, to, m);
			sb.append(from).append(" ").append(to).append("\n");
			move(num-1, m, from, to);
		}
	}
}
