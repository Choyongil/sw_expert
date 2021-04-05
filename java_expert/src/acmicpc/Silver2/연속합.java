package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		int[] dp = new int[n];
		dp[0] = arr[0];
		ans = dp[0];
		
		for(int i = 1 ; i < n ; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}
}