package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의_지름 {

	static int n, longestNode, ans;
	static boolean[] visited;
	static List<Node>[] list;
	static class Node {
		int num, cost;

		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < n ; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			while(true) {
				
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) break;
				
				int b = Integer.parseInt(st.nextToken());
				
				list[num].add(new Node(a, b));
			}
			
			
		}
		
		longestNode = -1;
		calc(1);										// 임의의 노드 1에서 가장 먼 노드 찾기
		System.out.println(calc(longestNode));
		
		visited = new boolean[n + 1];
		ans = 0;
		dfs(1, 0);										// 임의의 노드 1에서 가장 먼 노드 찾기
		visited = new boolean[n + 1];
		dfs(longestNode, 0);
		System.out.println(ans);
	}
	
	// DFS
	public static void dfs(int start, int dist) {
		
		if(visited[start]) return;
		
		visited[start] = true;
		
		if(ans < dist) {
			ans = dist;
			longestNode = start;
		}
		
		for(Node n : list[start]) {
			dfs(n.num, dist + n.cost);
		}
		
	}
	
	// BFS
	public static int calc(int start) {
		
		int max = 0;
		
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			
			Node q = queue.poll();
			
			if(max < q.cost) {
				longestNode = q.num;
				max = Math.max(q.cost, max);
			}
			
			for(int j = 0 ; j < list[q.num].size() ; j++) {
				
				Node nextNode = list[q.num].get(j);
				
				if(visited[nextNode.num]) continue;
				
				visited[nextNode.num] = true;
				queue.add(new Node(nextNode.num, q.cost + nextNode.cost));
				
			}
		}
		
		return max;
	}
}

/*

예제

4
1 2 5 3 9 -1
2 1 5 -1
3 1 9 4 8 -1
4 3 8 -1

6
1 2 3 -1
2 1 3 5 3 3 5 -1
3 2 5 4 7 -1
4 3 7 -1
5 2 3 6 5 -1
6 5 5 -1

4
1 2 7 3 2 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1

5
1 2 7 3 2 5 10 -1
2 1 7 -1
3 1 2 4 3 -1
4 3 3 -1
5 1 10 -1

*/