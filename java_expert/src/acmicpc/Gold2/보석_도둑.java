package acmicpc.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석_도둑 {

	static int n, k;
	static class jewelry implements Comparable<jewelry>{
		int m, v;

		public jewelry(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(jewelry o) {
			if(m == o.m) return o.v - v;
			return m - o.m;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		jewelry[] list = new jewelry[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[i] = new jewelry(m,v);
		}
		
		List<Integer> bags = new ArrayList<>();
		for(int i = 0 ; i < k ; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}
		Arrays.sort(list);
		Collections.sort(bags);
		long ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
		for(int i = 0, j = 0 ; i < k ; i++) {
			while(j < n && list[j].m <= bags.get(i)) {
				pq.add(list[j++].v);
			}
			
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.println(ans);
	}
}

/*

4 4
1 100
2 200
13 300
10 500
10
10
10
14

*/