package acmicpc.Silver1;

import java.util.Scanner;

public class 오르막_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[] {1,1,1,1,1,1,1,1,1,1};
		
		for(int i = 1 ; i < n ; i++) {
			for(int j = 1 ; j < 10 ; j++) {
				dp[j] = (dp[j] + dp[j-1]) % 10007;
			}
		}
		int sum = 0;
		for(int i = 0 ; i < 10 ; i++) {
			sum += dp[i];
		}
		
		System.out.println(sum % 10007);
	}
}
// [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]
// [1, 5, 12, 23, 39, 61, 90, 127, 173, 229]