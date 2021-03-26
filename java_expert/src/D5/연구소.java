package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소 {

	static int n, m, ans;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		build(0, 0, 3);
	
		System.out.println(ans);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static void build(int r, int c, int cnt) {
		
		if(cnt == 0) {
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(map[i][j] == 2) spread(i,j,3);
				}
			}
			
			ans = Math.max(ans, check());
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(map[i][j] == 2) spread(i,j,0);
				}
			}
			return;
		}
		
		if(r == n - 1 && c == m) return;
		
		if(c == m) {
			build(r+1, 0, cnt);
			return;
		}
		
		if(map[r][c] > 0) {
			build(r, c+1, cnt);
		} else {
			
			map[r][c] = 1;
			build(r, c+1, cnt-1);
			map[r][c] = 0;
			build(r, c+1, cnt);
			
		}
	}

	private static void spread(int r, int c, int x) {
		
		int s = x == 3? 0 : 3;
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			if(map[nr][nc] == s) {				
				map[nr][nc] = x;
				spread(nr,nc,x);
			}
		}
		
	}
	
	private static int check() {
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 0) sum++;
			}
		}
		return sum;
	}
}
