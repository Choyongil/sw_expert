package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {

	static int n, m, map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point {
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
		
		map = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가장자리는 모두 0이므로 (0,0)에서 시작해서 외부 공기를 2로 바꿔준다.
		air(0,0);
		melt();
		
	}
	
	// 외부 공기가 위치한 자리를 2으로 바꾼다.
	public static void air(int r, int c) {
		
		map[r][c] = 2;
		
		int nr, nc;
		for(int d = 0 ; d < 4 ; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			
			if(map[nr][nc] == 0) air(nr, nc);
		}
	}
	
	public static void melt() {
		
		Queue<Point> queue = new LinkedList<>();
		Queue<Point> chToAir = new LinkedList<>();
		
		for(int i = 1 ; i < n - 1 ; i++) {
			for(int j = 1 ; j < m - 1 ; j++) {
				
				if(map[i][j] == 1) {

					queue.add(new Point(i,j));
					
				}
			}
		}
		int ans = 0, cnt, nr, nc;
		while(!queue.isEmpty()) {
			
			ans++;
			
			int size = queue.size();
			
			while(size-- > 0) {
				Point q = queue.poll();
				
				cnt = 0;
				
				for(int d = 0 ; d < 4 ; d++) {
					nr = q.r + dr[d];
					nc = q.c + dc[d];
					
					// 외부 공기와 접촉하는 갯수를 센다.
					if(map[nr][nc] == 2) cnt++;
					
				}
				
				// 외부 공기와 접촉하는 면이 2개 미만이면 큐에 넣어준다.
				if(cnt < 2) queue.add(q);
				// 2 이상이면 공기로 바꿔줄 큐에 넣는다.
				else chToAir.add(q);
			}
			
			// 공기(2)로 바꿔준다.
			while(!chToAir.isEmpty()) {
				Point q = chToAir.poll();
				if(map[q.r][q.c] == 1) {
					air(q.r, q.c);
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
}


/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
*/