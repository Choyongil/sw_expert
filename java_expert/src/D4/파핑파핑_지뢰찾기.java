package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파핑파핑_지뢰찾기 {
	
	static char[][] map;
	static int n, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				map[i] = br.readLine().toCharArray();
			}
			ans = 0;
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(map[i][j] == '.' && check(i,j) == 0) {
						ans += 1;
						zero_bomb(i,j);
//						for(char[] a: map) System.out.println(Arrays.toString(a));
					}
				}
			}
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(map[i][j]=='.') ans += 1;
				}
			}
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void bomb(int r, int c) {
		
		int sum = 0;
		for(int d = 0 ; d < 8 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '*') sum += 1;
		}

		map[r][c] = (char) (sum+'0');
		if(map[r][c] == '0') zero_bomb(r, c);
	}
	
	public static int check(int r, int c) {
		int sum = 0;
		for(int d = 0 ; d < 8 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '*') sum += 1;
		}
		return sum;
	}
	
	public static void zero_bomb(int r, int c) {
		map[r][c] = '0';
		for(int d = 0 ; d < 8 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '.') bomb(nr,nc);
		}
	}
}
