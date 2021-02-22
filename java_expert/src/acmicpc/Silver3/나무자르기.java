package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
	
	static int n;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		long low = 0;
		long high = 0; 
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			high = Math.max(high, arr[i]);
		}
		
		long mid = (high + low)/2;
		long result = 0;
		while(low <= high) {
			mid = (high + low) / 2;
			long ans = check(mid);
			if(ans >= h) {
				if(result < mid) result = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(result);
		
	}
	public static long check(long mid) {
		long ans = 0;
		for(int i = 0 ; i < n ; i++) {
			ans += arr[i] - mid > 0 ? arr[i] - mid : 0;
		}
		return ans;
	}
	
}
