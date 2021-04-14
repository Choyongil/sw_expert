package acmicpc.Gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이_차오른다_가자 {

	static int n, m, ans, sR, sC;
	static char arr[][];

	static class Point{
		int r;
		int c;
		int key;
		int sum;
		
		public Point(int r, int c, int key, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", key=" + key + ", sum=" + sum + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		sR = -1;
		sC = -1;
		int[][][] dp = new int[n][m][64];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j = 0 ; j < m ; j++) {
				if(arr[i][j] == '0') {
					sR = i;
					sC = j;
				}
				Arrays.fill(dp[i][j],Integer.MAX_VALUE);
			}
		}
		
		ans = Integer.MAX_VALUE;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sR, sC, 0, 0));
		arr[sR][sC] = '.';
		dp[sR][sC][0] = 0;
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		while(!queue.isEmpty()) {
			
			Point q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				
				if(checking(nr, nc)) {
					
					if(arr[nr][nc] == '.' && dp[nr][nc][q.key] > q.sum + 1) {

						dp[nr][nc][q.key] = q.sum + 1; 
						queue.add(new Point(nr, nc, q.key, q.sum + 1));
						
					} else if(97 <= arr[nr][nc] && arr[nr][nc] <= 102 && dp[nr][nc][q.key] > q.sum + 1) {

						int key = q.key | (1 << (arr[nr][nc] - 'a'));
						dp[nr][nc][key] = q.sum + 1;
						queue.add(new Point(nr, nc, key, q.sum + 1));
						
					} else if(65 <= arr[nr][nc] && arr[nr][nc] <= 70) {
						
						if((q.key & (1 << (arr[nr][nc] - 'A'))) > 0 && dp[nr][nc][q.key] > q.sum + 1) {
							dp[nr][nc][q.key] = q.sum + 1;
							queue.add(new Point(nr, nc, q.key, q.sum + 1));
						}
						
					} else if(arr[nr][nc] == '1' ) {
						ans = Math.min(ans, q.sum + 1);
						continue;
					}
				}
			}
			
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	private static boolean checking(int r, int c) {
		if(r < 0 || c < 0 || r >= n || c >= m || arr[r][c] == '#') return false;
		return true;
	}
}
