package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕_배달2 {

	// dp
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n + 1];
		
		Arrays.fill(arr, 987654321);
		arr[3] = 1;
		if(n >= 5) arr[5] = 1;
		for(int i = 6 ; i <= n ; i++) {
			arr[i] = Math.min(arr[i-3] + 1, arr[i-5] + 1);
		}
		System.out.println(arr[n] >= 987654321? -1 : arr[n]);
		sc.close();
	}
}