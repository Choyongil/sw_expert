package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(i == j) continue;
				arr[i][j] = 987654321;
			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[s][e] = Math.min(arr[s][e], c);
		}

		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(i == j) continue;
					if(arr[i][k] + arr[k][j] < arr[i][j]) arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				sb.append(arr[i][j] >= 987654321 ? 0 : arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
