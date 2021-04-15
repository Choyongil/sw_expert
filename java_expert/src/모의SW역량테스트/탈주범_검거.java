package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범_검거 {

	static int n, m, r, c, l, arr[][], ans;
	
	static class Point{
		
		int r;
		int c;
		int t;		// time
		
		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < m ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			bfs();
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(r,c,1));
		boolean[][][] visited = new boolean[n][m][l+1];
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();

			if(p.t == l) {
				ans++;				
				continue;
			}
			
			if(!visited[p.r][p.c][p.t + 1]) {
				queue.add(new Point(p.r, p.c, p.t + 1));
				visited[p.r][p.c][p.t+1] = true;
			}
			
			int x = arr[p.r][p.c];
			
			if(p.r > 0 && (x == 1 || x == 2 || x == 4 || x == 7)) {
				// 위로 이동 가능
				
				int y = arr[p.r-1][p.c];
				if((y == 1 || y == 2 || y == 5 || y == 6) && !visited[p.r-1][p.c][p.t+1]) {
					queue.add(new Point(p.r-1, p.c, p.t + 1));
					visited[p.r-1][p.c][p.t+1] = true;
				}
			}
			if(p.r < n-1 && (x == 1 || x == 2 || x == 5 || x == 6)) {
				// 아래로 이동 가능
				
				int y = arr[p.r+1][p.c];
				if((y == 1 || y == 2 || y == 4 || y == 7) && !visited[p.r+1][p.c][p.t+1]) {
					queue.add(new Point(p.r+1, p.c, p.t + 1));
					visited[p.r+1][p.c][p.t+1] = true;
				}
			}
			if(p.c < m-1 && (x == 1 || x == 3 || x == 4 || x == 5)) {
				// 오른쪽으로 이동 가능

				int y = arr[p.r][p.c+1];
				if((y == 1 || y == 3 || y == 6 || y == 7) && !visited[p.r][p.c+1][p.t+1]) {
					queue.add(new Point(p.r, p.c+1, p.t + 1));
					visited[p.r][p.c+1][p.t+1] = true;
				}
			}
			if(p.c > 0 && (x == 1 || x == 3 || x == 6 || x == 7)) {
				// 왼쪽으로 이동 가능
				
				int y = arr[p.r][p.c-1];
				if((y == 1 || y == 3 || y == 4 || y == 5) && !visited[p.r][p.c-1][p.t+1]) {
					queue.add(new Point(p.r, p.c-1, p.t + 1));
					visited[p.r][p.c-1][p.t+1] = true;
				}
				
			}
		}
	}
}
