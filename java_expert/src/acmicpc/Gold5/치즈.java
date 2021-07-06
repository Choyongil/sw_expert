package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {

	static int n, m, map[][], ans, cnt;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static boolean[][] visited;
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
		
		ans = 0;
		cnt = 0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		Queue<Point> queue = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if((i == 0 || i == n - 1) && (j == 0 || j == m - 1)) {
					visited[i][j] = true;
					queue.add(new Point(i,j));
				}
			}
		}
		
		// 맨 처음 map 상태에서 공기가 차지하는 부분
		while(!queue.isEmpty()) {
			
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
				if(map[nr][nc] == 1) continue;
				
				queue.add(new Point(nr,nc));
				visited[nr][nc] = true;
			}
		}

		while(true) {
			
			int tmp = check();
			if(tmp == 0) break;
			
			cnt = tmp;
			ans++;
			
			findOne();
			melt();
			
		}
		System.out.println(ans + "\n" + cnt);
	}
	
	public static void findOne() {
		Queue<Point> oneQ = new LinkedList<>();
		for(int i = 1 ; i < n - 1 ; i++) {
			for(int j = 1 ; j < m - 1 ; j++) {
				if(map[i][j] == 1) {
					oneQ.add(new Point(i,j));
				}
			}
		}
		
		while(!oneQ.isEmpty()) {
			
			Point q = oneQ.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				if(map[nr][nc] == 0 && visited[nr][nc]) {
					// melt
					map[q.r][q.c] = 2;
					break;
				}
			}
		}
	}
	
	// 녹아 없어져야될 치즈(map 상에서 값이 2인 부분)를 0으로 change
	public static void melt() {
		
		Queue<Point> queue = new LinkedList<>();
		for(int i = 1 ; i < n - 1 ; i++) {
			for(int j = 1 ; j < m - 1 ; j++) {
				if(map[i][j] == 2) {
					queue.add(new Point(i,j));
					visited[i][j] = true;
					map[i][j] = 0;
				}
			}
		}	
		
		// 치즈가 녹으면서 공기가 없던 구멍에 공기가 통하게 만들기
		while(!queue.isEmpty()) {
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
				if(map[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.add(new Point(nr,nc));
				}
			}
		}
	}
	
	// 남아있는 치즈가 있는지 확인
	public static int check() {
		int cnt = 0;
		for(int i = 1 ; i < n - 1 ; i++) {
			for(int j = 1 ; j < m - 1 ; j++) {
				if(map[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
}
