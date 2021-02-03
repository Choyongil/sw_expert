package D2;

import java.util.Scanner;


public class 가랏_RC카 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			
			int v = 0;
			int t = sc.nextInt();
			int s = 0;
			int a = 0;
			int b = 0;
			
			for (int j = t; j > 0; j--) {
				
				a = sc.nextInt();
				
				if ( a != 0) {
					b = sc.nextInt();
				}
				
				if (a == 1) {
					v += b;
					s += v;
				} else if ( a == 0 ){
					s += v;
				} else {
					v -= b;
					if ( v < 0 ) {
						v = 0;
					} else {
						s += v;
					}
				}
			}
			
			System.out.format("#%d %d\n",i,s);

		}
	}	
}
