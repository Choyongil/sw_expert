package D2;

import java.util.Scanner;


public class 날짜_계산기 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] date = {0, 31, 28, 31, 30 ,31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int i = 1; i <= T; i++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			int sum = d2 - d1 + 1;
			for (int j = m1; j < m2; j++) {
				sum += date[j];
			}
			System.out.format("#%d %d\n", i, sum);
		}
	}
}