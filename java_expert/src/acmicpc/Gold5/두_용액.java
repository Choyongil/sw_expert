package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = n - 1;
		int ans = Integer.MAX_VALUE;
		int result1 = 0;
		int result2 = 0;
		
		while(start != end) {

			if(ans > Math.abs(arr[start] + arr[end])) {
				result1 = arr[start];
				result2 = arr[end];
				ans = Math.abs(arr[start] + arr[end]);
			} else if(arr[start] + arr[end] > 0) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(result1 + " " + result2);
	}
}

