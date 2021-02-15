package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가_만든_맛있는_음식 {
	
	static long[] numbers;
	static long[] input;
	static int n;
	static long ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] sin = new long[n];
		long[] seun = new long[n];
		numbers = new long[n];
		input = new long[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sin[i] = Long.parseLong(st.nextToken());
			seun[i] = Long.parseLong(st.nextToken());
			input[i] = i;
		}
		ans = Long.MAX_VALUE;
		for(int i = 1 ; i < (int) Math.pow(2, n) ; i++) {
			long a = 1;
			long b = 0;
			for(int j = 0 ; j < n ; j++) {
				if((i & (1 << j)) > 0) {
					a *= sin[j];
					b += seun[j];
				}
			}
			ans = Math.min(ans,  Math.abs(a - b));
		}	
		System.out.println(ans);
	}
}
