package week0315_0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
*/

// LinkedList를 활용한 그래프 완전탐색
public class G1_AdjMatrixTest2 {
	
	static class Node{
		
		int vertext;
		Node next;
		
		public Node(int vertext, Node next) {
			super();
			this.vertext = vertext;
			this.next = next;
		}

		public Node(int vertext) {
			super();
			this.vertext = vertext;
		}

		@Override
		public String toString() {
			return "Node [vertext=" + vertext + ", next=" + next + "]";
		}
	}
	
	static int N;
	static Node[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		
		StringTokenizer st = null;
		
		for(int i = 0 ; i < C ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		bfs();
		
	}

	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		int start = 0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char) (current+65));
			
			for(Node temp = adjList[current] ; temp != null ; temp = temp.next ) {
				if(!visited[temp.vertext]) {
					visited[temp.vertext] = true;
					queue.offer(temp.vertext);
				}
			}
			
		}
		
	}
}