package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class knapsack_01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] NK = new int[n+1][2];
			
			for(int i = 1 ; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				
				NK[i][0] = Integer.parseInt(st.nextToken());
				NK[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[n+1][k+1];
			
			for(int i = 1 ; i <= n ; i++) {
				int cur_v = NK[i][0];
				int cur_c = NK[i][1];
				for(int j = 1 ; j <= k ; j++) {
					if(j >= cur_v) {
						dp[i][j] = Math.max(cur_c + dp[i-1][j-cur_v], dp[i-1][j]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			sb.append(dp[n][k]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
//2
//4 5
//1 2
//3 2
//4 4
//2 3
//4 5
//1 2
//3 2
//4 4
//2 3