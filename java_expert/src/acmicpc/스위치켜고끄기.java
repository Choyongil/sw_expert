package acmicpc;

import java.util.Scanner;

public class 스위치켜고끄기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] arr = new int[T+1];
		arr[0] = -1;
		
		for (int i = 1 ; i < T+1 ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int n = sc.nextInt();
		
		for( int l = 0 ; l < n ; l++) {
			int a = sc.nextInt();
			int m = sc.nextInt();
			
			if ( a == 1) {
				int t = m;
				while (m < T + 1) {
					
					arr[m] = (arr[m] + 1) % 2;
					
					m += t;
					
				}
			}
			else {
			
				int w2 = m;
				while (true) {
					
					if ( m - 1 > 0 && w2 + 1 <= T && arr[m - 1] == arr[w2 + 1]) {
						m -= 1;
						w2 += 1;
					} else break;
					
				}
				
				for(int i = m ; i <= w2 ; i++) {
					arr[i] = (arr[i] + 1) % 2;
				}
			}
		}
		
		for (int i = 1 ; i <= T ; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) System.out.println();
		}
		
	}
}

//80
//0 1 0 1 0 0 1 0 0 0 1 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 1 0 0 1 0 0 
//2
//1 1
//2 12
//
//1 0 1 0 1 1 0 1 1 0 1 0 1 0 0 1 1 0 1 1 
//1 0 1 0 1 1 0 1 1 1 0 1 0 1 0 1 1 0 1 1 
//1 0 1 0 1 1 0 1 1 1 0 1 0 1 0 1 1 0 1 1 
//1 0 1 0 1 1 0 1 1 1 0 1 0 1 0 1 1 0 1 1 
  