package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] room = new int[2][6];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			room[s][y-1] += 1;
		}

		int ans = 0;
		for(int i = 0 ; i < 2; i++) {
			for(int j = 0 ; j < 6 ; j++) {
				if(room[i][j] == 0) continue;
				else if( room[i][j] > k ) ans += room[i][j] % k == 0 ? room[i][j] / k : room[i][j] / k + 1;
				else ans += 1;
			}
		}
		System.out.println(ans);
	}
}
//10 1
//0 3
//0 3
//0 3
//0 3
//0 3
//0 3
//0 3
//0 3
//1 5
//0 3