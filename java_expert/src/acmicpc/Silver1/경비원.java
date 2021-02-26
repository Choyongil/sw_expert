package acmicpc.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int d = 0;
		int x = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int l = (h + w) * 2;
		for(int i = 0 ; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			if(d == 1) arr[i] = x;
			else if(d == 2) arr[i] = (w + h + ( w - x ));
			else if(d == 3) arr[i] = (2*w + h+(h - x));
			else arr[i] = w + x;
		}
		int ans = 0;
		
		for(int i = 0 ; i < n ; i++) {
			int tmp = Math.abs(arr[n] - arr[i]);
			ans += Math.min(tmp, l - tmp);
		}
		System.out.println(ans);
		
		
	}
}
