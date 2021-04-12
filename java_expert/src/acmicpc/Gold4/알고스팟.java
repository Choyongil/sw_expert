package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟 {
	
	static int r, c;
	static int[][] arr;
	
	static class Point{
		int x;
		int y;
		int cnt;
		
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			char[] crr = br.readLine().toCharArray();
			for(int j = 0 ; j < c ; j++) {
				arr[i][j] = crr[j] - '0';
			}
		}
		if(r + c == 2) System.out.println(arr[r-1][c-1]);
		else go();
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void go() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(0,0,0));
		
		int[][] cntArr = new int[r][c];
		for(int i = 0 ; i < r ; i++) {
			Arrays.fill(cntArr[i], 987654321);
		}
		
		while(!queue.isEmpty()) {
			Point q = queue.poll();
			
			int x = q.x;
			int y = q.y;
			int cnt = q.cnt;
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				
				if(check(nr,nc)) {
					if(arr[nr][nc] == 1 && cntArr[nr][nc] > cnt + 1) {
						cntArr[nr][nc] = cnt + 1;
						queue.add(new Point(nr, nc, cnt + 1));
					} else if(arr[nr][nc] == 0 && cntArr[nr][nc] > cnt) {
						cntArr[nr][nc] = cnt;
						queue.add(new Point(nr, nc, cnt));
					}
				}
			}
		}
		System.out.println(cntArr[r-1][c-1]);
	}
	
	private static boolean check(int x, int y) {
		
		if(x < 0 || y < 0 || x == r || y == c) return false;
		return true;
	}
}
