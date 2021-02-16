package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거_다이어트2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			int[] cal = new int[N];
			
			for ( int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			int sum_s, sum_c;
			for(int i = 0 ; i < Math.pow(2, N) ; i++) {
				sum_s = 0;
				sum_c = 0;
				for(int j = 0 ; j < N ; j++) {
					if( (i & (1 << j)) > 0) {
						sum_s += score[j];
						sum_c += cal[j];
					}
					if(sum_c > limit) break;
					ans = Math.max(ans, sum_s);
				}
			}
			sb.append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
