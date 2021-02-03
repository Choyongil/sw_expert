package D2;

import java.util.Scanner;


public class 쉬운_거스름돈 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			System.out.format("#%d\n",tc);
			
			int N = sc.nextInt();
			
			int[] arr = { 50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int idx = 0;
			int q = 0;
			
			while (idx < 8) {
			
				q = 0;
				
				if ( N >= arr[idx] ) {
					q = N / arr[idx];
					N -= arr[idx] * q;
				}
				idx += 1;
				System.out.print(q + " ");
			}
			System.out.println();
		}
	}	
}