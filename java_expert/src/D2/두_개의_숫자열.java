package D2;

import java.util.Scanner;


public class 두_개의_숫자열 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int arr1[] = new int[n1];
			int arr2[] = new int[n2];
			
			for (int j = 0; j < n1; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 0; j < n2; j++) {
				arr2[j] = sc.nextInt();
			}
			
			int sum, max = 0;
			
			for (int j = 0 ; j <= n1 - n2; j++) {
				sum = 0;
				for (int k = 0; k < n2; k++) {
					sum += arr1[j+k] * arr2[k];
				}
				if (sum > max) max = sum;
			}
			for (int j = 0 ; j <= n2 - n1; j++) {
				sum = 0;
				for (int k = 0; k < n1; k++) {
					sum += arr1[k] * arr2[k+j];
				}
				if (sum > max) max = sum;
			}
			System.out.format("#%d %d\n", i, max);
		}
	}
}
