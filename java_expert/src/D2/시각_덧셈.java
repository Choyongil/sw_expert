package D2;

import java.util.Scanner;


public class 시각_덧셈 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int h = h1 + h2;
			int m = m1 + m2;
			if (m >= 60 ) {
				m -= 60;
				h += 1;
			}
			if (h > 12) {
				h -= 12;
			}
			System.out.format("#%d %d %d\n",tc,h,m);
		}
	}	
}







