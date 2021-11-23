package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬_곱셈_순서 {

	static int n, value[][], dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		value = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			value[i][0] = a;
			value[i][1] = b;
		}
		
		dp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(i == j) continue;
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < n - i ; j++) {
				calc(j, i + j);
			}
		}

		System.out.println(dp[0][n - 1]);
	}
	
	public static void calc(int start, int end) {
		
		for(int i = start ; i < end ; i++) {
			int cost = dp[start][i] + dp[i + 1][end] + value[start][0] * value[i][1] * value[end][1];
			dp[start][end] = Math.min(cost, dp[start][end]);
		}
		
	}
}
