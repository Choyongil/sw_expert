package acmicpc.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑_공준 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[1000001];
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2 ; i*i <= 1000000 ; i++) {
			if(!prime[i]) {
				for(int j = i*i ; j <= 1000000 ; j+= i) {
					prime[j] = true;
				}
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			int ans = 0;
			for(int i = n + 1 ; i <= 2*n ; i++) {
				if (!prime[i]) ans += 1;
			}
			sb.append(ans).append("\n");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}
}
