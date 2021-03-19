package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수지의_수지_맞는_여행 {

	static int r, c, ans;
	static char[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new char[r][c];
			visited = new boolean[24];
			ans = 0;
			
			for(int i = 0 ; i < r ; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			visited[arr[0][0] - 65] = true;
			go(0,0,1);
			
			sb.append(ans).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	private static void go(int i, int j, int sum) {
		
		for(int d = 0 ; d < 4 ; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 0 && nc >= 0 && nr < r && nc < c && !visited[arr[nr][nc] - 65]) {
				visited[arr[nr][nc] - 65] = true;
				go(nr, nc, sum + 1);
				visited[arr[nr][nc] - 65] = false;
			}
		}

		if(ans < sum) {
			ans = sum;
		}
		
		return;
	}	
}
