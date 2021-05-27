package acmicpc.Gold5;

import java.util.Arrays;
import java.util.Scanner;

public class 합분해 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long[][] arr = new long[2][n+1];
		for(int i = 0 ; i <= n ; i++) {
			arr[0][i] = 1;
		}
		arr[1][0] = 1;
		if( k == 1 ) System.out.println(1);
		else {
			for(int i = 1 ; i < k ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					arr[i % 2][j] = (arr[i % 2][j - 1] + arr[(i + 1) % 2][j]) % 1000000000;
				}
			}
			System.out.println(arr[(k+1)%2][n]);
		}
	}
}
