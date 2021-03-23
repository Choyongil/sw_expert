package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][3];
		int[][] dp = new int[n][3];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = r;
			arr[i][1] = g;
			arr[i][2] = b;
			
			if(i == 0) {
				dp[i][0] = r;
				dp[i][1] = g;
				dp[i][2] = b;
			} else {
				dp[i][0] = Math.min(dp[i-1][1] + r, dp[i-1][2] + r);
				dp[i][1] = Math.min(dp[i-1][0] + g, dp[i-1][2] + g);
				dp[i][2] = Math.min(dp[i-1][0] + b, dp[i-1][1] + b);
			}
		}

		int min = 9874321;
		for(int i = 0 ; i < 3 ; i++) {
			min = Math.min(min, dp[n-1][i]);
		}
		System.out.println(min);
	}
}
