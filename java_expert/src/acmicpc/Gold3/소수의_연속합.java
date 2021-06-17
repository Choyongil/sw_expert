package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수의_연속합 {

	static List<Integer> list;
	static int n, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 에라토스테네스의_체 알고리즘
		List<Boolean> prime = new ArrayList<>();
		prime.add(false);
		prime.add(false);
		for(int i = 2 ; i <= n ; i++) {
			prime.add(true);
		}
		
		for(int i = 2 ; i*i <= n ; i++) {
			if(prime.get(i)) {
				for(int j = i * i ; j <= n ; j += i) {
					prime.set(j, false);
				}
			}
		}
		
		list = new ArrayList<>();
		for(int i = 2 ; i <= n ; i++) {
			if(prime.get(i)) {
				list.add(i);
			}
		}
		ans = 0;
		
		int startIdx = 0;
		int endIdx = 0;
		int sum = 0;
		
		// 투 포인터 알고리즘
		while(true) {
			
			if(sum >= n) {
				sum -= list.get(startIdx++);
			} else if(endIdx == list.size()) break;
			else {
				sum += list.get(endIdx++);
			}
			
			if(sum == n) ans++;
		}
		
		System.out.println(ans);
	}
}
