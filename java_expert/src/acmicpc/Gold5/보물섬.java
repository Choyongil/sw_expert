package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {

	static int n, m, ans;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point {
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		ans = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 'L') {
					road(i,j);
				}
			}
		}
		System.out.println(ans);
		
	}
	
	public static void road(int sR, int sC) {
		boolean[][] visited = new boolean[n][m];
		visited[sR][sC] = true;
		Queue<Point> pq = new LinkedList<>();
		pq.add(new Point(sR,sC,0));
		
		while(!pq.isEmpty()) {
			
			Point q = pq.poll();
			
			ans = Math.max(ans, q.cnt);
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 'W' || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				pq.add(new Point(nr, nc, q.cnt + 1));
			}
		}
	}
}
