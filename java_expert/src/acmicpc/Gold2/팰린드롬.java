package acmicpc.Gold2;

import java.util.Scanner;

public class 팰린드롬 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean[][] dp = new boolean[n+1][n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			dp[i][i] = true;
		}
		for(int i = 1 ; i <= n-1 ; i++) {
			if(arr[i+1] == arr[i]) dp[i][i+1] = true;
		}
		
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 1 ; j <= n - i ; j++) {
				if(arr[j] == arr[j+i] && dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
				}
			}
		}
		
		int m = sc.nextInt();
		for(int i = 0 ; i < m ; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			if(dp[s][e]) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
}
