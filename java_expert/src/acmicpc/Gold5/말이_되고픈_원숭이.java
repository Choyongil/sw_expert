package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이 {

	static class Monkey{
		int r;
		int c;
		int jump;
		int sum;

		public Monkey(int r, int c, int jump, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.jump = jump;
			this.sum = sum;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] dr2 = {-2,-1,1,2,2,1,-1,-2};
	static int[] dc2 = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		boolean[][][] visited = new boolean[n][m][k+1];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = -1;
		
		Queue<Monkey> queue = new LinkedList<Monkey>();
		
		queue.add(new Monkey(0,0,k,0));
		
		while(!queue.isEmpty()) {
			
			Monkey q = queue.poll();
			if(q.r == n-1 && q.c == m-1) {
				ans = q.sum;
				break;
			}
			
			if(visited[q.r][q.c][q.jump]) continue;
			visited[q.r][q.c][q.jump] = true;
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q.r + dr[d];
				int nc = q.c + dc[d];
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 1) continue;
				queue.add(new Monkey(nr, nc, q.jump, q.sum + 1));
			}	
			
			if(q.jump == 0) continue;
			for(int d = 0 ; d < 8 ; d++) {
				int nr = q.r + dr2[d];
				int nc = q.c + dc2[d];
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 1) continue;
				queue.add(new Monkey(nr,nc,q.jump-1,q.sum+1));
			}
		}
		
		System.out.println(ans == -1 ? -1 : ans);
	}
}
