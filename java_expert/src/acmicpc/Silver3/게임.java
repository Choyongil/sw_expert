package acmicpc.Silver3;

import java.util.Scanner;

public class 게임 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		long z = b * 100 / a;
		long ans = 0;
		
		if(z >= 99) {
			System.out.println(-1);
			System.exit(0);
		}
		
		long low = 1l;
		long high = 1000000000l;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			long tmp = (b + mid) * 100 / (a + mid);
			
			if( tmp <= z) {
				low = mid + 1;
			}
			else {
				ans = mid;
				high = mid - 1;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
