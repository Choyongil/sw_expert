package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기1 {
	
	static int n, ans;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		go(1, 0, 1);
		System.out.println(ans);
	}
	
	// 1 : 가로, 2 : 세로, 3 : 대각선
	public static boolean go(int dir, int r, int c) {
		if( r + c == 2*n - 2) {
			ans += 1;
			return true;
		}
		
		if(dir != 2) {
			if( c + 1 < n && arr[r][c+1] != 1) go(1, r, c + 1);
		}
		
		if(dir != 1) {
			if( r + 1 < n && arr[r+1][c] != 1) go(2, r + 1, c);
		}
		
		if( r + 1 < n && c + 1 < n && arr[r+1][c+1] != 1 && arr[r][c+1] != 1 && arr[r+1][c] != 1) go(3, r + 1, c + 1);
		
		return false;
	}
}
