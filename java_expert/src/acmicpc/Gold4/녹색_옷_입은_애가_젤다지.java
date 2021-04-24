package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색_옷_입은_애가_젤다지 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = 0;
		while(true) {
			tc++;
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int[][] arr = new int[n][n];
			int[][] dp = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = 987654321;
				}
			}
			dp[0][0] = arr[0][0];
			
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {0,0});
			
			while(!queue.isEmpty()) {
				int[] q = queue.poll();
				for(int d = 0 ; d < 4 ; d++) {
					int nr = q[0] + dr[d];
					int nc = q[1] + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
					if(dp[q[0]][q[1]] + arr[nr][nc] >= dp[nr][nc]) continue;
					dp[nr][nc] = dp[q[0]][q[1]] + arr[nr][nc];
					queue.add(new int[] {nr, nc});
					
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(dp[n-1][n-1]).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
