package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] WV = new int[n + 1][2];
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			WV[i][0] = Integer.parseInt(st.nextToken());
			WV[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] arr = new int[n + 1][k + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			for(int w = 1 ; w <= k ; w++) {
				int cur_w = WV[i][0];
				int cur_v = WV[i][1];
				
				if( cur_w > w ) {
					arr[i][w] = arr[i - 1][w];
				} else {
					arr[i][w] = Math.max(cur_v + arr[i-1][w - cur_w], arr[i-1][w]);
				}
			}
		}
		System.out.println(arr[n][k]);
	}
}
