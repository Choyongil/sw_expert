package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// visited boolean 2차 배열을 static 으로 두고 연산을 하니까 시간초과...
// devide 함수에 인자값으로 넘겨주고, melt 에서도 따로 visited 를 선언하고 연산하니까 통과!!
// 덩어리를 확인하는 부분으로 2번째 들어오면 바로 break 걸어주기!!
public class 빙산 {

	static int r, c, map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point{
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < c ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		out: while(true) {
			
			ans++;
			
			// 빙산 녹이기
			melt();

			// dfs 로 나눠진 덩어리 찾기
			int cnt = 0;
			boolean[][] visited = new boolean[r][c];
			for(int i = 1 ; i < r - 1 ; i++) {
				for(int j = 1 ; j < c - 1 ; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						
						// 두 덩어리 이상이면 break
						// cnt 가 2가 되면 바로 끝내버리기
						if(cnt == 1) break out;
						
						divide(i,j,visited);
						cnt++;
					}
				}
			}
			
			if(cnt == 0) {
				ans = 0;
				break;
			}
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void divide(int y, int x, boolean[][] visited) {

		visited[y][x] = true;
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = y + dr[d];
			int nc = x + dc[d];
			
			if(nr < 1 || nc < 1 || nr >= r - 1 || nc >= c - 1) continue;
			
			if(map[nr][nc] != 0 & !visited[nr][nc]) divide(nr,nc, visited);
		}
	}
	
	public static void melt() {
		
		// 큐에 빙산 넣기, 빙산은 true
		boolean[][] visited = new boolean[r][c];
		Queue<Point> queue = new LinkedList<>();
		for(int i = 1 ; i < r ; i++) {
			for(int j = 1 ; j < c ; j++) {
				
				if(map[i][j] != 0) {
					
					queue.add(new Point(i,j));
					visited[i][j] = true;
					
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.y + dr[d];
				int nc = q.x + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
				
				// 빙산의 높이가 0 이 되면 break
				if(map[q.y][q.x] == 0 ) break;
				
				// 닿는 부분이 0 이고 visited 가 true 인 부분
				if(map[nr][nc] == 0 && !visited[nr][nc]) map[q.y][q.x]--;
			}
		}
	}
}
