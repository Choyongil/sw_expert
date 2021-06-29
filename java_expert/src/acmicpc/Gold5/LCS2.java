package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		int r = s1.length();
		int c = s2.length();
		
		int[][] dp = new int[r+1][c+1];
		
		for(int i = 1 ; i <= r ; i++) {
			for(int j = 1 ; j <= c ; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
			}
		}
		String ans = "";
		
		int r2 = r;
		int c2 = c;
		int tmp = dp[r2][c2];
		while(true) {
			
			if(tmp == dp[r2-1][c2]) {
				r2--;
				tmp = dp[r2][c2];
			} else if( tmp == dp[r2][c2-1]) {
				c2--;
				tmp = dp[r2][c2];
			} else {
				ans = s2.charAt(c2-1) + ans;
				r2--;
				c2--;
				tmp = dp[r2][c2];
			}
			
			if( r2 <= 0 || c2 <= 0 ) break;
		}
		
		System.out.println(dp[r][c]);
		System.out.println(ans);
	}
}
