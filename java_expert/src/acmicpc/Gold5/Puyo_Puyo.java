package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Puyo_Puyo {

	static char[][] map = new char[12][6];
	static List<Point> list;
	static boolean[][] check = new boolean[12][6];
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 12 ; i++) map[i] = br.readLine().toCharArray();
		boolean flag = true;
		int ans = 0;
		
		while(flag) {
			flag = false;
			for(int i = 11 ; i >= 0 ; i--) {
				for(int j = 0 ; j < 6 ; j++) {
					if(map[i][j] != '.') {
						if(bombCheck(i,j,map[i][j])) flag = true;
					}
				}
			}
			
			if(flag) gravity();
			
			ans++;
		}
		System.out.println(ans - 1);
	}
	
	public static boolean bombCheck(int r, int c, char x) {
		Queue<Point> queue = new LinkedList<>();
		check = new boolean[12][6];
		queue.add(new Point(r,c));
		int cnt = 1;
		check[r][c] = true;
		while(!queue.isEmpty()) {
			
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= 12 || nc >= 6 || check[nr][nc]) continue;
				if(map[nr][nc] != x) continue;
				cnt++;
				check[nr][nc] = true;
				queue.add(new Point(nr, nc));
			}
		}
		
		if(cnt > 3) {
			for(int i = 0 ; i < 12 ; i++) {
				for(int j = 0 ; j < 6 ; j++) {
					if(check[i][j]) map[i][j] = '.';
				}
			}
			return true;
		}
		
		return false;
		
	}
	
	public static void gravity() {
		Queue<Character> queue = new LinkedList<>();
		for(int j = 0 ; j < 6 ; j++) {
			for(int i = 11 ; i >= 0 ; i--) {
				if(map[i][j] != '.') {
					queue.add(map[i][j]);
					map[i][j] = '.';
				}
			}
			
			int idx = 11;
			while(!queue.isEmpty()) {
				char q = queue.poll();
				
				map[idx--][j] = q;
			}
		}
	}
}


