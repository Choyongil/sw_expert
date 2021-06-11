package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단식원 {

	static int n, m, map[][], ans;
	static List<Point> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			list = new ArrayList<>();
			
			for(int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < m ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						list.add(new Point(i,j));
					}
				}
			}
			
			ans = 0;
			go(0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	public static void go(int cnt) {
		
		if(cnt == 3) {
			ans = Math.max(ans, spread());
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					go(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static int spread() {
		
		int cnt = 0;
		Queue<Point> queue = new LinkedList<>();
		for(int i = 0 ; i < list.size(); i++) {
			queue.add(new Point(list.get(i).r, list.get(i).c));
		}
		
		while(!queue.isEmpty()) {
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] != 0) continue;
				map[nr][nc] = 2;
				queue.add(new Point(nr, nc));
				
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 0) {
					cnt++;
				} else if(map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			map[list.get(i).r][list.get(i).c] = 2;
		}
		return cnt;
	}
}
