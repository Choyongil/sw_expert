package D2;

import java.util.Scanner;


public class 지그재그_숫자 {
	 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for ( int i = 1; i <= T; i++) {
			int sum = 0;
			int n = sc.nextInt();
			for ( int j = 1; j <= n; j++) {
				if (j % 2 == 0) {
					sum -= j;
				}else {
					sum += j;
				}
			}
			
			System.out.println("#" + i + " " + sum); 
		}
	}
}
