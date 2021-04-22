package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경로_찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
			
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 0) arr[i][j] = 10;
				else arr[i][j] = x;
			}
		}

		for(int k = 0 ; k < n ; k++) {
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(arr[i][k] + arr[k][j] < arr[i][j]) arr[i][j] = 1; 
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.print(arr[i][j] >= 10 ? 0 + " " : 1 + " ");
			}
			System.out.println();
		}
	}
}
