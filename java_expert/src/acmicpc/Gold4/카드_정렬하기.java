package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기 {

	static int n, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
//		if(n == 1) System.out.println(0);
//		else {
			ans = 0;
			
			while(pq.size() != 1) {
				int a = pq.poll();
				int b = pq.poll();
				
				ans += (a + b);
				pq.add(a + b);
			}
			
			System.out.println(ans);
//		}
		
	}
}
