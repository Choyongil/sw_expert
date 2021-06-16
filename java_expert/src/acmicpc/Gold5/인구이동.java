package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {

	static int n, L, R, map[][], idNum[][], sum[], size[], ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		idNum = new int[n][n];		// 인구 이동이 가능한 지역들을 같은 id로 묶어주기
		map = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		int id = 1;
		boolean flag = false;
		while(true) {
			id = 1;
			flag = false;				// 인구 이동이 가능한 2개 이상의 지역이 없을 경우
			sum = new int[n*n+1];		// 각 id에 해당하는 인구 수의 합
			size = new int[n*n+1];		// 각 id에 해당하는 지역의 수
			idNum = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(idNum[i][j] == 0) {
						Queue<Point> queue = new LinkedList<>();
						queue.add(new Point(i,j));
						idNum[i][j] = id;
						sum[id] = map[i][j];
						size[id]++;
						while(!queue.isEmpty()) {
							Point q = queue.poll();
							
							for(int d = 0 ; d < 4 ; d++) {
								int nr = q.r + dr[d];
								int nc = q.c + dc[d];
								
								if(nr < 0 || nc < 0 || nr >= n || nc >= n || idNum[nr][nc] != 0) continue;
								if(Math.abs(map[q.r][q.c] - map[nr][nc]) >= L && Math.abs(map[q.r][q.c] - map[nr][nc]) <= R) {
									queue.add(new Point(nr, nc));
									size[id]++;
									sum[id] += map[nr][nc];
									flag = true;
									idNum[nr][nc] = id;
								}
							}
						}
						
						id++;
					}
				}
			}
			
			if(!flag) {
				break;
			}
			
			change();
			ans++;
		}
		System.out.println(ans);
	}

	public static void change() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = sum[idNum[i][j]] / size[idNum[i][j]];
			}
		}
	}
}