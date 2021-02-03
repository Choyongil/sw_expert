package D2;

import java.util.Scanner;


public class 최빈수_구하기 {
	 
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int t = sc.nextInt();
			int[] N = new int[1000];
			
			for(int i = 0; i < 1000; i++) {
				N[sc.nextInt()] += 1;
			}
			int max = -1;
			int ans = 0;
			for (int i = 0; i < 1000; i++) {
				if (max <= N[i]) {
					max = N[i];
					ans = i;
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}	
}
