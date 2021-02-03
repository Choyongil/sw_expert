package D2;


import java.util.Scanner;


public class 숫자_배열_회전 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			System.out.println("#"+ i);
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int[][] ans1 = func(arr, N);
			int[][] ans2 = func(ans1, N);
			int[][] ans3 = func(ans2, N);
			
			for (int j = 0 ; j < N; j++) {
				for (int k = 0 ; k < N; k ++) {
					System.out.print(ans1[j][k]);
				}
				System.out.print(" ");
				
				for (int k = 0 ; k < N; k ++) {
					System.out.print(ans2[j][k]);
				}
				System.out.print(" ");
				
				for (int k = 0 ; k < N; k ++) {
					System.out.print(ans3[j][k]);
				}
				System.out.println();
				
			}
		}
	}	
	
	public static int[][] func(int[][] a, int N) {
		
		int[][] b = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				b[j][N-i-1] = a[i][j];
			}
		}
		
		return b;
	}
}