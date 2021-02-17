package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {
	
	static char[][] map;
	static int n, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		for(int i = 0 ; i < n ; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] == '1') {
					cnt = 1;
					func(i, j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i : ans) System.out.println(i);
	
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void func(int r, int c) {

		map[r][c] = '0';
		int nr, nc, i;
		for(i = 0 ; i < 4 ; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(0 <= nr && nr < n && 0 <= nc && nc < n) {
				
				if(map[nr][nc] == '1') {
					cnt += 1;
					func(nr, nc);
				}
			}
		}
		return;
	}
}
