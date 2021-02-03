package D2;

import java.util.Scanner;


public class 패턴_마디의_길이 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
				
		for (int i = 1; i <= T; i++) {
			String s = sc.next();
			
			for ( int j = 1; j < s.length()/2; j++) {
				if ( s.substring(0, j).equals(s.substring(j, j+j))) {
					System.out.format("#%d %d\n",i,j);
					break;
				}
				
			}
			
		}
	}
}
