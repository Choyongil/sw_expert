package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 식당예제 {
	
	static char[][] arr;
	static boolean[][] visited;
	static int n, m, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		func();
		System.out.println(ans);
	}
	
	static int[] dr = {-1, 0, 1};
	public static void func() {
		
		for(int i = 0 ; i < n ; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}
	
	public static boolean dfs(int r, int c) {
		
		if( c == m - 1 ) {
			ans++;
			return true;
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			int ndr = r + dr[i];
			if(ndr < 0 || ndr >= n || arr[ndr][c+1] == 'x' || visited[ndr][c+1]) continue;
			
			visited[ndr][c+1] = true;
			if(dfs(ndr, c + 1)) return true;
			
		}
		return false;
	}
}
