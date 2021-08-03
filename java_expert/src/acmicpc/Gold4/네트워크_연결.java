package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크_연결 {

	static int n, e, parents[];
	static class Point implements Comparable<Point>{
		int f, t, num;

		public Point(int f, int t, int num) {
			super();
			this.f = f;
			this.t = t;
			this.num = num;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			// 성표형 이거 compareTo 어케 쓴다고 했더라??
			return num > o.num ? 1 : -1;
		}

		@Override
		public String toString() {
			return "Point [f=" + f + ", t=" + t + ", num=" + num + "]";
		}
		
	}
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pq.add(new Point(a,b,c));
			
		}
		
		System.out.println(pq);
		
		make();
		int ans = 0;
		
		while(!pq.isEmpty()) {
			
			Point q = pq.poll();
			
			int f = findSet(q.f);
			int t = findSet(q.t);
			
			if(f == t) continue;
			
			union(f, t);
			ans += q.num;
			
		}
		
		System.out.println(ans);
		
		
	}
	
	public static void make() {
		for(int i = 1 ; i <= n ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x == parents[x]) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = parents[a];
		int bRoot = parents[b];
		
		if(aRoot == bRoot) return true;
		
		parents[aRoot] = bRoot;
		
		return false;
	}
}
