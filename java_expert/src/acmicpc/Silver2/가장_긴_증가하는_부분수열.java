package acmicpc.Silver2;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 가장_긴_증가하는_부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i = 0 ; i < n ; i++) {
			dp[i] = 1;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 1;
		for(int i = 0 ; i < n ; i++) {
			int tmp = arr[i];
			for(int j = 0 ; j < i ; j++) {
				if(arr[j] < tmp) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		
	}
}
//9
//10 20 10 30 20 50 10 10 10
//3
//10 10 10