package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시_분할_계획 {

	static int n, parent[];
	static class Node implements Comparable<Node>{
		int from, to, cost;

		public Node(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int a, b, c;
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			pq.add(new Node(a, b, c));
		}
		
		parent = new int[n + 1];
		make();
		
		int ans = 0;
		int max = -1;		// 최소 스패닝 트리를 구성하는 비용 중 최댓값
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			int from = findSet(n.from);
			int to = findSet(n.to);
			
			if(from == to) continue;
			
			union(from, to);
			ans += n.cost;
			max = Math.max(max, n.cost);
			
		}
		
		// 총 거리 유지비의 합에서 가장 큰 값을 빼준다.
		ans -= max;
		
		System.out.println(ans);
		
		
	}
	
	public static void make() {
		for(int i = 1; i <= n ; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int aSet = findSet(a);
		int bSet = findSet(b);
		if(aSet == bSet) return false;
		
		parent[b] = aSet;
		return true;
	}
}
