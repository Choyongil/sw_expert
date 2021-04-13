package acmicpc.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[n+1][m+1];
			
			for(int i = 1 ; i <= m ; i++) {
				dp[1][i] = i;
			}
			for(int i = 2 ; i <= n ; i++) {
				for(int j = 1 ; j <= m ; j++) {
					dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}
}
