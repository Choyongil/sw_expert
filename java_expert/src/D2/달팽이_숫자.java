package D2;


import java.util.Scanner;


public class 달팽이_숫자 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			System.out.println("#"+ i);
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			int[] tmp = new int[N];
			for (int j = 0 ; j < N; j++) {
				tmp[j] = j+1;
			}
			arr[0] = tmp;
			int direct = 1;		// 0 : l->r, 1 : u->d, 2 : r->l, 3 : d->u
			int n = N;
			int cur_x = 0;
			int cur_y = N-1;
			
			while(true) {
				try {	
					if (direct == 1) {
						n -= 1;
						for ( int j = 1 ; j <= n; j++) {
							cur_x += 1;
							arr[cur_x][cur_y] = arr[cur_x - 1][cur_y] + 1; 
						}
					}
					else if (direct == 2) {
						for ( int j = 1 ; j <= n; j++) {
							cur_y -= 1;
							arr[cur_x][cur_y] = arr[cur_x][cur_y + 1] + 1; 
						}
					}
					else if (direct == 3) {
						n -= 1;
						for ( int j = 1 ; j <= n; j++) {
							cur_x -= 1;
							arr[cur_x][cur_y] = arr[cur_x + 1][cur_y] + 1; 
						}
					}
					else if (direct == 0) {
						for ( int j = 1 ; j <= n; j++) {
							cur_y += 1;
							arr[cur_x][cur_y] = arr[cur_x][cur_y - 1] + 1; 
						}
					}
					
					direct += 1;
					if (direct == 4) {
						direct = 0;
					}
					if (N * N == arr[cur_x][cur_y]) {
						break;
					}
				}
				catch (Exception e) {
					System.out.println(e);
				}
					
			}
			for (int j = 0 ; j < N; j++) {
				for (int k = 0 ;k < N; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}
			
		}
	}	
}
