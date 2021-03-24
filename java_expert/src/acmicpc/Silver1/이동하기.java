package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기 {

	static int n, m;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				int x = Integer.parseInt(st.nextToken());
				
				dp[i][j] = x;
				if(i == 0 && j == 0) continue;
				
				if(i == 0) dp[i][j] += dp[i][j-1];
				else if(j == 0) dp[i][j] += dp[i-1][j];
				else dp[i][j] += Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}
