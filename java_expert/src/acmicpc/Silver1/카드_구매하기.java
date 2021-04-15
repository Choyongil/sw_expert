package acmicpc.Silver1;

import java.util.Scanner;

public class 카드_구매하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i = 1 ; i <= n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				arr[i] = Math.max(arr[i], arr[i-j] + arr[j]);
			}
		}
		System.out.println(arr[n]);
		sc.close();
	}
}
