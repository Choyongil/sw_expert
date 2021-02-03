package D2;

import java.util.Scanner;


public class 파스칼의_삼각형 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				arr[i][0] = 1;
			}
			
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= i; j++) {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						break;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}	
}
