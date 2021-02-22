package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중위순회 {

	static char[] arr;
	static int n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			sb.append("#" + tc + " ");
			
			n = Integer.parseInt(br.readLine());
			
			arr = new char[n + 1];
			
			for(int i = 1 ; i <= n ; i++) {
				arr[i] = br.readLine().split(" ")[1].charAt(0);
			}
			dfs(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int cur) {

		if(cur > n) return;
		
		dfs(cur*2);
		sb.append(arr[cur]);
		dfs(cur*2 + 1);
	}
}
