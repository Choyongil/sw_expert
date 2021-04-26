package acmicpc.Gold5;

import java.util.Scanner;

public class LCS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		int[][] lcs = new int[str1.length() + 1][str2.length() + 1];
		for(int i = 1 ; i <= str1.length() ; i++) {
			for(int j = 1 ; j <= str2.length() ; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
				}
			}
		}
		System.out.println(lcs[str1.length()][str2.length()]);
	}

}
