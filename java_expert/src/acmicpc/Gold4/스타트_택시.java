package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트_택시 {

	static int n, m, k, map[][], firstDist[], dist[], eachDist[][], ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Point>[] list;
	static class Point{
		
		int r;
		int c;
		int cnt;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1 ; j <= n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[m];
		firstDist = new int[m];		// 택시의 처음 위치에서 각 출발지까지의 거리
		for(int i = 0 ; i < m ; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			
			// 출발지
			list[i].add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			// 도착지
			list[i].add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
			// 처음 택시 위치에서 각 승객들까지의 거리
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(startR, startC, 0));
			boolean[][] visited = new boolean[n+1][n+1];
			visited[startR][startC] = true;
			int endR = list[i].get(0).r;
			int endC = list[i].get(0).c;
			while(!queue.isEmpty()) {
				
				Point q = queue.poll();
				
				if(q.r == endR && q.c == endC) {
					firstDist[i] = q.cnt;
					break;
				}
				
				for(int d = 0 ; d < 4 ; d++) {
					int nr = q.r + dr[d];
					int nc = q.c + dc[d];
					
					if(nr <= 0 || nc <= 0 || nr > n || nc > n) continue;
					if(visited[nr][nc] || map[nr][nc] == 1) continue;
					
					queue.add(new Point(nr, nc, q.cnt + 1));
					visited[nr][nc] = true;

				}
				
			}
			
		}
		
		// 각 승객끼리 도착지에서부터 다른 승객의 출발지까지의 거리 구하기
		eachDist = new int[m][m];
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < m ; j++) {
				eachDist[i][j] = 987654321;
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < m ; j++) {
				
				int sR = list[i].get(0).r;
				int sC = list[i].get(0).c;
				int eR = list[j].get(1).r;
				int eC = list[j].get(1).c;
				
				Queue<Point> queue = new LinkedList<>();
				queue.add(new Point(sR, sC, 0));
				boolean[][] visited = new boolean[n + 1][n + 1];
				while(!queue.isEmpty()) {
					
					Point q = queue.poll();
					
					if(q.r == eR && q.c == eC) {
						eachDist[i][j] = q.cnt;
						break;
					}
					
					for(int d = 0 ; d < 4 ; d++) {
						int nr = q.r + dr[d];
						int nc = q.c + dc[d];
						
						if(nr <= 0 || nc <= 0 || nr > n || nc > n) continue;
						if(visited[nr][nc] || map[nr][nc] == 1) continue;
						
						queue.add(new Point(nr, nc, q.cnt + 1));
						visited[nr][nc] = true;

					}
				}
				
				if(eachDist[i][j] == 987654321) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}

		ans = check();
		System.out.println(ans);
		
	}
	
	public static int check() {
		
		boolean[] isSelected = new boolean[m];
		int before = -1;
		
		for(int i = 0 ; i < m ; i++) {
			
			int min = 987654321;
			int minIdx = -1;
			int minCol = -1;

			if(i == 0) {
				
				for(int j = 0 ; j < m ; j++) {
					if(min > firstDist[j]) {
						min = firstDist[j];
						minIdx = j;
						minCol = list[j].get(0).c;
					} else if(min == firstDist[j]) {
						if(minCol > list[j].get(0).c) {
							minCol = list[j].get(0).c;
						}
					}
				}
			} else {
				
				for(int j = 0 ; j < m ; j++) {
					if(isSelected[j]) continue;
					
					if(min > eachDist[j][before]) {
						min = eachDist[j][before];
						minIdx = j;
						minCol = list[j].get(0).c;
					} else if(min == eachDist[j][before]) {
						if(minCol > list[j].get(0).c) {
							minCol = list[j].get(0).c;
						}
					}
				}
			}
			
			before = minIdx;
			k -= min + eachDist[minIdx][minIdx];
			isSelected[minIdx] = true;
			if(k < 0) return -1;
			k += eachDist[minIdx][minIdx] * 2;
			
		}
		
		return k;
	}
	
}
