package D2;

import java.util.Scanner;


public class 수도_요금_경쟁 {
	 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for ( int i = 1; i <= T; i++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = P * W;
			int B = 0;
			
			if ( W <= R ) {
				B = Q;
			}else {
				B = Q + S * (W - R);
			}
			int ans = A < B ? A : B;
			
			System.out.println("#" + i + " " + ans);
		}
	}
}
