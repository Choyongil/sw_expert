package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 토너먼트 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		Integer.parseInt(st.nextToken());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		int cnt = 0;
		while(true) {
			a = Math.round(a / 2);
			b = Math.round(b / 2);
			cnt += 1;
			if (a == b) break;
		}
		System.out.println(cnt);
	}
}
