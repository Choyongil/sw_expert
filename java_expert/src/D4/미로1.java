package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로1 {
	
	static char[][] arr;
	static int strR, strC, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc = 1; tc <= 10 ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			br.readLine();
			
			arr = new char[16][16];
			
			for(int i = 0 ; i < 16 ; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			strR = 0;
			strC = 0;
			ans = 0;
			for(int i = 0 ; i < 16 ; i++) {
				for(int j = 0 ; j < 16 ; j++) {
					if (arr[i][j] == '2') {
						strR = i;
						strC = j;
					}
				}
			}
			func(strR, strC);
			sb.append(ans == 1 ? ans : 0).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void func(int r, int c) {
		
		if(arr[r][c] == '3') {
			ans = 1;
			return;
		}
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(arr[nr][nc] == '0' || arr[nr][nc] == '3') {
				arr[r][c] = '1';
				func(nr, nc);
				arr[r][c] = '0';
			}
		}
		
		return;
	}
}
