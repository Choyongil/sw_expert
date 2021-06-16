package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_만들기 {

	static int n, map[][], ans, area[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		area = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = 1;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] == 1 && area[i][j] == 0) {
					go(i,j,x);
					x++;
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] != 0) {
					build(i,j,area[i][j]);
				}
			}
		}
		
		System.out.println(ans - 1);
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	// 같은 지역별로 id 부여해주기
	public static void go(int r, int c, int id) {
		area[r][c] = id;
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
			if(map[nr][nc] == 1 && area[nr][nc] == 0) {
				go(nr, nc, id);
			}
		}
	}
	
	// 다른 id가 있으면 다리 만들기
	// ans 값과 비교해서 ans 최신화
	public static void build(int r, int c, int id) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j] != 0 && area[i][j] != id && ans > Math.abs(i - r) + Math.abs(j - c)) {
					ans = Math.abs(i - r) + Math.abs(j - c);
				}
			}
		}
	}
}
