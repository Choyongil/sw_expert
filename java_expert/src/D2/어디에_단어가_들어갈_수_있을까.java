package D2;

import java.util.Scanner;


public class 어디에_단어가_들어갈_수_있을까 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] board = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for ( int k = 0; k < N; k++) {
					board[j][k] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k <= N-K ; k++) {
					
					boolean f = false;
					if (( k == 0 || board[j][k-1] == 0) && ((k + K < N && board[j][k+K] == 0) || (k + K == N))) {		// horizon
						f = true;
						for (int l = 0; l < K; l++) {
							if( board[j][k+l] == 0) {
								f = false;
								break;
							}
						}
					}
					
					if (f) {
						cnt += 1;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int j = 0; j <= N-K ; j++) {
					boolean f = false;
					if (( j == 0 || board[j - 1][k] == 0) && ((j + K < N && board[j + K][k] == 0) || (j + K == N))) {
//						
						f = true;
						for (int l = 0; l < K; l++) {
							if( board[j+l][k] == 0) {
								f = false;
								break;
							}
						}
					}
					
					if (f) {
						cnt += 1;
					}
				}
			}
			
			System.out.format("#%d %d\n",i,cnt);
		}
	}
}