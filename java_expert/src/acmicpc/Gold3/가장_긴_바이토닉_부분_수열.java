package acmicpc.Gold3;

import java.util.Arrays;
import java.util.Scanner;

public class 가장_긴_바이토닉_부분_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] min = new int[n];
		int[] max = new int[n];
		min[0] = 1;
		max[n-1] = 1;
		Arrays.fill(min, 1);
		Arrays.fill(max, 1);
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(arr[i] > arr[j]) min[i] = Math.max(min[i], min[j] + 1);
				if(arr[n-1-i] > arr[n-1-j]) max[n-1-i] = Math.max(max[n-1-i], max[n-1-j] + 1);
			}
		}
		int ans = 0;
		for(int i = 0 ; i < n ; i++) {
			ans = Math.max(ans, max[i] + min[i] - 1);
		}
		System.out.println(ans);
	}
}
