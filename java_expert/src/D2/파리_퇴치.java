package D2;

import java.util.Scanner;


public class 파리_퇴치 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for (int i= 0; i < N; i++) {
				for (int j = 0; j< N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			int sum = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					sum = 0;
					for (int k = 0; k < M; k++) {
						for (int l = 0 ; l < M; l++) {
							sum += arr[i+k][j+l];
						}
					}
					
					if (sum > max) {
						max = sum;
					}
					
				}
			}
			System.out.format("#%d %d\n", tc, max);
			
		}
	}	
}







