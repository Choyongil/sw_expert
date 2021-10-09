package acmicpc.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 중량_제한 {

	static int n, m, ans, start, end;
	static List<Node> list[];
	static class Node{
		int v, to;

		public Node(int v, int to) {
			super();
			this.v = v;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", to=" + to + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];
		
		for(int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		int maxV = 1;
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(c, b));
			list[b].add(new Node(c, a));
			
			maxV = Math.max(maxV, c);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken()); 
		
		ans = -1;
		
		binary(maxV);
		
		System.out.println(ans);
		
	}
	
	public static void binary(int maxV) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		boolean[] visited = new boolean[n + 1];
		
		int low = 1;
		int high = maxV;
		int mid = -1;
		
		while(low <= high) {
			
			queue.add(start);
			visited[start] = true;
			
			mid = (low + high) / 2;
			if(check(mid, queue, visited)) {
				ans = Math.max(ans, mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			
			queue.clear();
			Arrays.fill(visited, false);
		}
		
		
	}
	
	public static boolean check(int weight, Queue<Integer> queue, boolean[] visited) {
		
		while(!queue.isEmpty()) {
			
			int q = queue.poll();
			
			for(Node n : list[q]) {

				if(!visited[n.to] && n.v >= weight) {
					
					if(n.to == end) {
						return true;
					}
					
					queue.add(n.to);
					visited[n.to] = true;
				}
			}
			
		}
		
		return false;
	}
}
