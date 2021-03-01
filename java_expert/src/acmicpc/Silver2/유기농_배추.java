package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농_배추 {
	
	static int[][] arr;
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int ans = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < m ; j++) {
					if(arr[i][j] == 1) {
						ans += 1;
						func(i,j);
					}
				}
			}
			System.out.println(ans);
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void func(int r, int c) {
		arr[r][c] = 0;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr > n - 1|| nc > m - 1 || nr < 0 || nc < 0) continue;
			if(arr[nr][nc] == 1) func(nr, nc);
		}
//		if(r < n - 1 && arr[r+1][c] == 1) func(r+1, c);
//		if(c < m - 1 && arr[r][c+1] == 1) func(r, c+1);
		return;
	}
}
