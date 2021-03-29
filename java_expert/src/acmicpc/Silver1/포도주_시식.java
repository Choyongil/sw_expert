package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주_시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(n == 1) {
			System.out.println(arr[n-1]);
			System.exit(0);
		} else if(n == 2) {
			System.out.println(arr[0] + arr[1]);
			System.exit(0);
		}
		dp[0] = arr[0];
		if(n > 1) dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(dp[1], arr[2] + Math.max(arr[0], arr[1]));
		
		for(int i = 3 ; i < n ; i++) {
			dp[i] = Math.max(dp[i-1], arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1]));
		}
		System.out.println(dp[n-1]);
	}
}
