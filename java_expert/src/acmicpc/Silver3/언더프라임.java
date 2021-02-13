package acmicpc.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 언더프라임 {

	static Boolean[] list;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		list = new Boolean[100001];
		list[0] = false;
		list[1] = false;
		init();
		
		for(int i = n ; i <= m ; i++) {
			sum = 0;
			func(i);
			if (list[sum]) ans += 1;
		}
		
		System.out.println(ans);
	}
	
	public static void init() {
		for(int i = 2 ; i <= 100000 ; i++) {
			list[i] = true;
		}
		
		for(int i = 2 ; i <= Math.sqrt(100000) ; i++) {
			if(list[i]) {
				for(int j = i * i ; j <= 100000 ; j += i) {
					list[j] = false;
				}
			}
		}
		
	}
	
	public static void func(int n) {
		int q = 2;
		while(n != 1) {
			if( n % q == 0) {
				sum += 1;
				n /= q;
			}
			else q+=1;
		}
	}
}
