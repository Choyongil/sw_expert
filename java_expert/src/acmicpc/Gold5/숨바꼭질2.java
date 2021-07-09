package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 숨바꼭질2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 987654321;
		int ansCnt = 0;
		int[] cnt = new int[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		cnt[n] = 1;
		
		if(n >= m) {
			System.out.println(((n - m) + "\n1"));
		} else {
		
			while(!queue.isEmpty()) {
				
				int q = queue.poll();
	
				if( ans < cnt[q] ) break;
				
				for(int i = 0 ; i < 3 ; i++) {
					int next;
					
					if(i == 0) next = q + 1;
					else if(i == 1) next = q - 1;
					else next = q * 2;
					
					if(next < 0 || next > 100000) continue;
					
					if(next == m) {
						ans = cnt[q];
						ansCnt++;
					}
					
					if(cnt[next] == 0 || cnt[next] == cnt[q] + 1) {
						queue.add(next);
						cnt[next] = cnt[q] + 1;
					}
				}
				
			}
			System.out.println(ans + "\n" + ansCnt);
		}
	}
}
