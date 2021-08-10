package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {

	static int n, farthest_idx, ans;
	static List<Node>[] list;
	static boolean[] visited;
	static class Node {
		int to, cost;

		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		if(n == 1) {
			System.out.println(0);
			return;
		}
		
		list = new ArrayList[n+1];
		
		// 모든 list 에 arrayList 만들기
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		int a, b, c;
		for(int i = 1 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		ans = 0;
//		for(int i = 1 ; i <= n ; i++) {
//			visited = new boolean[n + 1];
//			diameter(i, 0);
//		}
		
		// 가장 먼 노드
		farthest_idx = -1;
		visited = new boolean[n + 1];
		visited[1] = true;
		diameter(1, 0);
		
		visited = new boolean[n + 1];
		visited[farthest_idx] = true;
		diameter(farthest_idx, 0);
		
		System.out.println(ans);
	}
	
	public static void diameter(int from, int sum) {
		
		visited[from] = true;
		
		if(sum > ans) {
			ans = sum;
			farthest_idx = from;
		}
		
		for(Node n : list[from]) {
			if(!visited[n.to]) diameter(n.to, sum + n.cost);
		}
		
	}
}
