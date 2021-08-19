package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리_조작 {

	static int n, m, h, map[][], ans;
	static boolean success = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h + 1][n + 1];
		ans = 0;
		if(m > 0) {
			
			for(int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				map[a][b] = 1;
				map[a][b + 1] = 2;
			}
			
			ans = -1;
			for(int i = 0 ; i <= 3 ; i++) {
				
				dfs(1, 0, i);
				if(success) {
					ans = i;
					break;
				}
			}
			
		}
		System.out.println(ans);
		
	}
	public static void dfs(int start, int cnt, int max) {
		
		if(success) return;
		if(cnt == max) {
			if(check()) success = true;
			return;
		}
		
		for(int j = start ; j < n ; j++) {
			for(int i = 1 ; i <= h ; i++) {
				if(map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(j, cnt + 1, max);
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i = 1 ; i <= n ; i++) {
			int start = i;
			for(int j = 1 ; j <= h ; j++) {
				if(map[j][start] == 1) start++;
				else if(map[j][start] == 2) start--;
			}
			if(start != i) return false;
		}
		
		return true;
	}
}
