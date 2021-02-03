package D2;

import java.util.Scanner;


public class 초심자의_회문검사 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for (int i = 1; i <= T; i++) {
			String s = sc.next();
			func(s, i);
		}
	}
	
	public static void func(String str, int i) {
		int l = str.length();
		for ( int j = 0; j < l/2; j++) {
			if (str.charAt(j) != str.charAt(l-1-j)) {
				System.out.println("#" + i + " " + 0);
				return;
			}
		}
		System.out.println("#" + i + " " + 1);
		return;
	}
}
