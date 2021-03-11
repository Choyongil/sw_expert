package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동 {
	
	static int[][] arr;
	static int n, ans, sr, sc, er, ec;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			arr[sr][sc] = 0;
			
			visited = new boolean[n][n];
			ans = 0;
			
			bfs();
			System.out.println(ans);
		}
	}
	
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sr,sc});
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int r = q[0];
			int c = q[1];
			
			int k = arr[r][c] + 1;
			
			if(r == er && c == ec) {
				ans = k - 1;
				return;
			}

			for(int d = 0 ; d < 8 ; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if(!visited[nr][nc] || arr[nr][nc] > k) {
						arr[nr][nc] = k;
						queue.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
		return;
	}
}
