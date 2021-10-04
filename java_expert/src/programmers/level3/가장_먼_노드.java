package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {

	static class Node{
		int x, cnt;
		
		public Node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		
		int[][] edge = new int[7][2];
		
		List<Integer>[] list = new ArrayList[7];
		for(int i = 1 ; i <= 6 ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int[] a : edge) {
			int from = a[0];
			int to = a[1];
			
			list[from].add(to);
			list[to].add(from);
			
		}
		
		boolean[] visited = new boolean[7];
		visited[1] = true;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		
		int ans = 0;
		int maxDist = 0;
		while(!queue.isEmpty()) {
			
			Node q = queue.poll();
			int cur = q.x;
			
			if(maxDist == q.cnt) {
				ans++;
			} else if(maxDist < q.cnt){
				maxDist = q.cnt;
				ans = 1;
			}
			
			for(int i = 0 ; i < list[cur].size() ; i++) {
				int next = list[cur].get(i);
				if(visited[next]) continue;
				
				queue.add(new Node(next, q.cnt + 1));
				visited[next] = true;
			}
		}
		System.out.println(ans);
	}
}
