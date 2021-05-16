package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {

	static int n, m, map[][], ans;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		ans = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				visited[i][j] = true;
				go(i, j, 1, map[i][j]);
				visited[i][j] = false;
				go2(i,j,map[i][j]);
			}
		}
		System.out.println(ans);
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0 ,-1};
	public static void go(int r, int c, int cnt, int sum) {
		
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			if(visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			go(nr, nc, cnt + 1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
		
	}
	// ㅗ ㅜ ㅓ ㅏ 
	static int fR[][] = {{1, 1, 1},
			{0, 0, 1},
			{1, 1, 2},
			{1, 1, 2}};
	static int fC[][] = {{-1, 0, 1},
			{1, 2, 1},
			{-1, 0, 0},
			{0, 1, 0}};
	public static void go2(int r, int c, int sum) {
		for(int i = 0 ; i < 4; i++) {
			int tmp = sum;
			boolean flag = true;
			out : for(int d = 0 ; d < 3; d++) {
				int nr = r + fR[i][d];
				int nc = c + fC[i][d];
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
					flag = false;
					break out;
				}
				tmp += map[nr][nc];
			}
			if(flag) ans = Math.max(ans, tmp);
		}
		
	}
	
}
