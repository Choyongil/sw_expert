package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 길찾기 {
	
	static int[][] arr;
	static int n, ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 1 ; tc++) {
			sb.append("#").append(tc).append(" ");
			ans = 0;
			visited = new boolean[100];
			arr = new int[100][100];
			st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			func(0);
			sb.append(ans == 1?ans : 0).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	
	public static void func(int x) {

		if( x == 99) {
			ans = 1;
			return;
		}
		
		for(int i = 0 ; i < 100 ; i++) {
			if(arr[x][i] == 1 && !visited[i]) {
				visited[i] = true;
				func(i);
				visited[i] = false;
			}
		}
		return;
	}
}
