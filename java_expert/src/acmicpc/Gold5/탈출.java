package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

	static int n, m, ans, x, y;
	static char[][] map;
	static boolean[][] waterV;
	static Queue<Point> queue, waterQ;
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		waterV = new boolean[n][m];
		queue = new LinkedList<>();
		waterQ = new LinkedList<>();
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					queue.add(new Point(i,j));
				} else if(map[i][j] == 'D') {
					x = i;
					y = j;
				} else if(map[i][j] == '*') {
					waterV[i][j] = true;
					waterQ.add(new Point(i,j));
				}
			}
		}
		
		ans = solve();
		
		System.out.println(ans == -1 ? "KAKTUS" : ans);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int solve() {
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			
			flood();
			cnt++;
			
			int len = queue.size();
			
			for(int i = 0 ; i < len ; i++) {
				Point q = queue.poll();
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = q.r + dr[d];
					int nc = q.c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
					
					if(nr == x && nc == y) return cnt;
					
					if(map[nr][nc] == '.') {
						queue.add(new Point(nr,nc));
						map[nr][nc] = 'S';
					}
				}
			}
			
		}
		return -1;
	}
	private static void flood() {

		int len = waterQ.size();
		for(int i = 0 ; i < len ; i++) {
			Point w = waterQ.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = w.r + dr[d];
				int nc = w.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				if(map[nr][nc] == 'X' || map[nr][nc] == 'D' || waterV[nr][nc]) continue;
				map[nr][nc] = '*';
				waterV[nr][nc] = true;
				waterQ.add(new Point(nr, nc));
			}
		}
		
		return;
	}
}