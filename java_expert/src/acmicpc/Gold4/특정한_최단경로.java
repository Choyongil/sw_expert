package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한_최단경로 {

	static class Point implements Comparable<Point>{
		int to;
		int weight;
		
		public Point(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return weight - o.weight;
		}

		@Override
		public String toString() {
			return "Point [to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
	
	static int v, e;
	static ArrayList<Point>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[v+1];
		
		for(int i = 0 ; i <= v ; i++) {
			list[i] = new ArrayList<Point>();
		}
		
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[f].add(new Point(t,w));
			list[t].add(new Point(f,w));
		}
		
		st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		long answer1 = 0;  // 1->v1->v2->n
        answer1 += go(1, f);
        answer1 += go(f, t);
        answer1 += go(t, v);
        long answer2 = 0; // 1->v2->v1->n
        answer2 += go(1, t);
        answer2 += go(t, f);
        answer2 += go(f, v);
        if (Math.min(answer1, answer2) >= Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(answer1, answer2));
		
	}
	
	private static int go(int s, int e) {
		int[] d= new int[v + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(s, 0));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.weight > d[cur.to]) continue;
			
			for(int i = 0 ; i < list[cur.to].size() ; i++) {
				Point next = list[cur.to].get(i);
				
				if(cur.weight + next.weight < d[next.to]) {
					d[next.to] = cur.weight + next.weight; 
					pq.add(new Point(next.to, d[next.to]));
				}
			}
		}
		return d[e];
	}
}

/*
2 0
1 2

4 2
1 2 2
1 4 3
2 4
*/