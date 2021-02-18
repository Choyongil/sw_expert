package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역 {

	static int[][] map;
	static int n;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int max = -1;
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		int ans = 0;
		for(int m = 0 ; m <= max ; m++) {
			visit = new boolean[n][n];
			int cnt = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(map[i][j] > m && !visit[i][j]) {
						cnt += 1;
						func(i, j, m);
					}
				}
			}
			ans = Math.max(cnt, ans);
		}
		System.out.println(ans);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void func(int r, int c, int m) {

		visit[r][c] = true;
		int nr, nc, i;
		for(i = 0 ; i < 4 ; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(0 <= nr && nr < n && 0 <= nc && nc < n) {
				
				if(map[nr][nc] > m && !visit[nr][nc]) {
					func(nr, nc, m);
				}
			}
		}
		return;
	}
}
