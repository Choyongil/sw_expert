package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이_판다 {

	static int n, map[][], dp[][], ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 1;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				ans = Math.max(ans, dfs(i,j));
			}
		}
		System.out.println(ans);
	}
	
	public static int dfs(int r, int c) {
		
		if(dp[r][c] != 0) return dp[r][c];
		
		dp[r][c] = 1;
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
			if(map[nr][nc] > map[r][c]) {
				dp[r][c] = Math.max(dfs(nr, nc) + 1, dp[r][c]);
				dfs(nr,nc);
			}
		}
		
		return dp[r][c];
	}
}
