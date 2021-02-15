package D2;

import java.util.Scanner;


public class Base64_Decoder {
	 
	public static void main(String[] args) {

		String encoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int c = 1; c <= T; c++) {
			
			String S = sc.next();
			System.out.print("#"+ c + " ");
			
			for (int i = 0; i < S.length() / 4; i++) {
				String n = "";
				for (int j = 0; j < 4; j++) {
					n += String.format("%06d", Integer.parseInt(Integer.toBinaryString(
							encoding.indexOf(S.charAt(i*4 + j)))));
				}
				
				String s1 = Character.toString((char) func(n.substring(0, 8)));
				String s2 = Character.toString((char) func(n.substring(8, 16)));
				String s3 = Character.toString((char) func(n.substring(16, 24)));
				
				System.out.print(s1 + s2 + s3);
			}
			System.out.println();
		}
	}
	
	public static int func(String s) {
		int l = s.length();
		int sum = 0;
		int t = 1;
		for (int i = l-1; i >= 0; i--) {
			sum += Integer.parseInt(String.valueOf(s.charAt(i))) * t;
			t *= 2;
		}
		return sum;
	}
}
