package acmicpc.Silver3;


import java.util.Scanner;

public class nx2타일링 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i = 3; i <= n ; i++) {
			arr[i] = (arr[i-2] + arr[i-1]) % 10007;
		}
		System.out.println(arr[n]);
		sc.close();
	}
}
