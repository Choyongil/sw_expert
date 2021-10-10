package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 별자리_만들기 {

	static int n, parent[];
	static List<Node> list;
	static class Node{
		double x, y;

		public Node(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	static class Dist implements Comparable<Dist>{
		int from, to;
		double dist;

		public Dist(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Dist o) {
			if(dist > o.dist) return 1;
			else return -1;
		}

		@Override
		public String toString() {
			return "Dist [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();

		for(int i = 0 ; i < n ; i++) {
			
			st = new StringTokenizer(br.readLine());
					
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
		
			list.add(new Node(x, y));
		
		}
		
		PriorityQueue<Dist> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = i + 1 ; j < n ; j++) {
				
				Node from = list.get(i);
				Node to = list.get(j);
				
				pq.add(new Dist(i, j, Math.sqrt(Math.pow((from.x - to.x), 2) + Math.pow((from.y - to.y), 2))));
				
			}
		}

		double ans = 0;
		parent = new int[n];
		parent();
		
		while(!pq.isEmpty()) {
			
			Dist d = pq.poll();
			
			if(findSet(d.from) != findSet(d.to)) {
				union(d.from, d.to);
				ans += d.dist;
			}
			
		}
			
		
		System.out.printf("%.2f", ans);
	}
	
	public static void parent() {
		for(int i = 0 ; i < n ; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = findSet(parent[x]);
	}
	
	public static void union(int a, int b) {
		
		int aSet = findSet(a);
		int bSet = findSet(b);
		
		if(aSet == bSet) return;
		
		parent[bSet] = aSet;
		
	}
}
