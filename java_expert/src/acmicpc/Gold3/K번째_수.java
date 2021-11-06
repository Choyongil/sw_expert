package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째_수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long k = Integer.parseInt(br.readLine());
		
		long left = 1;
		long right = k;
		long cnt = 0;
		long ans = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			cnt = 0;
			for(int i = 1 ; i <= n ; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if(cnt >= k) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
		}
		System.out.println(ans);
	}
}
