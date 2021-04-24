package acmicpc.Gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3 {

	static class Point{
		int x;
		int t;
		public Point(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		boolean[] visited = new boolean[200001];
		int ans = 987654321;
		
		if(n >= k) ans = n - k;
		else {
			Queue<Point> queue = new LinkedList<Point>();
			
			queue.offer(new Point(n,0));
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				visited[p.x] = true;
				if(p.x == k) {
					ans = Math.min(ans, p.t);
				}
				
				if(p.x * 2 <= 100000 && !visited[p.x*2]) queue.offer(new Point(2 * p.x, p.t));
				if(p.x + 1 <= 100000 && !visited[p.x+1]) queue.offer(new Point(1 + p.x, p.t + 1));
				if(p.x - 1 >= 0 && !visited[p.x-1]) queue.offer(new Point(p.x - 1, p.t + 1));
				
			}
		}
		
		System.out.println(ans);
	}
	
}
