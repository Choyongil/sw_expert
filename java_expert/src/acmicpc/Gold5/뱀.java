package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {
	static class Point{
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static class time{
		int t;
		char d;
		public time(int t, char d) {
			super();
			this.t = t;
			this.d = d;
		}
	}
	static List<Point> list;
	// 우 하 좌 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		list = new ArrayList<>();
		list.add(new Point(0,0));

		Queue<time> queue = new LinkedList<>();
		int l = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < l ; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			queue.offer(new time(t, d));
		}
		int ans = 0;
		int d = 0;

		time T = queue.poll();
		int t = T.t;
		char d2 = T.d;

		out : while(true) {
			int r = list.get(list.size()-1).r;
			int c = list.get(list.size()-1).c;
			
			ans++;
			r += dr[d];
			c += dc[d];
			if(r < 0 || c < 0 || r >= n || c >= n) {
				break out;
			}
			if(!check(r, c)) {
				break out;
			}

			list.add(new Point(r, c));
			if(map[r][c] == 1) {
				map[r][c] = 0;
			} else {
				list.remove(0);
			}
			
			if(ans == t) {
				if(d2 == 'D') d = (d + 1) % 4;
				else d = (d + 3) % 4;
				
				if(!queue.isEmpty()) {
					T = queue.poll();
					t = T.t;
					d2 = T.d;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static boolean check(int r, int c) {
		for(int i = 0 ; i < list.size()-1 ; i++) {
			if(r == list.get(i).r && c == list.get(i).c) return false;
		}
		return true;
	}
}
