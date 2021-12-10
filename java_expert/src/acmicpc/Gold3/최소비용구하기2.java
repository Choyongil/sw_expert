package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기2 {

	static int n;
	static List<Node>[] list;
	static class Node{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		go(start, end);
		
	}
	
	public static void go(int s, int e) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
		pq.add(new Node(s, 0));
		
		int[] dist = new int[n + 1];
		Arrays.fill(dist, 987654321);
		dist[s] = 0;
		
		boolean[] visited = new boolean[n + 1];
		
		int[] before = new int[n + 1];
		before[s] = -1;
		
		while(!pq.isEmpty()) {
			
			Node q = pq.poll();
			
			if(visited[q.to]) continue;
			
			visited[q.to] = true;
			
			for(Node next : list[q.to]) {
				
				if(dist[next.to] > dist[q.to] + next.weight) {
					dist[next.to] = dist[q.to] + next.weight;
					pq.add(new Node(next.to, dist[next.to]));
					
					before[next.to] = q.to;
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(dist[e])).append("\n");
		
		int cnt = 1;
		int idx = e;
		String route = "" + e;
		while(before[idx] != -1) {
			cnt++;
			idx = before[idx];
			route = idx + " " + route;
		}
		
		sb.append(Integer.toString(cnt)).append("\n").append(route);
		System.out.println(sb);
		
	}
}
