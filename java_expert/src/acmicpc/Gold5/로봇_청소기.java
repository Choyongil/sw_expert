package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로봇_청소기 {

	static int n, m, arr[][], ans;
	static boolean visited[][];
	// 북 서 남 동
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][m];
		visited[r][c] = true;
		arr[r][c] = 2;
		ans = 1;
		if(d == 1) d = 3;
		else if(d == 3) d = 1;
  		go(r,c,d);
		
		System.out.println(ans);
	}
	private static void go(int r, int c, int d) {
		
		for(int i = 0 ; i < 4 ; i++) {
			int nd = (d + 1 + i) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			if(arr[nr][nc] == 1 || visited[nr][nc]) continue;
			arr[nr][nc] = 2;
			visited[nr][nc] = true;
			ans++;
			go(nr, nc, nd);
			
			return;
		}
		
		int nr = r + dr[(d+2) % 4];
		int nc = c + dc[(d+2) % 4];
		if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 1) return;
		go(nr, nc, d);
	}
	
	
}
