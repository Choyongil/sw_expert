package acmicpc.Silver3;

import java.util.Scanner;

// dp
public class ㅁ1로_만들기_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		for(int i = 2; i <= n ; i++) {
			int x = i % 2 == 0 ? (i / 2 == 1 ? 1 : arr[i / 2] + 1) : 98765321;
			int y = i % 3 == 0 ? (i / 3 == 1 ? 1 : arr[i / 3] + 1) : 98765321;
			int z = i - 1 == 1 ? 1 : (arr[i - 1] + 1);
			arr[i] = Math.min(x, Math.min(y, z));
		}
		System.out.println(arr[n]);
	}
}
