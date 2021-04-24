package acmicpc.Silver1;

import java.util.Scanner;

public class 동전1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] num = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;
		
		for(int i = 0 ; i < n ; i++) {
			num[i] = sc.nextInt();
			for(int j = num[i] ; j <= k ; j++) {
				dp[j] += dp[j - num[i]]; 
			}
		}
		System.out.println(dp[k]);
	}
}
