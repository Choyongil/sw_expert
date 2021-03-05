package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for(int i = 0 ; i < 2 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1 ; j <= n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
			for(int i = 2 ; i <= n ; i++) {
				dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
