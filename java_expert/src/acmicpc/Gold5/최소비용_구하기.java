package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용_구하기 {

static class Node implements Comparable<Node>{
		
		int to;
		int weight;
		
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			
			return this.weight - o.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] adjList = new ArrayList[v+1];
		
		for(int i = 0 ; i <= v ; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[f].add(new Node(t, w));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int f = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] d = new int[v+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		d[f] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(f,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.weight > d[cur.to]) {
				continue;
			}
			
			for(int i = 0 ; i < adjList[cur.to].size() ; i++) {
				Node n = adjList[cur.to].get(i);
				if( d[n.to] > cur.weight + n.weight) {
					d[n.to] = cur.weight + n.weight;
					pq.add(new Node(n.to, d[n.to]));
				}
			}
			
		}
		
		System.out.println(d[t]);
	}
}
