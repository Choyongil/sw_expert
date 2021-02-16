package D3;

import java.util.Scanner;

public class 햄버거_다이어트 {
	static int N;
	static int limit;
	static int[] score;
	static int[] cal;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			limit = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			for ( int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			sel = new boolean[N];
			ans = 0;
			hamburger(0,0,0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static boolean[] sel;
	static int ans = 0;
	
	static void hamburger(int idx, int sumCal, int sumScore) {
		if (sumCal > limit) {
			return;
		}
		if (sumScore > ans) {
			ans = sumScore;
		}
		if (idx == N) {
			return;
		}
		hamburger(idx + 1, sumCal + cal[idx], sumScore + score[idx]);
		hamburger(idx + 1, sumCal, sumScore);
	}
}
