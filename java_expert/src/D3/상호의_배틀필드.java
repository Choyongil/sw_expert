package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의_배틀필드 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(input.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			
			sb.append("#" + tc + " ");
			
			st = new StringTokenizer(input.readLine(), " ");
			
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			char[][] arr = new char[h][w];
			int r = 0, c = 0;
			
			for(int i = 0 ; i < h ; i++) {
				arr[i] = input.readLine().toCharArray();
			}
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if (arr[i][j] == '<' || arr[i][j] == 'v' || arr[i][j] == '^' || arr[i][j] == '>') {
						r = i;
						c = j;
						break;
					}
				}
			}
			
			int n = Integer.parseInt(input.readLine());
			char[] con = new char[n];

			con = input.readLine().toCharArray();
			int tmp_r, tmp_c, dr, dc;
			
			for(char s : con) {
				dr = 0;
				dc = 0;
				if (s == 'U') {
					arr[r][c] = '^';
					dr = -1;
				}
				else if (s == 'D') {
					arr[r][c] = 'v';
					dr = 1;
				}
				else if (s == 'L') {
					arr[r][c] = '<';
					dc = -1;
				}
				else if (s == 'R') {
					arr[r][c] = '>';
					dc = 1;
				}
				if (r+dr <= h-1 &&
						r+dr >= 0 &&
						c+dc <= w-1 &&
						c+dc >= 0 &&
						arr[r+dr][c+dc] == '.') {
					arr[r+dr][c+dc] = arr[r][c];
					arr[r][c] = '.';
					r += dr;
					c += dc;
				}
				
				if (s == 'S') {
					tmp_r = r;
					tmp_c = c;
					dr = 0;
					dc = 0;
					
					if (arr[r][c] == '>') dc = 1;
					else if (arr[r][c] == '<') dc = -1;
					else if (arr[r][c] == '^') dr = -1;
					else if (arr[r][c] == 'v') dr = 1;
					while(true) {
						tmp_r += dr;
						tmp_c += dc;
						if(tmp_r > h-1 || 
								tmp_r < 0 ||
								tmp_c > w-1 ||
								tmp_c < 0 ||
								arr[tmp_r][tmp_c] == '#') break;
						if (arr[tmp_r][tmp_c] == '*') {
							arr[tmp_r][tmp_c] = '.';
							break;
						}
					}
				}
			}
			System.out.print(sb);
			for(char[] c1 : arr) {
				for(char c2 : c1) {
					System.out.print(c2);
				}
				System.out.println();
			}
			sb.setLength(0);
			
		}
	}
}
