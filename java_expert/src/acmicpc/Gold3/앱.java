package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n][100001];
		int ans = 9876421;
		
		for(int i = 0 ; i < n ; i++) {
			int memory = arr1[i];
			int cost = arr2[i];
			
			for(int j = 0 ; j < 100001 ; j++) {
				if(i == 0) {
					if(j >= cost) dp[i][j] = memory;
				} else {
					if(j >= cost) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost] + memory);
					else dp[i][j] = dp[i-1][j];
				}
				if(m <= dp[i][j]) ans = Math.min(ans, j);
			}
		}
		
		System.out.println(ans);
	}
}
