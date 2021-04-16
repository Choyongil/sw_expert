package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

	static int n, arr[][], sR, sC, ans;
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int dis;
		
		public Point(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			if(dis == o.dis) {
				if(r == o.r) return c - o.c;
				return r - o.r;
			}
			return dis - o.dis;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", dis=" + dis + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					sR = i;
					sC = j;
					arr[i][j] = 0;
				}
			}
		}
		ans = 0;
		bfs();
		
		System.out.println(ans);
	}
	
	static int[] dr = {1,0,0,-1};
	static int[] dc = {0,-1,1,0};
	private static void bfs() {
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(sR, sC, 0));
		int shSize = 2;
		int eatN = 0;
		
		while(true) {
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			int[][] dis = new int[n][n];

			out :while(!queue.isEmpty()) {
				Point q = queue.poll();
				for(int d = 0 ; d < 4 ; d++) {
					int nr = q.r + dr[d];
					int nc = q.c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= n || arr[nr][nc] > shSize || dis[nr][nc] != 0) continue;
					
					dis[nr][nc] = dis[q.r][q.c] + 1;
					
					if(arr[nr][nc] != 0 && arr[nr][nc] < shSize) {
						pq.add(new Point(nr, nc, dis[nr][nc]));
						queue.add(new Point(nr, nc, dis[nr][nc]));
					} else {
						queue.add(new Point(nr, nc, dis[nr][nc]));
					}
				}
			}
			
			if(pq.size() == 0) return;
			
			Point eatF = pq.poll();
			ans += eatF.dis;
			eatN++;
			
			if(eatN == shSize) {
				shSize++;
				eatN = 0;
			}
			arr[eatF.r][eatF.c] = 0;
			queue.add(new Point(eatF.r, eatF.c, shSize));
		}
	}
}
