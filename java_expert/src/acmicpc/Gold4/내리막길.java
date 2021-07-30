package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {

	static int r, c, map[][], dp[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r+1][c+1];
		dp = new int[r+1][c+1];
		for(int i = 1 ; i <= r ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= c ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		dfs(1,1);
		System.out.println(dp[1][1]);
	}
	
	public static int dfs(int y, int x) {
		
		// 도착지점 도착
		if(y == r && x == c) return 1;
		
		if(dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 0;
		for(int d = 0 ; d < 4 ; d++) {
			int nr = y + dr[d];
			int nc = x + dc[d];
			
			if(nr > 0 && nc > 0 && nr <= r && nc <= c && map[nr][nc] < map[y][x]) {
				dp[y][x] += dfs(nr,nc);
			}
			
		}
		return dp[y][x];
		
	}
}
