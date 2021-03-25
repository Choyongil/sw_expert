package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {

	static int n, m, ans;
	static char[][] arr;
	static boolean visited[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visited = new boolean[n][m][2];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		ans = -1;
		bfs();
		
		System.out.println(ans == -1 ? -1 : ans);
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	private static void bfs() {
		
		// r, c, sum, chance
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0,0,1,1});
		
		while(!queue.isEmpty()) {
			
			int[] q = queue.poll();
			
			if(q[0] == n-1 && q[1] == m-1) {
				ans = q[2];
				return;
			}
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				
				if(nr >= 0 && nc >= 0 && nr < n && nc < m ) {
					
					if(arr[nr][nc] == '0') {
						if(!visited[nr][nc][q[3]]) {
							queue.add(new int[] {nr, nc, q[2] + 1, q[3]});
							visited[nr][nc][q[3]] = true;
						}
					} else if(arr[nr][nc] == '1' && q[3] == 1) {
						visited[nr][nc][q[3]] = true;
						queue.add(new int[] {nr, nc, q[2] + 1, q[3] - 1});
					}
					
				}
			}			
		}
	}	
}