package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의_갯수 {
	
	static int[][] map;
	static int w, h, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			for(int i = 0 ; i < h ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < w ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if(map[i][j] == 0) continue;
					map[i][j] = 0;
					func(i, j);		
					ans += 1;
				}
			}
			System.out.println(ans);
		}
	}
	
	public static void func(int r, int c) {

		int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
		int nr, nc, i;
		for(i = 0 ; i < 8 ; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(0 <= nr && nr < h && 0 <= nc && nc < w) {
				
				if(map[nr][nc] == 1) {
					map[nr][nc] = 0;
					func(nr, nc);
				}
			}
		}
		return;
	}
}
