package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_큰_정사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] map = new int[r+1][c+1];
		int[][] dp = new int[r+1][c+1];
		for(int i = 0 ; i < r ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < c ; j++) {
				map[i][j] = s.charAt(j) - '0';
				dp[i][j] = map[i][j];
			}
		}
		
		int Down = 0;
		int Right = 0;
		int DownRight = 0;
		int min = 987654321;
		
		int ans = 0;
		
		for(int i = r - 1 ; i >= 0 ; i--) {
			for(int j = c - 1 ; j >= 0 ; j--) {
				if(map[i][j] == 0) continue;

				Down = dp[i + 1][j];
				Right = dp[i][j + 1];
				DownRight = dp[i + 1][j + 1];
				
				min = Math.min(Down, Math.min(Right, DownRight));
				dp[i][j] = min + 1;
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans * ans);
	}
}
//6 6
//111000
//111111
//111110
//111110
//011110
//010000

//5 5
//11111
//11111
//11011
//11111
//11111

//3 3
//011
//111
//111

//2 2
//01
//00


//3 3
//111
//101
//111