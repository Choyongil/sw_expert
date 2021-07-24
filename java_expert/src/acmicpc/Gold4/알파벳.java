package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {

	static int r, c, ans;
	static char map[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited[map[0][0] - 'A'] = true;
		
		
		ans = 1;
		
		dfs(0,0,1);
		System.out.println(ans);
 	}
	
	public static void dfs(int y, int x, int cnt) { 
		
		ans = Math.max(ans, cnt);
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = y + dr[d];
			int nc = x + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
			
			if(!visited[map[nr][nc] - 'A']) {
				visited[map[nr][nc] - 'A'] = true;
				dfs(nr, nc, cnt + 1);
				visited[map[nr][nc] - 'A'] = false;
			}
		}
		
	}
}
