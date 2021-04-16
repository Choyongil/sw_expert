package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

	static int m, n, arr[][], zeroNum, ans;
	
	static class Point{
		int r;
		int c;
		int num;
		
		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		zeroNum = 0;
		ans = 1;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) zeroNum++;
			}
		}
		
		bfs();
		
		System.out.println(zeroNum > 0 ? -1 : ans-1);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void bfs() {
		
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] == 1) {
					queue.add(new Point(i,j,1));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] > p.num) continue;
				
				if(arr[nr][nc] == 0) {
					zeroNum--;
					arr[nr][nc] = p.num + 1;
					queue.add(new Point(nr, nc, p.num + 1));
					ans = Math.max(ans, p.num+1);
				}
			}
			if(zeroNum == 0) {
				return;
			}
		}
		return;
	}
}
