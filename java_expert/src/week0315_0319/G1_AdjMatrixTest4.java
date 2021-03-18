package week0315_0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import week0315_0319.G1_AdjMatrixTest3.Node;

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
public class G1_AdjMatrixTest4 {
	
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
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = null;
		
		for(int i = 0 ; i < C ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		visited = new boolean[N];
		
		bfs();
		dfs(0);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		int start = 0;
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 현재 정점에 관련한 처리
			System.out.println((char) (current+65));
			
			//인접 정점 탐색
			for(int temp : adjList[current]) {
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
			
		}
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		System.out.println((char)(current+65));
		
		for(int temp : adjList[current]) {
			if(!visited[temp]) {
				dfs(temp);
			}
		}
	}
}
