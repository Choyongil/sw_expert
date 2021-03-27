package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int ans = 0;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < i + 1 ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(i > 0) {
					if(j == 0) arr[i][j] += arr[i-1][j];
					else if(j == i) arr[i][j] += arr[i-1][j-1];
					else arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
				}
				if(i == n-1) {
					ans = Math.max(ans, arr[i][j]);
				}
			}
		}

		System.out.println(ans);
	}
}
