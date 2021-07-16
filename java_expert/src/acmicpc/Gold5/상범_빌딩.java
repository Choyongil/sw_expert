package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범_빌딩 {

	static int L, R, C;
	static char map[][][];
	static class Point{
		int l, r, c, time;

		public Point(int l, int r, int c, int time) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Point [l=" + l + ", r=" + r + ", c=" + c + ", time=" + time + "]";
		}
		
	}
	static int[] dl = {-1,1,0,0,0,0};
	static int[] dr = {0,0,-1,1,0,0};
	static int[] dc = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L + R + C == 0) break;
			
			map = new char[L][R][C];
			
			int startL = -1;
			int startR = -1;
			int startC = -1;
			int endL = -1;
			int endR = -1;
			int endC = -1;
			
			for(int k = 0 ; k < L ; k++) {
				
				for(int i = 0 ; i < R ; i++) {
					char[] tmp = br.readLine().toCharArray();
					for(int j = 0 ; j < C ; j++) {
						map[k][i][j] = tmp[j];
						if(map[k][i][j] == 'S') {
							startL = k;
							startR = i;
							startC = j;
						} else if(map[k][i][j] == 'E') {
							endL = k;
							endR = i;
							endC = j;
						}
					}
				}
				br.readLine();
				
			}
			
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(startL,startR,startC,0));
			boolean[][][] visited = new boolean[L][R][C];
			visited[startL][startR][startC] = true;
			
			int ans = -1;
			
			while(!queue.isEmpty()) {
				
				Point q = queue.poll();
				
				if(q.l == endL && q.r == endR && q.c == endC) {
					ans = q.time;
					break;
				}
				
				for(int d = 0 ; d < 6 ; d++) {
					int nl = q.l + dl[d];
					int nr = q.r + dr[d];
					int nc = q.c + dc[d];
					
					if(nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || 
							map[nl][nr][nc] == '#' || visited[nl][nr][nc]) continue;
					
					queue.add(new Point(nl, nr, nc, q.time + 1));
					visited[nl][nr][nc] = true;
				}
				
			}
			if(ans != -1) System.out.println("Escaped in " + ans + " minute(s).");
			else System.out.println("Trapped!");
		}
	}
}
