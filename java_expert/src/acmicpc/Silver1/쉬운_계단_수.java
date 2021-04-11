package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운_계단_수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[12][2];
		
		for(int i = 2 ; i < 11 ; i++) {
			dp[i][0] = 1;
		}
		
		long ans = 0;
		for(int i = 2 ; i <= n ; i++) {
			ans = 0;
			for(int j = 1; j < 11 ; j++) {
				dp[j][(i-1)%2] = (dp[j-1][i%2] + dp[j+1][i%2]) % 1000000000;
				ans += dp[j][(i-1)%2];
			}
			for(long[] a : dp)System.out.println(Arrays.toString(a));
			System.out.println(ans);
			System.out.println();
		}
		System.out.println(n == 1? 9 : ans % 1000000000);
	}
}
