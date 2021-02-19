package acmicpc.Silver3;

import java.util.Scanner;

public class 계단_오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] sta = new int[301];
		int n = sc.nextInt();
		
		if( n == 1) {
			System.out.println(sc.nextInt());
		}
		else {
			for(int i = 1 ; i <= n ; i++) {
				sta[i] = sc.nextInt();
			}
			int[] ans = new int[301];
			ans[1] = sta[1];
			ans[2] = sta[2] + sta[1];
			for(int i = 3 ; i <= n ; i++) {
				ans[i] = Math.max(sta[i] + sta[i-1] + ans[i-3], sta[i] + ans[i-2]);
			}

			System.out.println(ans[n]);
		}
		sc.close();
	}
}
