package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 보급로 {
	
	static int[][] arr, save;
	static boolean[][] visited;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <=T ; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			save = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				char[] s = br.readLine().toCharArray();
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = s[j] - '0';
					save[i][j] = 987654321;
				}
			}
			save[0][0] = 0;
			save[n-1][n-1] = 0;
			bfs();
			sb.append(save[n-1][n-1]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, 1, -1};
	
	public static void bfs() {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
				
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			queue.poll();
			for(int i = 0 ; i < 4 ; i++) {
				
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				
				if(!visited[nr][nc] || arr[nr][nc] + save[r][c] < save[nr][nc]) {
					visited[nr][nc] = true;
					save[nr][nc] = save[r][c] + arr[nr][nc];
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
		return;
	}
}
