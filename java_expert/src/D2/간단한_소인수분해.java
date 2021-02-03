package D2;

import java.util.Scanner;


public class 간단한_소인수분해 {
	 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = {2, 3, 5, 7, 11};
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i);
			int n = sc.nextInt();
			int idx = 0;
			
			while (idx < 5) {
				int cnt = 0;
				while (true) {
					if (n % arr[idx] == 0) {
						n /= arr[idx];
						cnt += 1;
					} else {
						break;
					}
				}
				idx += 1;
				System.out.print(" " + cnt);
			}
			System.out.println();
		}	
	}
}

