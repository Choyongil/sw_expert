package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2563
public class 색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < 10 ; i++) {
				for(int j = 0 ; j < 10 ; j++) {
					arr[i + x][j + y] = 1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for (int j = 0 ; j < 100 ; j++) {
				if(arr[i][j] == 1) ans += 1;
			}
		}
		
		System.out.println(ans);
		
	}
}
