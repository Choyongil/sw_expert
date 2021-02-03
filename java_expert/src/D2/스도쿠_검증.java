package D2;

import java.util.Scanner;


public class 스도쿠_검증 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int[][] arr = new int[9][9];
			boolean ans = true;
			
			for (int i = 0; i < 9; i++){
				for (int j = 0 ; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			boolean[] check = new boolean[9];
			
			// 가로
			for (int i = 0 ; i < 9; i++) {
				check = new boolean[9];
				for (int j = 0 ; j < 9; j++) {
					if (check[arr[i][j] - 1]) {
						ans = false;
						break;
					}
					check[arr[i][j] - 1] = true;
				}
				if (!ans) {
					break;
				}
			}
			
			// 세로
			if(ans) {
				for (int i = 0 ; i < 9; i++) {
					check = new boolean[9];
					for (int j = 0 ; j < 9; j++) {
						if (check[arr[j][i] - 1]) {
							ans = false;
							break;
						}
						check[arr[j][i] - 1] = true;
					}
					if (!ans) {
						break;
					}
				}
				
			}
			
			// 3x3
			if (ans) {
				for ( int i = 0 ; i < 9; i += 3) {
					for (int j = 0 ; j < 9; j += 3) {
						check = new boolean[9];
						for (int k = 0; k < 3; k++) {
							for (int l = 0; l < 3; l++) {
								if (check[arr[i + k][j + l] - 1]) {
									ans = false;
									break;
								}
								check[arr[i+k][j+l] - 1] = true;
							}
							if (!ans) {
								break;
							}
						}
						if (!ans) {
							break;
						}
					}
					if (!ans) {
						break;
					}
				}
			}
			
			int answer = ans ? 1 : 0;
			System.out.println("#"+ tc + " " + answer);
			
		}
	}	
}