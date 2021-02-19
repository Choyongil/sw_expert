package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[91];
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i = 3 ; i <= n ; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}
}
	