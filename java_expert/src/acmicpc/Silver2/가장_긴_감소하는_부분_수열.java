package acmicpc.Silver2;

import java.util.Arrays;
import java.util.Scanner;

public class 가장_긴_감소하는_부분_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 1;
		int[] min = new int[n];
		Arrays.fill(min, 1);
		for(int i = n-2 ; i >= 0 ; i--) {
			for(int j = n-1 ; j > i ; j--) {
				if(arr[i] > arr[j]) min[i] = Math.max(min[i], min[j] + 1);
			}
			ans = Math.max(ans, min[i]);
		}
		System.out.println(ans);
	}
}
