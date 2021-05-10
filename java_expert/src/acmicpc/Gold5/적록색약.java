package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {

	static int n, ans, ans2;
	static char map[][], map2[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		map2 = new char[n][n];
		char[] tmp = new char[n];
		for(int i = 0 ; i < n ; i++) {
			tmp = br.readLine().toCharArray();
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = tmp[j];
				map2[i][j] = tmp[j];
				if(map2[i][j] == 'G')map2[i][j] = 'R';
			}
		}
		
		ans = 0;
		ans2 = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] != 'a') {
					ans++;
					dfs(i,j,map[i][j], map);
				}
				if(map2[i][j] != 'a') {
					ans2++;
					dfs(i,j,map2[i][j], map2);
				}
			}
		}
		System.out.println(ans + " " + ans2);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void dfs(int r, int c, char rgb, char[][] map) {
		map[r][c] = 'a';
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
			if(map[nr][nc] != rgb || map[nr][nc] == 'a') continue;
			dfs(nr, nc, rgb, map);
		}
	}
}
