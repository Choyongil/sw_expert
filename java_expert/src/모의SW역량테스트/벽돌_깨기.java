package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌_깨기 {
	
	static int n, w, h, arr[][], ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			
			for(int i = 0 ; i < h ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < w ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 987654321;
			
			dfs(arr, 0, "");
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	private static void dfs(int[][] tmp, int cnt, String str) {
		
		if(cnt == n) {
			int sum = 0;
			for(int i = 0 ; i < h ; i++) {
				for(int j = 0 ; j < w ; j++) {
					if(tmp[i][j] != 0) {
						sum++;
					}
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i = 0 ; i < w ; i++) {
			int[][] tmp2 = copy(tmp);
			String s = Integer.toString(i);
			for(int j = 0 ; j < h ; j++) {
				if(tmp2[j][i] != 0) {
					bomb(j,i,tmp2);
					break;
				}
			}
			down(tmp2);
			dfs(tmp2, cnt + 1, str+s);
		}
		
	}

	private static void down(int[][] map) {
		for(int j = w-1 ; j >= 0 ; j--) {
			for(int i = h-1 ; i >= 0 ; i--) {
				if(map[i][j] == 0) {
					for(int x = i ; x >= 0 ; x--) {
						if(map[x][j] != 0) {
							map[i][j] = map[x][j];
							map[x][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	private static int[][] copy(int[][] a) {
		int[][] b = new int[h][w];
		for(int i = 0 ; i < h ; i++) {
			for(int j = 0 ; j < w ; j++) {
				b[i][j] = a[i][j];
			}
		}
		return b;
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void bomb(int r, int c, int[][] map) {
		
		int num = map[r][c];
		map[r][c] = 0;

		for(int x = 1 ; x < num ; x++) {
			
			for(int d = 0 ; d < 4 ; d++) {
				int nr = r + dr[d]*x;
				int nc = c + dc[d]*x;
				
				if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
				
				bomb(nr, nc, map);
			}
		}
	}
}