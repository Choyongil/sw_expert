package D2;

import java.util.Arrays;
import java.util.Scanner;


public class 간단한_369 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String[] s = Integer.toString(i).split("");
			
			
			if (Arrays.stream(s).anyMatch("3"::equals) || Arrays.stream(s).anyMatch("6"::equals) || Arrays.stream(s).anyMatch("9"::equals)) {
				
				for (int j = 0; j < s.length; j++) {
					if (s[j].equals("3") || s[j].equals("6") || s[j].equals("9")) {
						System.out.print("-");
					}
				}
				System.out.print(" ");
				
			} else System.out.print(i + " ");
		}
	}	
}

