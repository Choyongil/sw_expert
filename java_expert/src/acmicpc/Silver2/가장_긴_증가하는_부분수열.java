package acmicpc.Silver2;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 가장_긴_증가하는_부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int a = 0;
		int ans = 0;
		for(int i = 1 ; i < n ; i++) {
			if (arr[i] == 0) continue;
			int day = arr[i] - arr[i-1];
			ans += 1;
			for(int j = i + 1 ; j < n ; j++) {
				if((arr[j] - 1 ) % day == 0) {
					arr[j] = 0;
				}
			}
		}
	}
}
