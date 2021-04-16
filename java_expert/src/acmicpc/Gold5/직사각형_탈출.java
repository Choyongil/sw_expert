package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형_탈출 {

	static int n, m, arr[][], h, w, sR, sC, fR, fC, ans;
	static class Point{
		int r;
		int c;
		int cnt;
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sR = Integer.parseInt(st.nextToken());
		sC = Integer.parseInt(st.nextToken());
		fR = Integer.parseInt(st.nextToken());
		fC = Integer.parseInt(st.nextToken());
		
		ans = -1;

		go();
		System.out.println(ans);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	private static void go() {
		
		if(sR == fR && sC == fC) {
			ans = 0;
			return;
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(sR, sC, 0));
		boolean[][] visited = new boolean[n+1][m+1];
		visited[sR][sC] = true;
		
		while(!queue.isEmpty()) {
			
			Point cur = queue.poll();
			
			if(cur.r == fR && cur.c == fC) {
				ans = cur.cnt;
				return;
			}
			
			out :for(int d = 0 ; d < 4 ; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
                
				if(nr <= 0 || nr + h - 1 > n || nc <= 0 || nc + w - 1 > m || visited[nr][nc]) continue;
				
				for(int i = nr ; i < nr + h ; i++) {
					if(arr[i][nc] == 1 || arr[i][nc + w - 1] == 1) continue out;
				}
				for(int j = nc ; j < nc + w ; j++) { 
					if(arr[nr][j] == 1 || arr[nr + h - 1][j] == 1) continue out;
				}
				visited[nr][nc] = true;
				queue.offer(new Point(nr, nc, cur.cnt+1));
			}
		}
	}
}