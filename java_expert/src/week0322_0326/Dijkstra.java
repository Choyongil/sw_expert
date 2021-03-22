package week0322_0326;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		
		int[] D = new int[n];
		int[][] arr = new int[n][n];
		boolean[] visited = new boolean[n];
		
		for(int i = 0 ; i < e ; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			arr[r][c] = d;
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] = 0;
		visited[0] = true;
		
		for(int i = 0 ; i < n ; i++) {
			int minidx = 0;
			int min = 987654321;
			for(int j = 0 ; j < n ; j++) {
				if(!visited[j] && min > D[j]) {
					min = D[j];
					minidx = j;
				}
			}

			for(int j = 0 ; j < n ; j++) {
				if( !visited[j] && arr[i][j] != 0 && D[minidx] + arr[minidx][j] < D[j]) {
					D[j] = D[minidx] + arr[minidx][j];
				}
			}
			visited[minidx] = true;
		}
		System.out.println(Arrays.toString(D));
	}
}
