package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로만들기 {

	static int n, map[][], dist[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dist = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			String s = br.readLine();
			
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = s.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		dist[0][0] = 0;
		go(0);
		
		System.out.println(dist[n-1][n-1]);
		
	}
	
	public static void go(int x) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			
			int[] q = queue.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = q[0] + dr[d];
				int nc = q[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				if(dist[q[0]][q[1]] >= dist[nr][nc]) continue;
				
				queue.add(new int[] {nr,nc});
				
				if(map[nr][nc] == 1) dist[nr][nc] = dist[q[0]][q[1]];
				else dist[nr][nc] = dist[q[0]][q[1]] + 1;
			}
		}
		
	}
	
}

/*
8
11100110
11010010
10011010
11101100
01000111
00110000
11011000
11000101
*/