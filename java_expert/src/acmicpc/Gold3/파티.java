package acmicpc.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파티{

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
			return this.weight - o.weight;
		}
	}
	
	static int n, m, x;
	static Point[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		ArrayList<Point>[]arr = new ArrayList[n+1];
		
		for(int i = 0 ; i <= n ; i++) {
			arr[i] = new ArrayList<Point>();
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[f].add(new Point(t,w));
		}
		
		int[] sum = new int[n+1];
		for(int num = 1 ; num <= n ; num++) {
			Queue<Point> queue = new LinkedList<Point>();
			queue.add(new Point(num,0));
			
			int[] d = new int[n+1];
			Arrays.fill(d, 987654321);
			d[num] = 0;
			
			while(!queue.isEmpty()) {
				
				Point q = queue.poll();
				int to = q.to;
				
				for(int i = 0 ; i < arr[to].size() ; i++) {
					Point n = arr[to].get(i);
					if(d[to] + n.weight < d[n.to]) {
						d[n.to] = d[to] + n.weight;
						queue.add(new Point(n.to, n.weight));
					}
				}
				
			}
			
			if(x == num) {
				for(int i = 1 ; i <= n ; i++) {
					sum[i] += d[i];
				}
			} else {
				sum[num] += d[x];
			}
		}

		int ans = 0;
		for(int a : sum) ans = Math.max(a, ans);
		System.out.println(ans);
	}
}
