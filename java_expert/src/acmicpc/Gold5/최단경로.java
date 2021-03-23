package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최단경로 {

	static class Node implements Comparable<Node>{
		
		int to;
		int weight;
		Node next;
		
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		
		public Node(int to) {
			this.to = to;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + ", next=" + next + "]";
		}
		
	}
	
	static Node[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		adjList = new Node[v+1];
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[f] = new Node(t, w, adjList[f]);
		}
		
		int[] d = new int[v+1];
		boolean[] visited = new boolean[v+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[k] = 0;
		visited[0] = true;
		
		for(int i = 1 ; i <= v ; i++) {
			
			int min = Integer.MAX_VALUE;
			int minidx = 0;
			
			for(int j = 1 ; j <= v ; j++) {
				if(!visited[j] && min > d[j]) {
					min = d[j];
					minidx = j;
				}
			}
			
			for(Node cur = adjList[minidx] ; cur != null ; cur = cur.next) {
				if(!visited[cur.to] && cur.weight != 0 && d[cur.to] > d[minidx] + cur.weight) {
					d[cur.to] = d[minidx] + cur.weight;
				}
			}
			
			visited[minidx] = true;
		}
		for(int i = 1 ; i <= v ; i++) {
			sb.append(d[i] == Integer.MAX_VALUE ? "INF" : d[i]).append("\n");
		}
		System.out.println(sb);
	}
}
