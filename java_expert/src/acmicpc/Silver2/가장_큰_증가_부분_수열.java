package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_큰_증가_부분_수열 {

	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[][] arr = new int[2][n+1];
		
		int ans = 0;
		for(int i = 1 ; i <= n ; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			for(int j = 0 ; j < i ; j++) {
				if(max < arr[1][j] && arr[0][j] < arr[0][i]) {
					max = arr[1][j];
				}
			}
			arr[1][i] = max + arr[0][i];
			ans = Math.max(ans, arr[1][i]);
		}
		System.out.println(ans);
	}
}
