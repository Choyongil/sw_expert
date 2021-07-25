package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {

	static int V, E, parents[];
	static class Point implements Comparable<Point>{
		int from, to, n;

		public Point(int from, int to, int n) {
			super();
			this.from = from;
			this.to = to;
			this.n = n;
		}

		@Override
		public int compareTo(Point o) {
			return o.n >= this.n ? -1 : 1;
		}
	}
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V+1];
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Point(a,b,c));
		}
		
		make();
		int ans = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			int f = findSet(p.from);
			int t = findSet(p.to);
				
			if(f == t) continue;
			
			union(f, t);
			ans += p.n;
			
		}
		System.out.println(ans);
	}
	
	public static void make() {
		for(int i = 1 ; i <= V ; i++) parents[i] = i;
	}
	
	public static int findSet(int x) {
		if(x == parents[x]) return x;
		return parents[x] = findSet(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return true;
		
		parents[bRoot] = aRoot;
		return false;
	}
}
