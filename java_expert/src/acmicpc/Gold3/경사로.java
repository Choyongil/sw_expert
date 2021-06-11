package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {

	static int n, l, map[][], ans;
	static boolean[][] build;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		for(int i = 0 ; i < n ; i++) {
			build = new boolean[n][n];
			if(check(i)) {
				ans++;
			}
			build = new boolean[n][n];
			if(check2(i)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean check(int idx) {
		
		int prev = map[idx][0];
		
		for(int i = 1 ; i < n ; i++) {
			if(Math.abs(prev - map[idx][i]) >= 2) return false;
			if(prev == map[idx][i]) continue;
			
			if(prev + 1 == map[idx][i]) {
				if(i <= l - 1) return false;
				else {
					for(int j = 1 ; j <= l ; j++) {
						if(map[idx][i-j] != prev || build[idx][i-j]) return false;
						build[idx][i-j] = true;
					}
					prev = map[idx][i];
				}
			} else if(prev - 1 == map[idx][i]) {
				if(i + l > n) return false;				
				else {
					build[idx][i] = true;
					for(int j = 1 ; j < l ; j++) {
						if(map[idx][i+j] != map[idx][i]) return false;
						build[idx][i+j] = true;
					}
					prev = map[idx][i];
				}
			}
		}
		
		return true;
	}
	
	public static boolean check2(int idx) {
		
		int prev = map[0][idx];
		for(int i = 1 ; i < n ; i++) {
			if(Math.abs(prev - map[i][idx]) >= 2) return false;
			if(prev == map[i][idx]) continue;
			
			if(prev + 1 == map[i][idx]) {
				if(i <= l - 1) return false;
				else {
					for(int j = 1 ; j <= l ; j++) {
						if(map[i-j][idx] != prev || build[i-j][idx]) return false;
						build[i-j][idx] = true;
					}
					prev = map[i][idx];
				}
			} else if(prev - 1 == map[i][idx]) {
				if(i + l > n) return false;
				else {
					build[i][idx] = true;
					for(int j = 1 ; j < l ; j++) {
						if(map[i+j][idx] != map[i][idx]) return false;
						build[i+j][idx] = true;
					}
					prev = map[i][idx];
				}
			}
		}
		
		return true;
	}
}
