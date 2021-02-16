package week0215_0219;

import java.util.Scanner;

public class divide {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		//log(2) n 
		System.out.println(exp(x,y));
				
	}
	
	public static long exp(long x, long y) {
		
		if( y == 1) return x;
		
		long r = exp(x, y/2);
		long result = r*r;
		
		if ( y % 2 == 1) {
			result *= x;
		}
		return result;
	}
}
