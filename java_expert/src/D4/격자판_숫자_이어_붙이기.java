package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자판_숫자_이어_붙이기 {

	static int[][] arr;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			arr = new int[4][4];
			for(int i = 0 ; i < 4 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 4 ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[10000000];
			ans = 0;
			
			for(int i = 0 ; i < 4 ; i++) {
				for(int j = 0 ; j < 4 ; j++) {
					go(i, j, 1, Integer.toString(arr[i][j]));
				}
			}
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	private static void go(int r, int c, int cnt, String str) {
		
		if(cnt == 7) {
			int x = Integer.parseInt(str);
			
			if(!visited[x]) {
				visited[x] = true;
				ans++;
			}
			return;
		}
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc)) {
				go(nr, nc, cnt+1, str + Integer.toString(arr[nr][nc]));
			}
		}
	}
	
	private static boolean check(int r, int c) {
		if(r < 0 || c < 0 || r > 3 || c > 3) return false;
		return true;
	}
	
}
