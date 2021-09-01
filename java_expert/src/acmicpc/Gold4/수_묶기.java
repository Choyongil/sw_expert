package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수_묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int minus = 0;
		int plus = 0;
		int zero = 0;
		int one = 0;
		int x;
		for(int i = 0 ; i < n ; i++) {
			x = Integer.parseInt(br.readLine());
			pq.add(x);
			
			if(x < 0) minus++;
			else if(x == 1) one++;
			else if(x > 0) plus++;
			else zero++;
		}
		
		int ans = 0;
		
		int a, b;
		
		// 음수 더하기
		for(int i = 0 ; i < minus / 2 ; i++) {
			a = pq.poll();
			b = pq.poll();
			ans += a * b;
		}
		
		// 음수가 하나 남아있고 0이 1개 이상 있을 때
		// 음수를 0으로 바꾸어준다.
		if(minus % 2 == 1 && zero > 0) {
			zero--;
			pq.poll();
			pq.poll();
		}
		
		// 두 양수의 곱을 더하기 전까지 ans에 더한다.
		// 1을 제외한 양수만을 더해준다.
		while(pq.size() != plus) {
			ans += pq.poll();
		}
		
		if(plus % 2 == 1) ans += pq.poll();
		
		for(int i = 0 ; i < plus / 2 ; i++) {
			a = pq.poll();
			b = pq.poll();
			ans += a * b;
		}
		
		System.out.println(ans);
		
	}
}
