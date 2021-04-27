package acmicpc.Silver3;

import java.util.Scanner;

public class 제곱_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2 ; i <= n ; i++) {
			arr[i] = 987654321;
			for(int j = 1 ; j*j <= i ; j++) {
				arr[i] = Math.min(arr[i], 1 + arr[i-j*j]);
			}
		}
		System.out.println(arr[n]);
	}
}