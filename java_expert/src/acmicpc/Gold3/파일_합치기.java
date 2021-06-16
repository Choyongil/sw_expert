package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일_합치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n+1];
			int sum[] = new int[n+1];
			int[][] dp = new int[n+1][n+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + arr[i];
			}
			
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; i + j <= n ; j++) {
					int x = j + i;
					dp[j][x] = Integer.MAX_VALUE;
					
					for(int k = j ; k < x ; k++) {
						dp[j][x] = Math.min(dp[j][x], dp[j][k] + dp[k+1][x] + sum[x] - sum[j-1]);
					}
				}
			}
			System.out.println(dp[1][n]);
			
		}
	}
}
