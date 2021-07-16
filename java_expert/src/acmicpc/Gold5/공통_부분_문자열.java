package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공통_부분_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		int ans = 0;
		
		int[][] dp = new int[l1+1][l2+1];
		for(int i = 1 ; i <= l1 ; i++) {
			for(int j = 1 ; j <= l2 ; j++) {
				
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		
		System.out.println(ans);
	}
}
