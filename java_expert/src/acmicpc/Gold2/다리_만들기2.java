package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_만들기2 {

	static int n, m, cnt;
	static int[][] map;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 2;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] == 1) change(i,j,cnt++);
			}
		}
		cnt -= 2;
		int[][] adj = new int[cnt][cnt];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(map[i][j] != 0) {
					for(int d = 0 ; d < 4 ; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						int sum = 0;
						
						int start = map[i][j] - 2;
						int dest = 0;
						
						while(nr >= 0 && nc >= 0 && nr < n && nc < m) {
							if(map[nr][nc] != 0) {
								dest = map[nr][nc];
								break;
							}
							
							nr += dr[d];
							nc += dc[d];
							sum++;
						}
						dest -= 2;
						if(sum > 1 && dest != -2) {
							if(adj[start][dest] > 0) {
								adj[start][dest] = Math.min(adj[start][dest], sum);
							} else {
								adj[start][dest] = sum;
							}
							adj[dest][start] = adj[start][dest]; 
						}
						
					}
				}
			}
		}

		boolean[] visited = new boolean[cnt];
		
		int[] minEdge = new int[cnt];
		
		for(int i = 0 ; i < cnt ; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int minIdx, min, ans = 0;
		minEdge[0] = 0;
		
		for(int x = 0 ; x < cnt ; x++) {
			
			min = 987654321;
			minIdx = -1;
			
			for(int i = 0 ; i < cnt ; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minIdx = i;
				}
			}
			
			if(minIdx == -1) {
				ans = -1;
				break;
			}
			
			ans += min;
			visited[minIdx] = true;
			
			for(int i = 0 ; i < cnt ; i++) {
				if(!visited[i] && adj[minIdx][i] != 0 && minEdge[i] > adj[minIdx][i]) {
					minEdge[i] = adj[minIdx][i];
				}
			}
			
		}
		
		System.out.println(ans);
	}
	
	private static void change(int r, int c, int x) {
		
		map[r][c] = x;
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			if(map[nr][nc] == 1) {
				change(nr, nc, x);
			}
		}
	}
}
