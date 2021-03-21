package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미로탐색 {
	
	static int r, c, ans;
	static char[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		dp = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < c ; j++) {
				dp[i][j] = 987654321;
			}
		}
		dp[0][0] = 1;
		ans = 987654321;
		go(0, 0);
		System.out.println(dp[r-1][c-1]);
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void go(int i, int j) {

		if(i == r - 1 && j == c - 1) return;
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if(nr >= 0 && nc >= 0 && nr < r && nc < c && arr[nr][nc] == '1') {
				if(dp[nr][nc] > dp[i][j] + 1) {
					dp[nr][nc] = dp[i][j] + 1;
					go(nr, nc);
				}
			}
		}
	}
}
