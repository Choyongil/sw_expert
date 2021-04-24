package acmicpc.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최단경로V2 {

	static class Point implements Comparable<Point>{
		int to, weight;
		Point next;

		public Point(int to, int weight, Point next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Point o) {
			return weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		Point[] list = new Point[n+1]; 
		
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u] = new Point(v,w,list[u]);
		}
		
		int[] d = new int[n+1];
		Arrays.fill(d, 987654321);
		d[k] = 0;
		boolean[] visited = new boolean[n+1];
		
		for(int i = 1 ; i <= n ; i++) {
			int min = 987654321;
			int minIdx = 0;
			
			for(int j = 1 ; j <= n ; j++) {
				if(!visited[j] && min > d[j]) {
					min = d[j];
					minIdx = j;
				}
			}
			
			for(Point cur = list[minIdx] ; cur != null ; cur = cur.next) {
				if(!visited[cur.to] && d[minIdx] + cur.weight < d[cur.to]) {
					d[cur.to] = d[minIdx] + cur.weight;
				}
			}
			
			visited[minIdx] = true;
		}
		for(int x = 1 ; x <= n ; x++) {
			if(d[x] == 987654321) System.out.println("INF");
			else System.out.println(d[x]);
		}
		
	}
}
