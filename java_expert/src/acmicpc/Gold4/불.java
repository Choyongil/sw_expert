package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {

	static int n, x, y, sR, sC, ans;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static char map[][];
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc < T ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map = new char[y][x];
			
			for(int i = 0 ; i < y ; i++) {
				char[] charList = br.readLine().toCharArray();
				
				for(int j = 0 ; j < x ; j++) {
					map[i][j] = charList[j];
					
					// 현재 위치 파악
					if(map[i][j] == '@') {
						sR = i;
						sC = j;
					}
				}
			}
			
			move();
			sb.append(ans == -1 ? "IMPOSSIBLE" : ans + 1).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static void move() {
		
		Queue<Point> queue = new LinkedList<>();	// 상근이가 갈 수 있는 공간의 좌표 값을 저장하는 큐
		queue.add(new Point(sR, sC, 0));

		Queue<Point> fire = new LinkedList<>();		// 불이 번지는 좌표 값을 저장하는 큐
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				if(map[i][j] == '*') fire.add(new Point(i,j,0));
			}
		}

		ans = -1;
		boolean[][] visited = new boolean[y][x];
		visited[sR][sC] = true;
		
		// 상근이가 갈 수 있는 공간이 없을때까지 반복
		while(!queue.isEmpty()) {
			
			// 불 번지기 시작
			int fireSize = fire.size();
			for(int i = 0 ; i < fireSize ; i++) { 
				Point f = fire.poll();
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = f.r + dr[d];
					int nc = f.c + dc[d];
					
					// 범위를 벗어나면 continue
					if(nr < 0 || nc < 0 || nr >= y || nc >= x) continue;
					// 새로운 위치가 이미 불이 번져있거나 벽이면 continue
					if(map[nr][nc] == '*' || map[nr][nc] == '#') continue;
					
					map[nr][nc] = '*';
					fire.add(new Point(nr, nc, 0));
				}
			}
			
			// 상근이가 갈 수 있는 좌표 값을 최신화
			int queueSize = queue.size();
			for(int i = 0 ; i < queueSize ; i++) {

				Point q = queue.poll();
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = q.r + dr[d];
					int nc = q.c + dc[d];
					
					// 범위를 벗어나면 탈출
					if(nr < 0 || nc < 0 || nr >= y || nc >= x) {
						ans = q.cnt;
						return;
					}
					
					// 새로운 위치가 불이 번져있거나 벽이거나 이미 방문한 적이 있다면 continue
					if(map[nr][nc] == '*' || map[nr][nc] == '#' || visited[nr][nc]) continue;
					visited[nr][nc] = true;
					queue.add(new Point(nr, nc, q.cnt + 1));
				}
				
			}
		}
	}
}
