package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형_방 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] room;
	static int n;
	static int ans;
	static int max_cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			n = Integer.parseInt(br.readLine());
			
			room = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine(), " ");	
				for(int j = 0 ; j < n ; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			max_cnt = 0;

			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					func(1,room[i][j],i,j);
				}
			}			
			sb.append(ans + " " + max_cnt);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	
	public static void func(int cnt, int start, int c_r, int c_c) {
		
		if((c_r - 1) >= 0 && room[c_r - 1][c_c] == room[c_r][c_c] + 1) func(cnt+ 1, start, c_r - 1, c_c);
		else if((c_r + 1) < n && room[c_r + 1][c_c] == room[c_r][c_c] + 1) func(cnt+ 1, start, c_r + 1, c_c);
		else if((c_c - 1) >= 0 && room[c_r][c_c - 1] == room[c_r][c_c] + 1) func(cnt+ 1, start, c_r, c_c - 1);
		else if((c_c + 1) < n && room[c_r][c_c + 1] == room[c_r][c_c] + 1) func(cnt+ 1, start, c_r, c_c + 1);
		
		if( max_cnt < cnt || (max_cnt == cnt && start < ans)) {
			ans = start;
			max_cnt = cnt;
		}
		return;
	}
}