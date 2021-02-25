package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[101][101];		
		int r1,r2,c1,c2;
		for(int tc = 0 ; tc < 4 ; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			for(int i = r1; i < r2 ; i++) {
				for(int j = c1 ; j < c2 ; j++) {
					arr[i][j] += 1;
				}
			}
		}
		int ans = 0;
		for(int i = 1; i <= 100 ; i++) {
			for(int j = 1 ; j <= 100 ; j++) {
				if(arr[i][j] > 0) ans += 1;
			}
		}
		System.out.println(ans);
		
	}
}
