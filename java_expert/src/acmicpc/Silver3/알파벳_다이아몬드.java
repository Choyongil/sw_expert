package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_다이아몬드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		String s = "abcdefghijklmnopqrstuvwxyz";

		for(int i = r1 ; i <= r2 ; i++) {
			sb = new StringBuilder();
			for(int j = c1 ; j <= c2 ; j++) {
				sb.append( Math.abs(n - i % (2*n - 1) - 1) + Math.abs(n - j % (2*n - 1) - 1) >= n ? '.' :
						s.charAt((Math.abs(n - i % (2*n - 1) - 1) + Math.abs(n - j % (2*n - 1) - 1)) % 26));
			}
			System.out.println(sb);
			sb.setLength(0);
		}
		br.close();
	}
}
