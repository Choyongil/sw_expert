package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열_돌리기1 {
	
	static int[][] arr;
	static int[][] brr;
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		brr = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < r ; i++) arr = turn(arr);
		
		for(int[] i : arr) {
			for(int j : i) sb.append(j + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static int[][] turn(int[][] a) {
		
		int r1 = 0;
		int r2 = n - 1;
		int c1 = 0;
		int c2 = m - 1;
		
		while( r1 < r2 && c1 < c2) {
			
			for(int i = r1 + 1 ; i <= r2 ; i++) brr[i][c1] = arr[i - 1][c1];
			for(int i = r2 - 1 ; i >= r1 ; i--) brr[i][c2] = arr[i + 1][c2];
			for(int j = c1 ; j <= c2 - 1 ; j++) brr[r1][j] = arr[r1][j + 1];
			for(int j = c2 ; j >= c1 + 1 ; j--) brr[r2][j] = arr[r2][j - 1];
			
			r1++;
			r2--;
			c1++;
			c2--;
			if(r1 == r2 || c1 == c2) {
				brr[r1][c1] = arr[r1][c1];
				brr[r1][c2] = arr[r1][c2];
				brr[r2][c2] = arr[r2][c2];
				brr[r2][c1] = arr[r2][c1];
			}
		}
		return brr;
	}
}
