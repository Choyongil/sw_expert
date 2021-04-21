package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {

	static int n, m, arr[][], ans;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] < 6 && arr[i][j] > 0) list.add(new int[] {i,j});
			}
		}
		ans = 987654321;
		go(0, arr);
		System.out.println(ans);
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void go(int idx, int[][] map) {
		
		if(idx == list.size()) {
			ans = Math.min(ans, count(map));
			return;
		}
		
		int[][] tmp = new int[n][m];
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		if(arr[r][c] == 5) {
			
			for(int d = 0 ; d < 4 ; d++) {
				change(map,r,c,d);
			}
			
			go(idx+1, map);
			
		} else if(arr[r][c] == 4) {
			for(int i = 0 ; i < 4 ; i++) {
				tmp = copy(map);
				for(int d = 0 ; d < 4 ; d++) {
					
					if(d == i) continue;
					
					change(tmp, r, c, d);
				}
				go(idx+1, tmp);
			}
		} else if(arr[r][c] == 3) {
			// 상좌(02), 상우(03), 하좌(12), 하우(13)
			tmp = copy(map);
			change(tmp,r,c,0);
			change(tmp,r,c,2);
			go(idx + 1, tmp);
			
			tmp = copy(map);
			change(tmp,r,c,0);
			change(tmp,r,c,3);
			go(idx + 1, tmp);
			
			tmp = copy(map);
			change(tmp,r,c,1);
			change(tmp,r,c,2);
			go(idx + 1, tmp);
			
			tmp = copy(map);
			change(tmp,r,c,1);
			change(tmp,r,c,3);
			go(idx + 1, tmp);
			
		} else if(arr[r][c] == 2) {
			tmp = copy(map);
			change(tmp,r,c,0);
			change(tmp,r,c,1);
			go(idx + 1, tmp);
			
			tmp = copy(map);
			change(tmp,r,c,2);
			change(tmp,r,c,3);
			go(idx + 1, tmp);
			
		} else if(arr[r][c] == 1) {

			for(int d = 0 ; d < 4 ; d++) {
				tmp = copy(map);
				change(tmp,r,c,d);
				go(idx+1, tmp);
			}
		} 
		
	}
	
	public static void change(int[][] tmp, int r, int c, int d) {
		int t = 1;
		while(true) {
			int nr = r + dr[d] * t;
			int nc = c + dc[d] * t;
			if(nr < 0 || nc < 0 || nr >= n || nc >= m || tmp[nr][nc] == 6) break;
			if(tmp[nr][nc] == 0) {
				tmp[nr][nc] = 7;
			}
			t++;
		}
	}
	
	public static int[][] copy(int[][] map){
		int[][] tmp = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	public static int count(int[][] tmp) {
		int cnt = 0;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				if(tmp[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
}
