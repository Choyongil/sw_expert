package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		
		int r1,c1,w,h;
		for(int i = 1 ; i <= n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			for(int j = r1 ; j < r1 + w ; j++) {
				for(int k = c1 ; k < c1 + h ; k++) {
					arr[j][k] = i;
				}
			}
		}
		
		int[] result = new int[n+1];
		for(int j = 0 ; j < 101 ; j++) {
			for(int k = 0 ; k < 101 ; k++) {
				result[arr[j][k]] += 1;
			}
		}
		for(int i = 1 ; i <= n ; i++) {
			System.out.println(result[i]);
		}
		
	}
}
